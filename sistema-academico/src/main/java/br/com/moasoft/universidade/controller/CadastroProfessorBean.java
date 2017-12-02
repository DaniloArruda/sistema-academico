/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.moasoft.universidade.controller;

import br.com.moasoft.universidade.model.Departamento;
import br.com.moasoft.universidade.model.Professor;
import br.com.moasoft.universidade.repository.Departamentos;
import br.com.moasoft.universidade.repository.Professores;
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
public class CadastroProfessorBean implements Serializable {
    
    @Inject
    private Professores professores;
    
    @Inject
    private Departamentos departamentos;
    
    private List<Professor> listaProfessores;
    private List<Departamento> listaDepartamentos;
    private Professor professor = new Professor();
    
    @PostConstruct
    private void init() {
        buscarProfessores();
        buscarDepartamentos();
    }
    
    private void buscarProfessores() {
        this.listaProfessores = this.professores.todos();
    }
    
    private void buscarDepartamentos() {
        this.listaDepartamentos = this.departamentos.todos();
    }
    
    @Transactional
    public void salvar() {
        try {
            this.professores.salvar(professor);
            this.professor = new Professor();
            buscarProfessores();
            FacesUtil.addInfoMessage("Professor cadastrado.");
        } catch(Exception e) {
            FacesUtil.addErrorMessage("Erro ao cadastrar professor: " + e.getMessage());
        }
    }
    
    @Transactional
    public void remover(Professor professor) {
        try {
            this.professores.remover(professor);
            buscarProfessores();
            FacesUtil.addInfoMessage("Professor removido.");
        } catch(Exception e) {
            FacesUtil.addErrorMessage("Erro ao remover professor: " + e.getMessage());
        }
    }

    public List<Professor> getListaProfessores() {
        return listaProfessores;
    }

    public List<Departamento> getListaDepartamentos() {
        return listaDepartamentos;
    }

    public Professor getProfessor() {
        return professor;
    }
}
