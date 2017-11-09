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
public class DesempenhoPK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_matricula")
    private int codigoMatricula;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_disciplina")
    private int codigoDisciplina;

    public DesempenhoPK() {
    }

    public DesempenhoPK(int codigoMatricula, int codigoDisciplina) {
        this.codigoMatricula = codigoMatricula;
        this.codigoDisciplina = codigoDisciplina;
    }

    public int getCodigoMatricula() {
        return codigoMatricula;
    }

    public void setCodigoMatricula(int codigoMatricula) {
        this.codigoMatricula = codigoMatricula;
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
        hash += (int) codigoMatricula;
        hash += (int) codigoDisciplina;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof DesempenhoPK)) {
            return false;
        }
        DesempenhoPK other = (DesempenhoPK) object;
        if (this.codigoMatricula != other.codigoMatricula) {
            return false;
        }
        if (this.codigoDisciplina != other.codigoDisciplina) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.moasoft.universidade.model.DesempenhoPK[ codigoMatricula=" + codigoMatricula + ", codigoDisciplina=" + codigoDisciplina + " ]";
    }
    
}
