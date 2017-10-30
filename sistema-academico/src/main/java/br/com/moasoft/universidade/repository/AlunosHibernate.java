/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.moasoft.universidade.repository;

import br.com.moasoft.universidade.model.Aluno;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;


/**
 *
 * @author danil
 */
public class AlunosHibernate implements Alunos, Serializable {
    
    @Inject
    private EntityManager manager;

    @Override
    public Aluno salvar(Aluno aluno) {
        return manager.merge(aluno);
    }
    
    @Override
    public List<Aluno> todos() {
        return manager.createQuery("from Aluno").getResultList();
    }
}
