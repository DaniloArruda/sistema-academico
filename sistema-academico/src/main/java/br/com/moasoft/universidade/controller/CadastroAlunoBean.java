/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.moasoft.universidade.controller;

import br.com.moasoft.universidade.model.Aluno;
import br.com.moasoft.universidade.model.Telefone;
import br.com.moasoft.universidade.repository.Alunos;
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
public class CadastroAlunoBean implements Serializable {
    
    @Inject
    private Alunos alunos;
    
    private Aluno aluno = new Aluno();
    private List<Aluno> listaAlunos;
    
    private Telefone telefone = new Telefone();
    
    @PostConstruct
    private void init() {
        buscarTodos();
    }
    
    public void buscarTodos() {
        this.listaAlunos = this.alunos.todos();
    }
    
    @Transactional
    public void salvar() {
        try {
            this.alunos.salvar(aluno);
            this.aluno = new Aluno();
            buscarTodos();
            FacesUtil.addInfoMessage("Aluno salvo.");
        } catch (Exception e) {
            FacesUtil.addErrorMessage("Erro ao cadastrar: " + e.getMessage());
        }
    }
    
    @Transactional
    public void remover(Aluno aluno) {
        try {
            this.alunos.remover(aluno);
            buscarTodos();
            FacesUtil.addInfoMessage("Aluno removido.");
        } catch(Exception e) {
            FacesUtil.addErrorMessage("Erro ao cadastrar: " + e.getMessage());
        }
    }
    
    public void editar(Aluno aluno) {
        this.aluno = aluno;
    }
    
    public void adicionarTelefone() {
        this.telefone.setAluno(aluno);
        this.aluno.getTelefoneList().add(telefone);
        this.telefone = new Telefone();
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public List<Aluno> getListaAlunos() {
        return listaAlunos;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }
}
