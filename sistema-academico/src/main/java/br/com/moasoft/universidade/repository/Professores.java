/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.moasoft.universidade.repository;

import br.com.moasoft.universidade.model.Professor;
import java.util.List;

/**
 *
 * @author danil
 */
public interface Professores {
    public Professor salvar(Professor professor);
    public List<Professor> todos();
    public Professor porCodigo(Integer codigo);
    public void remover(Professor professor);
}
