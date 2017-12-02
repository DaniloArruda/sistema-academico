/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.moasoft.universidade.model;

import java.io.Serializable;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author danil
 */
@Entity
@Table(name = "telefone")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Telefone.findAll", query = "SELECT t FROM Telefone t")
    , @NamedQuery(name = "Telefone.findByCodigoAluno", query = "SELECT t FROM Telefone t WHERE t.telefonePK.codigoAluno = :codigoAluno")
    , @NamedQuery(name = "Telefone.findByDdd", query = "SELECT t FROM Telefone t WHERE t.telefonePK.ddd = :ddd")})
public class Telefone implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected TelefonePK telefonePK;
    
    @JoinColumn(name = "codigo_aluno", referencedColumnName = "codigo", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Aluno aluno;

    public Telefone() {
        this.telefonePK = new TelefonePK();
    }

    public Telefone(TelefonePK telefonePK) {
        this.telefonePK = telefonePK;
    }

    public Telefone(int codigoAluno, String ddd, String telefone) {
        this.telefonePK = new TelefonePK(codigoAluno, ddd, telefone);
    }

    public TelefonePK getTelefonePK() {
        return telefonePK;
    }

    public void setTelefonePK(TelefonePK telefonePK) {
        this.telefonePK = telefonePK;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (telefonePK != null ? telefonePK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Telefone)) {
            return false;
        }
        Telefone other = (Telefone) object;
        if ((this.telefonePK == null && other.telefonePK != null) || (this.telefonePK != null && !this.telefonePK.equals(other.telefonePK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.moasoft.universidade.model.Telefone[ telefonePK=" + telefonePK + " ]";
    }
    
}
