/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.moasoft.universidade.model;

import java.io.Serializable;
import java.math.BigDecimal;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author danil
 */
@Entity
@Table(name = "desempenho")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Desempenho.findAll", query = "SELECT d FROM Desempenho d")
    , @NamedQuery(name = "Desempenho.findByCodigoMatricula", query = "SELECT d FROM Desempenho d WHERE d.desempenhoPK.codigoMatricula = :codigoMatricula")})
public class Desempenho implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected DesempenhoPK desempenhoPK;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "ano")
    private int ano;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "semestre")
    private int semestre;
    
    @Max(value = 10)  //@Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "nota1")
    private BigDecimal nota1;
    
    @Max(value = 10)
    @Column(name = "nota2")
    private BigDecimal nota2;
    
    @Max(value = 10)
    @Column(name = "media")
    private BigDecimal media;
    
    @Max(value = 10)
    @Column(name = "nota_final")
    private BigDecimal notaFinal;
    
    @Column(name = "num_faltas")
    private Integer numFaltas;
    
    @JoinColumn(name = "codigo_matricula", referencedColumnName = "codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Matricula matricula;
    
    @JoinColumn(name = "codigo_disciplina", referencedColumnName = "codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Disciplina disciplina;

    public Desempenho() {
    }

    public Desempenho(DesempenhoPK desempenhoPK) {
        this.desempenhoPK = desempenhoPK;
    }

    public Desempenho(DesempenhoPK desempenhoPK, int ano, int semestre) {
        this.desempenhoPK = desempenhoPK;
        this.ano = ano;
        this.semestre = semestre;
    }

    public Desempenho(int codigoMatricula, int codigoDisciplina) {
        this.desempenhoPK = new DesempenhoPK(codigoMatricula, codigoDisciplina);
    }

    public DesempenhoPK getDesempenhoPK() {
        return desempenhoPK;
    }

    public void setDesempenhoPK(DesempenhoPK desempenhoPK) {
        this.desempenhoPK = desempenhoPK;
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

    public BigDecimal getNota1() {
        return nota1;
    }

    public void setNota1(BigDecimal nota1) {
        this.nota1 = nota1;
    }

    public BigDecimal getNota2() {
        return nota2;
    }

    public void setNota2(BigDecimal nota2) {
        this.nota2 = nota2;
    }

    public BigDecimal getMedia() {
        return media;
    }

    public void setMedia(BigDecimal media) {
        this.media = media;
    }

    public BigDecimal getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(BigDecimal notaFinal) {
        this.notaFinal = notaFinal;
    }

    public Integer getNumFaltas() {
        return numFaltas;
    }

    public void setNumFaltas(Integer numFaltas) {
        this.numFaltas = numFaltas;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
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
        hash += (desempenhoPK != null ? desempenhoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Desempenho)) {
            return false;
        }
        Desempenho other = (Desempenho) object;
        if ((this.desempenhoPK == null && other.desempenhoPK != null) || (this.desempenhoPK != null && !this.desempenhoPK.equals(other.desempenhoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.moasoft.universidade.model.Desempenho[ desempenhoPK=" + desempenhoPK + " ]";
    }
    
}
