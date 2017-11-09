/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.moasoft.universidade.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author danil
 */
@Embeddable
public class DisciplinaCursoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_curso")
    private int codigoCurso;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_disciplina")
    private int codigoDisciplina;

    public DisciplinaCursoPK() {
    }

    public DisciplinaCursoPK(int codigoCurso, int codigoDisciplina) {
        this.codigoCurso = codigoCurso;
        this.codigoDisciplina = codigoDisciplina;
    }

    public int getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(int codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public int getCodigoDisciplina() {
        return codigoDisciplina;
    }

    public void setCodigoDisciplina(int codigoDisciplina) {
        this.codigoDisciplina = codigoDisciplina;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codigoCurso;
        hash += (int) codigoDisciplina;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DisciplinaCursoPK)) {
            return false;
        }
        DisciplinaCursoPK other = (DisciplinaCursoPK) object;
        if (this.codigoCurso != other.codigoCurso) {
            return false;
        }
        if (this.codigoDisciplina != other.codigoDisciplina) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.moasoft.universidade.model.DisciplinaCursoPK[ codigoCurso=" + codigoCurso + ", codigoDisciplina=" + codigoDisciplina + " ]";
    }
    
}
