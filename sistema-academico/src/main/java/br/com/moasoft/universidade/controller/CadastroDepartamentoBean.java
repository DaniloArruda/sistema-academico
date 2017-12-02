/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.moasoft.universidade.controller;

import br.com.moasoft.universidade.model.Aluno;
import br.com.moasoft.universidade.model.Departamento;
import br.com.moasoft.universidade.repository.Departamentos;
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
public class CadastroDepartamentoBean implements Serializable {
    
    @Inject
    private Departamentos departamentos;
    
    private Departamento departamento = new Departamento();
    private List<Departamento> listaDepartamentos = new ArrayList<>();

    @PostConstruct
    private void init() {
        buscarTodos();
    }
    
    public void buscarTodos() {
        this.listaDepartamentos = this.departamentos.todos();
    }
    
    @Transactional
    public void salvar() {
        try {
            this.departamentos.salvar(departamento);
            this.departamento = new Departamento();
            buscarTodos();
            FacesUtil.addInfoMessage("Departamento cadastrado.");
        } catch (Exception e) {
            FacesUtil.addErrorMessage("Erro ao cadastrar: " + e.getMessage());
        }
    }

    @Transactional
    public void remover(Departamento departamento) {
        try {
            this.departamentos.remover(departamento);
            buscarTodos();
            FacesUtil.addInfoMessage("Departamento removido.");
        } catch (Exception e) {
            FacesUtil.addErrorMessage("Erro ao cadastrar: " + e.getMessage());
        }
    }
    
    public Departamento getDepartamento() {
        return departamento;
    }

    public void setDepartamento(Departamento departamento) {
        this.departamento = departamento;
    }

    public List<Departamento> getListaDepartamentos() {
        return listaDepartamentos;
    }
    
}
