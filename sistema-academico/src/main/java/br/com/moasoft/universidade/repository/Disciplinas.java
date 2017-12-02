/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.moasoft.universidade.repository;

import br.com.moasoft.universidade.model.Disciplina;
import java.util.List;

/**
 *
 * @author danil
 */
public interface Disciplinas {
    public Disciplina salvar(Disciplina disciplina);
    public List<Disciplina> todas();
    public Disciplina porCodigo(Integer codigo);
    public void remover(Disciplina disciplina);
}
