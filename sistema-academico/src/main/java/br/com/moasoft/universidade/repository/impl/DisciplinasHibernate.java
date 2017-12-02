/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.moasoft.universidade.repository.impl;

import br.com.moasoft.universidade.model.Disciplina;
import br.com.moasoft.universidade.repository.Disciplinas;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author danil
 */
public class DisciplinasHibernate implements Disciplinas, Serializable {

    @Inject
    private EntityManager manager;
    
    @Override
    public Disciplina salvar(Disciplina disciplina) {
        try {
            return manager.merge(disciplina);
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public List<Disciplina> todas() {
        return manager.createQuery("from Disciplina", Disciplina.class).getResultList();
    }

    @Override
    public Disciplina porCodigo(Integer codigo) {
        return manager.find(Disciplina.class, codigo);
    }

    @Override
    public void remover(Disciplina disciplina) {
        disciplina = this.porCodigo(disciplina.getCodigo());
        manager.remove(disciplina);
    }
    
}
