/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.moasoft.universidade.repository;

import br.com.moasoft.universidade.model.Turma;
import java.util.List;

/**
 *
 * @author danil
 */
public interface Turmas {
    public Turma salvar(Turma turma);
    public List<Turma> todas();
    public Turma porCodigo(Integer codigo);
    public void remover(Turma turma);
}
