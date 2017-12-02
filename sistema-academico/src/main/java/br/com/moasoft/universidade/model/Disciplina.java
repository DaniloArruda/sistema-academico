/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.moasoft.universidade.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
@Table(name = "disciplina")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Disciplina.findAll", query = "SELECT d FROM Disciplina d")
    , @NamedQuery(name = "Disciplina.findByCodigo", query = "SELECT d FROM Disciplina d WHERE d.codigo = :codigo")
    , @NamedQuery(name = "Disciplina.findByNome", query = "SELECT d FROM Disciplina d WHERE d.nome = :nome")
    , @NamedQuery(name = "Disciplina.findByPeriodo", query = "SELECT d FROM Disciplina d WHERE d.periodo = :periodo")})
public class Disciplina implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "nome")
    private String nome;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "periodo")
    private Integer periodo;
    
    @JoinTable(name = "disciplina_pre_requisito", joinColumns = {
        @JoinColumn(name = "codigo_disciplina", referencedColumnName = "codigo")}, inverseJoinColumns = {
        @JoinColumn(name = "codigo_disciplina_pre_requisito", referencedColumnName = "codigo")})
    @ManyToMany(fetch = FetchType.EAGER)
    private List<Disciplina> disciplinasPreRequisito;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "disciplina")
    private List<DisciplinaCurso> disciplinaCursoList;
    
    @JoinColumn(name = "codigo_departamento", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Departamento departamento;
    
    public Disciplina() {
        this.disciplinaCursoList = new ArrayList<>();
        this.disciplinasPreRequisito = new ArrayList<>();
    }

    public Disciplina(Integer codigo) {
        this.codigo = codigo;
        this.disciplinaCursoList = new ArrayList<>();
        this.disciplinasPreRequisito = new ArrayList<>();
    }

    public Disciplina(Integer codigo, String nome, int periodo) {
        this.codigo = codigo;
        this.nome = nome;
        this.periodo = periodo;
        this.disciplinaCursoList = new ArrayList<>();
        this.disciplinasPreRequisito = new ArrayList<>();
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

    public Integer getPeriodo() {
        return periodo;
    }

    public void setPeriodo(Integer periodo) {
        this.periodo = periodo;
    }

    @XmlTransient
    public List<Disciplina> getDisciplinasPreRequisito() {
        return disciplinasPreRequisito;
    }

    public void setDisciplinasPreRequisito(List<Disciplina> disciplinasPreRequisito) {
        this.disciplinasPreRequisito = disciplinasPreRequisito;
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
    
    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigo != null ? codigo.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Disciplina)) {
            return false;
        }
        Disciplina other = (Disciplina) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.moasoft.universidade.model.Disciplina[ codigo=" + codigo + " ]";
    }
    
}
