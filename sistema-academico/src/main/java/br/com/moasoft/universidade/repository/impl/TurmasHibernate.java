/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.moasoft.universidade.repository.impl;

import br.com.moasoft.universidade.model.Turma;
import br.com.moasoft.universidade.repository.Turmas;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author danil
 */
public class TurmasHibernate implements Turmas, Serializable {
    
    @Inject
    private EntityManager manager;

    @Override
    public Turma salvar(Turma turma) {
        return manager.merge(turma);
    }

    @Override
    public List<Turma> todas() {
        return manager.createQuery("from Turma", Turma.class).getResultList();
    }

    @Override
    public Turma porCodigo(Integer codigo) {
        return manager.find(Turma.class, codigo);
    }

    @Override
    public void remover(Turma turma) {
        turma = this.porCodigo(turma.getCodigo());
        manager.remove(turma);
    }
    
}
