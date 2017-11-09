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
@Table(name = "historico_matricula")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "HistoricoMatricula.findAll", query = "SELECT h FROM HistoricoMatricula h")
    , @NamedQuery(name = "HistoricoMatricula.findByCodigoMatricula", query = "SELECT h FROM HistoricoMatricula h WHERE h.historicoMatriculaPK.codigoMatricula = :codigoMatricula")})
public class HistoricoMatricula implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected HistoricoMatriculaPK historicoMatriculaPK;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "ano")
    private int ano;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "semestre")
    private int semestre;
    
    @Max(value = 10)  //@Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Column(name = "nota_final")
    private BigDecimal notaFinal;
    
    @JoinColumn(name = "codigo_matricula", referencedColumnName = "codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Matricula matricula;
    
    @JoinColumn(name = "codigo_disciplina", referencedColumnName = "codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Disciplina disciplina;

    public HistoricoMatricula() {
    }

    public HistoricoMatricula(HistoricoMatriculaPK historicoMatriculaPK) {
        this.historicoMatriculaPK = historicoMatriculaPK;
    }

    public HistoricoMatricula(HistoricoMatriculaPK historicoMatriculaPK, int ano, int semestre, BigDecimal notaFinal) {
        this.historicoMatriculaPK = historicoMatriculaPK;
        this.ano = ano;
        this.semestre = semestre;
        this.notaFinal = notaFinal;
    }

    public HistoricoMatricula(int codigoMatricula, int codigoDisciplina) {
        this.historicoMatriculaPK = new HistoricoMatriculaPK(codigoMatricula, codigoDisciplina);
    }

    public HistoricoMatriculaPK getHistoricoMatriculaPK() {
        return historicoMatriculaPK;
    }

    public void setHistoricoMatriculaPK(HistoricoMatriculaPK historicoMatriculaPK) {
        this.historicoMatriculaPK = historicoMatriculaPK;
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

    public BigDecimal getNotaFinal() {
        return notaFinal;
    }

    public void setNotaFinal(BigDecimal notaFinal) {
        this.notaFinal = notaFinal;
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
        hash += (historicoMatriculaPK != null ? historicoMatriculaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof HistoricoMatricula)) {
            return false;
        }
        HistoricoMatricula other = (HistoricoMatricula) object;
        if ((this.historicoMatriculaPK == null && other.historicoMatriculaPK != null) || (this.historicoMatriculaPK != null && !this.historicoMatriculaPK.equals(other.historicoMatriculaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.moasoft.universidade.model.HistoricoMatricula[ historicoMatriculaPK=" + historicoMatriculaPK + " ]";
    }
    
}
