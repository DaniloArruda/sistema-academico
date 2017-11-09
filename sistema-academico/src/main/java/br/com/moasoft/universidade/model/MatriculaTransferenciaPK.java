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
public class MatriculaTransferenciaPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "codigo_transferencia")
    private int codigoTransferencia;
    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_matricula")
    private int codigoMatricula;

    public MatriculaTransferenciaPK() {
    }

    public MatriculaTransferenciaPK(int codigoTransferencia, int codigoMatricula) {
        this.codigoTransferencia = codigoTransferencia;
        this.codigoMatricula = codigoMatricula;
    }

    public int getCodigoTransferencia() {
        return codigoTransferencia;
    }

    public void setCodigoTransferencia(int codigoTransferencia) {
        this.codigoTransferencia = codigoTransferencia;
    }

    public int getCodigoMatricula() {
        return codigoMatricula;
    }

    public void setCodigoMatricula(int codigoMatricula) {
        this.codigoMatricula = codigoMatricula;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codigoTransferencia;
        hash += (int) codigoMatricula;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof MatriculaTransferenciaPK)) {
            return false;
        }
        MatriculaTransferenciaPK other = (MatriculaTransferenciaPK) object;
        if (this.codigoTransferencia != other.codigoTransferencia) {
            return false;
        }
        if (this.codigoMatricula != other.codigoMatricula) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.moasoft.universidade.model.MatriculaTransferenciaPK[ codigoTransferencia=" + codigoTransferencia + ", codigoMatricula=" + codigoMatricula + " ]";
    }
    
}
