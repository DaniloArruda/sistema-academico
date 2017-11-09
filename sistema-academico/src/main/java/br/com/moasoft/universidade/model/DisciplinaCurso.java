/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.moasoft.universidade.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author danil
 */
@Entity
@Table(name = "disciplina_curso")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DisciplinaCurso.findAll", query = "SELECT d FROM DisciplinaCurso d")
    , @NamedQuery(name = "DisciplinaCurso.findByCodigoCurso", query = "SELECT d FROM DisciplinaCurso d WHERE d.disciplinaCursoPK.codigoCurso = :codigoCurso")
    , @NamedQuery(name = "DisciplinaCurso.findByCodigoDisciplina", query = "SELECT d FROM DisciplinaCurso d WHERE d.disciplinaCursoPK.codigoDisciplina = :codigoDisciplina")})
public class DisciplinaCurso implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected DisciplinaCursoPK disciplinaCursoPK;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "num_creditos")
    private int numeroCreditos;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "carga_horaria")
    private int cargaHoraria;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "obrigatoria")
    private boolean obrigatoria;
    
    @JoinColumn(name = "codigo_curso", referencedColumnName = "codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Curso curso;
    
    @JoinColumn(name = "codigo_disciplina", referencedColumnName = "codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Disciplina disciplina;

    public DisciplinaCurso() {
    }

    public DisciplinaCurso(DisciplinaCursoPK disciplinaCursoPK) {
        this.disciplinaCursoPK = disciplinaCursoPK;
    }

    public DisciplinaCurso(DisciplinaCursoPK disciplinaCursoPK, int numeroCreditos, int cargaHoraria, boolean obrigatoria) {
        this.disciplinaCursoPK = disciplinaCursoPK;
        this.numeroCreditos = numeroCreditos;
        this.cargaHoraria = cargaHoraria;
        this.obrigatoria = obrigatoria;
    }

    public DisciplinaCurso(int codigoCurso, int codigoDisciplina) {
        this.disciplinaCursoPK = new DisciplinaCursoPK(codigoCurso, codigoDisciplina);
    }

    public DisciplinaCursoPK getDisciplinaCursoPK() {
        return disciplinaCursoPK;
    }

    public void setDisciplinaCursoPK(DisciplinaCursoPK disciplinaCursoPK) {
        this.disciplinaCursoPK = disciplinaCursoPK;
    }

    public int getNumeroCreditos() {
        return numeroCreditos;
    }

    public void setNumeroCreditos(int numeroCreditos) {
        this.numeroCreditos = numeroCreditos;
    }

    public int getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(int cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public boolean getObrigatoria() {
        return obrigatoria;
    }

    public void setObrigatoria(boolean obrigatoria) {
        this.obrigatoria = obrigatoria;
    }

    public Curso getCurso() {
        return curso;
    }

    public void setCurso(Curso curso) {
        this.curso = curso;
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
        hash += (disciplinaCursoPK != null ? disciplinaCursoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DisciplinaCurso)) {
            return false;
        }
        DisciplinaCurso other = (DisciplinaCurso) object;
        if ((this.disciplinaCursoPK == null && other.disciplinaCursoPK != null) || (this.disciplinaCursoPK != null && !this.disciplinaCursoPK.equals(other.disciplinaCursoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.moasoft.universidade.model.DisciplinaCurso[ disciplinaCursoPK=" + disciplinaCursoPK + " ]";
    }
    
}
