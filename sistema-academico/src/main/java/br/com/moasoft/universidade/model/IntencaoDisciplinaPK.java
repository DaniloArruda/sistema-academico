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
public class IntencaoDisciplinaPK implements Serializable {
    
    @NotNull
    @Column(name = "codigo_matricula", nullable = false)
    private Integer codigoMatricula;
    
    @NotNull
    @Column(name = "codigo_curso", nullable = false)
    private Integer codigoCurso;
    
    @NotNull
    @Column(name = "codigo_disciplina", nullable = false)
    private Integer codigoDisciplina;

    public Integer getCodigoMatricula() {
        return codigoMatricula;
    }

    public void setCodigoMatricula(Integer codigoMatricula) {
        this.codigoMatricula = codigoMatricula;
    }

    public Integer getCodigoCurso() {
        return codigoCurso;
    }

    public void setCodigoCurso(Integer codigoCurso) {
        this.codigoCurso = codigoCurso;
    }

    public Integer getCodigoDisciplina() {
        return codigoDisciplina;
    }

    public void setCodigoDisciplina(Integer codigoDisciplina) {
        this.codigoDisciplina = codigoDisciplina;
    }
}
