/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.moasoft.universidade.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author danil
 */
@Entity
@Table(name = "matricula")
@Inheritance(strategy = InheritanceType.JOINED)
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Matricula.findAll", query = "SELECT m FROM Matricula m")
    , @NamedQuery(name = "Matricula.findByCodigo", query = "SELECT m FROM Matricula m WHERE m.codigo = :codigo")
    , @NamedQuery(name = "Matricula.findByMatricula", query = "SELECT m FROM Matricula m WHERE m.matricula = :matricula")})
public class Matricula implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(name = "matricula", columnDefinition = "char(8)")
    private String matricula;
    
    @Max(value = 10)  // @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "coeficiente_rendimento")
    private BigDecimal coeficienteRendimento;
    
    @ManyToMany(mappedBy = "matriculaList")
    private List<Turma> turmaList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "matricula")
    private List<Desempenho> desempenhoList;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "matricula")
    private List<HistoricoMatricula> disciplinasCursadas;
    
    @JoinColumn(name = "codigo_aluno", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Aluno aluno;
    
    @JoinColumn(name = "codigo_curso", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Curso curso;
    

    public Matricula() {
    }

    public Matricula(Integer codigo) {
        this.codigo = codigo;
    }

    public Matricula(Integer codigo, String matricula) {
        this.codigo = codigo;
        this.matricula = matricula;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public BigDecimal getCoeficienteRendimento() {
        return coeficienteRendimento;
    }

    public void setCoeficienteRendimento(BigDecimal coeficienteRendimento) {
        this.coeficienteRendimento = coeficienteRendimento;
    }

    @XmlTransient
    public List<Turma> getTurmaList() {
        return turmaList;
    }

    public void setTurmaList(List<Turma> turmaList) {
        this.turmaList = turmaList;
    }

    @XmlTransient
    public List<Desempenho> getDesempenhoList() {
        return desempenhoList;
    }

    public void setDesempenhoList(List<Desempenho> desempenhoList) {
        this.desempenhoList = desempenhoList;
    }

    @XmlTransient
    public List<HistoricoMatricula> getDisciplinasCursadas() {
        return disciplinasCursadas;
    }

    public void setDisciplinasCursadas(List<HistoricoMatricula> disciplinasCursadas) {
        this.disciplinasCursadas = disciplinasCursadas;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
    }
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Matricula)) {
            return false;
        }
        Matricula other = (Matricula) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.moasoft.universidade.model.Matricula[ codigo=" + codigo + " ]";
    }
    
}
