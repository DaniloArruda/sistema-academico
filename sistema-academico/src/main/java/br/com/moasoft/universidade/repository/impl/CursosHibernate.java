/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.moasoft.universidade.repository.impl;

import br.com.moasoft.universidade.model.Curso;
import br.com.moasoft.universidade.repository.Cursos;
import java.io.Serializable;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author danil
 */
public class CursosHibernate implements Cursos, Serializable {
    
    @Inject
    private EntityManager manager;

    @Override
    public Curso salvar(Curso curso) {
        return manager.merge(curso);
    }

    @Override
    public List<Curso> todos() {
        return manager.createQuery("from Curso", Curso.class).getResultList();
    }

    @Override
    public Curso porCodigo(Integer codigo) {
        return manager.find(Curso.class, codigo);
    }

    @Override
    public void remover(Curso curso) {
        curso = this.porCodigo(curso.getCodigo());
        manager.remove(curso);
    }
    
}
