/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.moasoft.universidade.controller;

import br.com.moasoft.universidade.model.Disciplina;
import br.com.moasoft.universidade.model.Professor;
import br.com.moasoft.universidade.model.Turma;
import br.com.moasoft.universidade.repository.Disciplinas;
import br.com.moasoft.universidade.repository.Professores;
import br.com.moasoft.universidade.repository.Turmas;
import br.com.moasoft.universidade.util.jpa.Transactional;
import br.com.moasoft.universidade.util.jsf.FacesUtil;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author danil
 */

@Named
@ViewScoped
public class CadastroTurmaBean implements Serializable {
    
    @Inject
    private Turmas turmas;
    
    @Inject
    private Disciplinas disciplinas;
    
    @Inject
    private Professores professores;
    
    private Turma turma = new Turma();
    
    private List<Turma> listaTurmas;
    private List<Disciplina> listaDisciplinas;
    private List<Professor> listaProfessores;
    
    @PostConstruct
    private void init() {
        this.buscarTurmas();
        this.buscarDisciplinas();
        this.buscarProfessores();
    }
    
    private void buscarTurmas() {
        this.listaTurmas = this.turmas.todas();
    }
    private void buscarDisciplinas() {
        this.listaDisciplinas = this.disciplinas.todas();
    }
    private void buscarProfessores() {
        this.listaProfessores = this.professores.todos();
    }
    
    @Transactional
    public void salvar() {
        try {
            this.turmas.salvar(turma);
            this.turma = new Turma();
            this.buscarTurmas();
            FacesUtil.addInfoMessage("Turma cadastrada.");
        } catch(Exception e) {
            FacesUtil.addErrorMessage("Erro ao cadastrar turma: " + e.getMessage());
        }
    }
    
    @Transactional
    public void remover(Turma turma) {
        try {
            this.turmas.remover(turma);
            this.buscarTurmas();
            FacesUtil.addInfoMessage("Turma removida.");
        } catch(Exception e) {
            FacesUtil.addErrorMessage("Erro ao excluir turma: " + e.getMessage());
        }
    }
    
    public void editar(Turma turma) {
        this.turma = turma;
    }
    
    public boolean turmaCadastrada() {
        return this.turma.getCodigo() != null;
    }

    public Turma getTurma() {
        return turma;
    }

    public List<Turma> getListaTurmas() {
        return listaTurmas;
    }

    public List<Disciplina> getListaDisciplinas() {
        return listaDisciplinas;
    }

    public List<Professor> getListaProfessores() {
        return listaProfessores;
    }
}
