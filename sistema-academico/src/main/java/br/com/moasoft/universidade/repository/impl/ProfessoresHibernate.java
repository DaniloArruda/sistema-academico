/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.moasoft.universidade.repository.impl;

import br.com.moasoft.universidade.model.Professor;
import br.com.moasoft.universidade.repository.Professores;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author danil
 */
public class ProfessoresHibernate implements Professores, Serializable {

    @Inject
    private EntityManager manager;
    
    @Override
    public Professor salvar(Professor professor) {
        return manager.merge(professor);
    }

    @Override
    public List<Professor> todos() {
        return manager.createQuery("from Professor", Professor.class).getResultList();
    }

    @Override
    public Professor porCodigo(Integer codigo) {
        return manager.find(Professor.class, codigo);
    }

    @Override
    public void remover(Professor professor) {
        professor = this.porCodigo(professor.getCodigo());
        manager.remove(professor);
    }
    
}
