/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.moasoft.universidade.controller;

import br.com.moasoft.universidade.model.Aluno;
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
    
    @PostConstruct
    private void init() {
        this.listaAlunos = this.alunos.todos();
    }
    
    @Transactional
    public void cadastrar() {
        this.alunos.salvar(aluno);
        this.aluno = new Aluno();
        this.listaAlunos = this.alunos.todos();
        FacesUtil.addInfoMessage("Aluno cadastrado.");
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
}
