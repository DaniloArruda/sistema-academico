/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.moasoft.universidade.repository;

import br.com.moasoft.universidade.model.Curso;
import java.util.List;

/**
 *
 * @author danil
 */
public interface Cursos {
    public Curso salvar(Curso curso);
    public List<Curso> todos();
    public Curso porCodigo(Integer codigo);
    public void remover(Curso curso);
}
