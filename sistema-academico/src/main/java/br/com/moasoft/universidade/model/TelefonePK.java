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
import javax.validation.constraints.Size;

/**
 *
 * @author danil
 */
@Embeddable
public class TelefonePK implements Serializable {

    @Basic(optional = false)
    @NotNull
    @Column(name = "codigo_aluno")
    private int codigoAluno;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "ddd", columnDefinition = "char")
    private String ddd;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 9)
    @Column(name = "telefone")
    private String telefone;

    public TelefonePK() {
    }

    public TelefonePK(int codigoAluno, String ddd, String telefone) {
        this.codigoAluno = codigoAluno;
        this.ddd = ddd;
        this.telefone = telefone;
    }

    public int getCodigoAluno() {
        return codigoAluno;
    }

    public void setCodigoAluno(int codigoAluno) {
        this.codigoAluno = codigoAluno;
    }

    public String getDdd() {
        return ddd;
    }

    public void setDdd(String ddd) {
        this.ddd = ddd;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codigoAluno;
        hash += (ddd != null ? ddd.hashCode() : 0);
        hash += (telefone != null ? telefone.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof TelefonePK)) {
            return false;
        }
        TelefonePK other = (TelefonePK) object;
        if (this.codigoAluno != other.codigoAluno) {
            return false;
        }
        if ((this.ddd == null && other.ddd != null) || (this.ddd != null && !this.ddd.equals(other.ddd))) {
            return false;
        }
        if ((this.telefone == null && other.telefone != null) || (this.telefone != null && !this.telefone.equals(other.telefone))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.moasoft.universidade.model.TelefonePK[ codigoAluno=" + codigoAluno + ", ddd=" + ddd + ", telefone=" + telefone + " ]";
    }
    
}
