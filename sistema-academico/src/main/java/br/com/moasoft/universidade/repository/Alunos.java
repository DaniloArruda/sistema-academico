/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.moasoft.universidade.repository;

import br.com.moasoft.universidade.model.Aluno;
import java.util.List;

/**
 *
 * @author danil
 */
public interface Alunos  {
    public Aluno salvar(Aluno aluno);
    public List<Aluno> todos();
    public Aluno porCpf(String cpf);
    public void remover(Aluno aluno);
}
