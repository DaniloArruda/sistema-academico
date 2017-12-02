/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.moasoft.universidade.controller;

import br.com.moasoft.universidade.model.Curso;
import br.com.moasoft.universidade.model.Departamento;
import br.com.moasoft.universidade.model.Professor;
import br.com.moasoft.universidade.repository.Cursos;
import br.com.moasoft.universidade.repository.Departamentos;
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
public class CadastroCursoBean implements Serializable {
    
    @Inject
    private Cursos cursos;
    
    @Inject
    private Departamentos departamentos;
    
    private List<Curso> listaCursos;
    private Curso curso = new Curso();
    
    private List<Departamento> listaDepartamentos;
    
    @PostConstruct
    private void init() {
        buscarCursos();
        buscarDepartamentos();
    }

    private void buscarCursos() {
        this.listaCursos = this.cursos.todos();
    }
    
    private void buscarDepartamentos() {
        this.listaDepartamentos = this.departamentos.todos();
    }
    
    @Transactional
    public void salvar() {
        try {
            this.cursos.salvar(curso);
            this.curso = new Curso();
            buscarCursos();
            FacesUtil.addInfoMessage("Curso cadastrado.");
        } catch(Exception e) {
            FacesUtil.addErrorMessage("Erro ao cadastrar curso: " + e.getMessage());
        }
    }
    
    @Transactional
    public void remover(Curso curso) {
        try {
            this.cursos.remover(curso);
            buscarCursos();
            FacesUtil.addInfoMessage("Curso removido.");
        } catch(Exception e) {
            FacesUtil.addErrorMessage("Erro ao remover curso: " + e.getMessage());
        }
    }

    public List<Curso> getListaCursos() {
        return listaCursos;
    }

    public Curso getCurso() {
        return curso;
    }

    public List<Departamento> getListaDepartamentos() {
        return listaDepartamentos;
    }
}
