/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.moasoft.universidade.model;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author danil
 */

@Entity
@Table(name = "intencao_disciplina")
public class IntencaoDisciplina implements Serializable {
    
    @EmbeddedId
    private IntencaoDisciplinaPK intencaoDisciplinaPK;
    
    @JoinColumn(name = "codigo_matricula", referencedColumnName = "codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Matricula matricula;
    
    @JoinColumns({@JoinColumn(name = "codigo_curso", referencedColumnName = "codigo_curso", insertable = false, updatable = false),
                    @JoinColumn(name = "codigo_disciplina", referencedColumnName = "codigo_disciplina", insertable = false, updatable = false)})
    @ManyToOne(optional = false)
    private DisciplinaCurso disciplinaCurso;

    public IntencaoDisciplinaPK getIntencaoDisciplinaPK() {
        return intencaoDisciplinaPK;
    }

    public void setIntencaoDisciplinaPK(IntencaoDisciplinaPK intencaoDisciplinaPK) {
        this.intencaoDisciplinaPK = intencaoDisciplinaPK;
    }

    public Matricula getMatricula() {
        return matricula;
    }

    public void setMatricula(Matricula matricula) {
        this.matricula = matricula;
    }

    public DisciplinaCurso getDisciplinaCurso() {
        return disciplinaCurso;
    }

    public void setDisciplinaCurso(DisciplinaCurso disciplinaCurso) {
        this.disciplinaCurso = disciplinaCurso;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 97 * hash + Objects.hashCode(this.intencaoDisciplinaPK);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final IntencaoDisciplina other = (IntencaoDisciplina) obj;
        if (!Objects.equals(this.intencaoDisciplinaPK, other.intencaoDisciplinaPK)) {
            return false;
        }
        return true;
    }
}
