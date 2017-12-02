/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.moasoft.universidade.controller;

import br.com.moasoft.universidade.jdbc.RelatorioJdbc;
import br.com.moasoft.universidade.model.Aluno;
import br.com.moasoft.universidade.util.jsf.FacesUtil;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

/**
 *
 * @author danil
 */

@ManagedBean
@ViewScoped
public class RelatoriosBean implements Serializable {
    
    private RelatorioJdbc relatorioJdbc = new RelatorioJdbc();
    private List<Aluno> alunosNovosMenoresIdade;
    private List<Aluno> alunosQueCumpriramUmTercoDoCurso;
    
    @PostConstruct
    public void carregarRelatorios() {
        try {
            this.alunosNovosMenoresIdade = this.relatorioJdbc.alunosNovosMenoresIdade();
            this.alunosQueCumpriramUmTercoDoCurso = this.relatorioJdbc.alunosQueCumpriramUmTercoDoCurso();
        } catch (SQLException ex) {
            FacesUtil.addErrorMessage("Erro ao buscar alunos: " + ex.getMessage());
        }
    }

    public List<Aluno> getAlunosNovosMenoresIdade() {
        return alunosNovosMenoresIdade;
    }

    public void setAlunosNovosMenoresIdade(List<Aluno> alunosNovosMenoresIdade) {
        this.alunosNovosMenoresIdade = alunosNovosMenoresIdade;
    }

    public List<Aluno> getAlunosQueCumpriramUmTercoDoCurso() {
        return alunosQueCumpriramUmTercoDoCurso;
    }
}
