/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.moasoft.universidade.model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author danil
 */
@Entity
@Table(name = "turma")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Turma.findAll", query = "SELECT t FROM Turma t")
    , @NamedQuery(name = "Turma.findByCodigo", query = "SELECT t FROM Turma t WHERE t.codigo = :codigo")
    , @NamedQuery(name = "Turma.findByAno", query = "SELECT t FROM Turma t WHERE t.ano = :ano")
    , @NamedQuery(name = "Turma.findBySemestre", query = "SELECT t FROM Turma t WHERE t.semestre = :semestre")})
public class Turma implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "codigo")
    private Integer codigo;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "ano")
    private int ano;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "semestre")
    private int semestre;
    
    @JoinTable(name = "matricula_turma", joinColumns = {
        @JoinColumn(name = "codigo_turma", referencedColumnName = "codigo")}, inverseJoinColumns = {
        @JoinColumn(name = "codigo_matricula", referencedColumnName = "codigo")})
    @ManyToMany
    private List<Matricula> matriculaList;
    
    @JoinColumn(name = "codigo_professor", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Professor professor;
    
    @JoinColumn(name = "codigo_disciplina", referencedColumnName = "codigo")
    @ManyToOne(optional = false)
    private Disciplina disciplina;

    public Turma() {
    }

    public Turma(Integer codigo) {
        this.codigo = codigo;
    }

    public Turma(Integer codigo, int ano, int semestre) {
        this.codigo = codigo;
        this.ano = ano;
        this.semestre = semestre;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public void setCodigo(Integer codigo) {
        this.codigo = codigo;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
        this.ano = ano;
    }

    public int getSemestre() {
        return semestre;
    }

    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    @XmlTransient
    public List<Matricula> getMatriculaList() {
        return matriculaList;
    }

    public void setMatriculaList(List<Matricula> matriculaList) {
        this.matriculaList = matriculaList;
    }

    public Professor getProfessor() {
        return professor;
    }

    public void setProfessor(Professor professor) {
        this.professor = professor;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public void setDisciplina(Disciplina disciplina) {
        this.disciplina = disciplina;
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
        if (!(object instanceof Turma)) {
            return false;
        }
        Turma other = (Turma) object;
        if ((this.codigo == null && other.codigo != null) || (this.codigo != null && !this.codigo.equals(other.codigo))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.moasoft.universidade.model.Turma[ codigo=" + codigo + " ]";
    }
    
}
