/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.moasoft.universidade;

import br.com.moasoft.universidade.model.Aluno;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author danil
 */
public class Teste {
    public static void main(String[] args) {
        EntityManagerFactory factory = Persistence.createEntityManagerFactory("SistemaAcademicoPU");
        EntityManager manager = factory.createEntityManager();
        
        List<Aluno> alunos = manager.createQuery("from Aluno").getResultList();
        
        for (Aluno aluno : alunos) {
            System.out.println("CPF: " + aluno.getCpf());
            System.out.println("Nome: " + aluno.getNome());
        }
        
        manager.close();
        factory.close();
    }
}
