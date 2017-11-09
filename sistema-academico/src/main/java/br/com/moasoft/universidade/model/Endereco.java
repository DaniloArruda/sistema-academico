/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.moasoft.universidade.model;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author danil
 */
@Entity
@Table(name = "endereco")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Endereco.findAll", query = "SELECT e FROM Endereco e")
    , @NamedQuery(name = "Endereco.findByCodigoAluno", query = "SELECT e FROM Endereco e WHERE e.codigoAluno = :codigoAluno")
    , @NamedQuery(name = "Endereco.findByLogradouro", query = "SELECT e FROM Endereco e WHERE e.logradouro = :logradouro")
    , @NamedQuery(name = "Endereco.findByCep", query = "SELECT e FROM Endereco e WHERE e.cep = :cep")})
public class Endereco implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Column(name = "codigo_aluno")
    private Integer codigoAluno;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 60)
    private String logradouro;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    private String bairro;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    private String cidade;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    private String numero;
    
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 8)
    @Column(columnDefinition = "char(8)")
    private String cep;
    
    @JoinColumn(name = "codigo_aluno", referencedColumnName = "codigo", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Aluno aluno;

    public Endereco() {
    }

    public Endereco(Integer codigoAluno) {
        this.codigoAluno = codigoAluno;
    }

    public Endereco(Integer codigoAluno, String logradouro, String bairro, String cidade, String numero, String cep) {
        this.codigoAluno = codigoAluno;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cidade = cidade;
        this.numero = numero;
        this.cep = cep;
    }

    public Integer getCodigoAluno() {
        return codigoAluno;
    }

    public void setCodigoAluno(Integer codigoAluno) {
        this.codigoAluno = codigoAluno;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
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
        hash += (codigoAluno != null ? codigoAluno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Endereco)) {
            return false;
        }
        Endereco other = (Endereco) object;
        if ((this.codigoAluno == null && other.codigoAluno != null) || (this.codigoAluno != null && !this.codigoAluno.equals(other.codigoAluno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.moasoft.universidade.model.Endereco[ codigoAluno=" + codigoAluno + " ]";
    }
    
}
