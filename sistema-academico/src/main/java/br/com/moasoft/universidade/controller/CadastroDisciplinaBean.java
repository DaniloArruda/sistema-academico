/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.moasoft.universidade.controller;

import br.com.moasoft.universidade.model.Departamento;
import br.com.moasoft.universidade.model.Disciplina;
import br.com.moasoft.universidade.repository.Departamentos;
import br.com.moasoft.universidade.repository.Disciplinas;
import br.com.moasoft.universidade.util.jpa.Transactional;
import br.com.moasoft.universidade.util.jsf.FacesUtil;
import java.io.Serializable;
import java.util.ArrayList;
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
public class CadastroDisciplinaBean implements Serializable {
    
    @Inject
    private Disciplinas disciplinas;
    
    @Inject
    private Departamentos departamentos;
    
    private Disciplina disciplina = new Disciplina();
    private List<Disciplina> listaDisciplinas;
    
    private Disciplina disciplinaPreRequisito;
    
    private List<Departamento> listaDepartamentos;
    
    private boolean dialogVisivel = false;
    
    @PostConstruct
    private void init() {
        this.buscarDisciplinas();
        this.buscarDepartamentos();
    }
    
    private void buscarDisciplinas() {
        this.listaDisciplinas = this.disciplinas.todas();
    }

    private void buscarDepartamentos() {
        this.listaDepartamentos = this.departamentos.todos();
    }
    
    @Transactional
    public void salvar() {
        try {
            this.disciplinas.salvar(disciplina);
            this.disciplina = new Disciplina();
            this.buscarDisciplinas();
            FacesUtil.addInfoMessage("Disciplina cadastrada.");
        } catch(Exception e) {
            FacesUtil.addErrorMessage("Erro ao cadastrar disciplina: " + e.getMessage());
        }
    }
    
    @Transactional
    public void remover(Disciplina disciplina) {
        try {
            this.disciplinas.remover(disciplina);
            this.buscarDisciplinas();
            FacesUtil.addInfoMessage("Disciplina removida.");
        } catch(Exception e) {
            FacesUtil.addErrorMessage("Erro ao excluir disciplina: " + e.getMessage());
        }
    }
    
    public void editar(Disciplina disciplina) {
        this.disciplina = disciplina;
    }
    
    public void adicionarDisciplinaPreRequisito() {
        this.disciplina.getDisciplinasPreRequisito().add(this.disciplinaPreRequisito);
    }
    
    public void removerDisciplinaPreRequisito(Disciplina disciplina) {
        this.disciplina.getDisciplinasPreRequisito().remove(disciplina);
    }
    
    public boolean disciplinaCadastrada() {
        return this.disciplina.getCodigo() != null;
    }
    
    public void mostrarDialog() {
        this.dialogVisivel = true;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }

    public Disciplina getDisciplinaPreRequisito() {
        return disciplinaPreRequisito;
    }

    public void setDisciplinaPreRequisito(Disciplina disciplinaPreRequisito) {
        this.disciplinaPreRequisito = disciplinaPreRequisito;
    }

    public List<Disciplina> getListaDisciplinas() {
        return listaDisciplinas;
    }

    public List<Departamento> getListaDepartamentos() {
        return listaDepartamentos;
    }

    public boolean isDialogVisivel() {
        return dialogVisivel;
    }
}
