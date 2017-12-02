/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.moasoft.universidade.repository.impl;

import br.com.moasoft.universidade.model.Departamento;
import br.com.moasoft.universidade.repository.Departamentos;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author danil
 */
public class DepartamentosHibernate implements Departamentos, Serializable {
    
    @Inject
    private EntityManager manager;
    
    @Override
    public Departamento salvar(Departamento departamento) {
        return manager.merge(departamento);
    }

    @Override
    public List<Departamento> todos() {
        return manager.createQuery("from Departamento").getResultList();
    }

    @Override
    public Departamento porCodigo(Integer codigo) {
        return manager.find(Departamento.class, codigo);
    }

    @Override
    public void remover(Departamento departamento) {
        departamento = this.porCodigo(departamento.getCodigo());
        manager.remove(departamento);
    }

    
}
