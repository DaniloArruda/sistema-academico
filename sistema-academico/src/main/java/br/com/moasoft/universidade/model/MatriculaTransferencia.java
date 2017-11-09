/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.moasoft.universidade.model;

import java.io.Serializable;
import java.util.List;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author danil
 */
@Entity
@Table(name = "matricula_transferencia")
@PrimaryKeyJoinColumn(name = "codigo_matricula")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "MatriculaTransferencia.findAll", query = "SELECT m FROM MatriculaTransferencia m")})
public class MatriculaTransferencia extends Matricula implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Column(name = "codigo_transferencia")
    private Integer codigoTransferencia;
    
    @JoinTable(name = "disciplina_aproveitada", joinColumns = {
        @JoinColumn(name = "codigo_transferencia", referencedColumnName = "codigo_transferencia")}, inverseJoinColumns = {
        @JoinColumn(name = "codigo_disciplina", referencedColumnName = "codigo")})
    @ManyToMany
    private List<Disciplina> disciplinasAproveitadas;
    

    public MatriculaTransferencia() {
    }

    public Integer getCodigoTransferencia() {
        return codigoTransferencia;
    }

    public void setCodigoTransferencia(Integer codigoTransferencia) {
        this.codigoTransferencia = codigoTransferencia;
    }

    @XmlTransient
    public List<Disciplina> getDisciplinasAproveitadas() {
        return disciplinasAproveitadas;
    }

    public void setDisciplinasAproveitadas(List<Disciplina> disciplinasAproveitadas) {
        this.disciplinasAproveitadas = disciplinasAproveitadas;
    }

    // implementa ou não o equals e hash code?
}
