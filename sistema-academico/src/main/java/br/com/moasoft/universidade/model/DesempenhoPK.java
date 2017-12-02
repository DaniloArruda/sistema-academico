/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.moasoft.universidade.model;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author danil
 */
@Embeddable
public class DesempenhoPK implements Serializable {

    @NotNull
    @Column(name = "codigo_matricula", nullable = false)
    private int codigoMatricula;
    
    @NotNull
    @Column(name = "codigo_curso", nullable = false)
    private int codigoCurso;
    
    @NotNull
    @Column(name = "codigo_disciplina", nullable = false)
    private int codigoDisciplina;
    
    @NotNull
    @Column(nullable = false)
    private int ano;

    @NotNull
    @Column(nullable = false)
    private int semestre;

    public DesempenhoPK() {
    }

    public int getCodigoMatricula() {
        return codigoMatricula;
    }

    public void setCodigoMatricula(int codigoMatricula) {
        this.codigoMatricula = codigoMatricula;
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

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 29 * hash + this.codigoMatricula;
        hash = 29 * hash + this.codigoCurso;
        hash = 29 * hash + this.codigoDisciplina;
        hash = 29 * hash + this.ano;
        hash = 29 * hash + this.semestre;
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
        final DesempenhoPK other = (DesempenhoPK) obj;
        if (this.codigoMatricula != other.codigoMatricula) {
            return false;
        }
        if (this.codigoCurso != other.codigoCurso) {
            return false;
        }
        if (this.codigoDisciplina != other.codigoDisciplina) {
            return false;
        }
        if (this.ano != other.ano) {
            return false;
        }
        if (this.semestre != other.semestre) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.com.moasoft.universidade.model.DesempenhoPK[ codigoMatricula=" + codigoMatricula + ", codigoDisciplina=" + codigoDisciplina + " ]";
    }
    
}
