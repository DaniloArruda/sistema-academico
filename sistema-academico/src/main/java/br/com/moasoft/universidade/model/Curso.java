/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.moasoft.universidade.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author danil
 */
@Entity
@Table(name = "curso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Curso.findAll", query = "SELECT c FROM Curso c")
    , @NamedQuery(name = "Curso.findByCodigo", query = "SELECT c FROM Curso c WHERE c.codigo = :codigo")
    , @NamedQuery(name = "Curso.findByNome", query = "SELECT c FROM Curso c WHERE c.nome = :nome")})
public class Curso implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "nome")
    private String nome;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "num_creditos")
    private int numeroCreditos;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "num_total_disciplinas_obg")
    private int totalDisciplinasObrigatorias;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "carga_horaria")
    private int cargaHoraria;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "curso")
    private List<DisciplinaCurso> disciplinaCursoList;
    
    @JoinColumn(name = "codigo_departamento", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Departamento departamento;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "curso")
    private List<Matricula> matriculaList;

    public Curso() {
    }

    public Curso(Integer codigo) {
        this.codigo = codigo;
    }

    public Curso(Integer codigo, String nome, int numeroCreditos, int totalDisciplinasObrigatorias, int cargaHoraria) {
        this.codigo = codigo;
        this.nome = nome;
        this.numeroCreditos = numeroCreditos;
        this.totalDisciplinasObrigatorias = totalDisciplinasObrigatorias;
        this.cargaHoraria = cargaHoraria;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getNumeroCreditos() {
        return numeroCreditos;
    }

    public void setNumeroCreditos(int numeroCreditos) {
        this.numeroCreditos = numeroCreditos;
    }

    public int getTotalDisciplinasObrigatorias() {
        return totalDisciplinasObrigatorias;
    }

    public void setTotalDisciplinasObrigatorias(int totalDisciplinasObrigatorias) {
        this.totalDisciplinasObrigatorias = totalDisciplinasObrigatorias;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    @XmlTransient
    public List<DisciplinaCurso> getDisciplinaCursoList() {
        return disciplinaCursoList;
    }

    public void setDisciplinaCursoList(List<DisciplinaCurso> disciplinaCursoList) {
        this.disciplinaCursoList = disciplinaCursoList;
    }

    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    @XmlTransient
    public List<Matricula> getMatriculaList() {
        return matriculaList;
    }

    public void setMatriculaList(List<Matricula> matriculaList) {
        this.matriculaList = matriculaList;
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
        if (!(object instanceof Curso)) {
            return false;
        }
        Curso other = (Curso) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.moasoft.universidade.model.Curso[ codigo=" + codigo + " ]";
    }
    
}
