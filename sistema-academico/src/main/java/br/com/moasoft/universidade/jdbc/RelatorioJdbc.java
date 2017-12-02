/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.moasoft.universidade.jdbc;

import br.com.moasoft.universidade.model.Aluno;
import br.com.moasoft.universidade.model.Professor;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author danil
 */
public class RelatorioJdbc implements Serializable {
    
    private ConnectionFactory factory = new ConnectionFactory();
    
    public List<Aluno> alunosNovosMenoresIdade() throws SQLException {
        List<Aluno> alunos = new ArrayList<>();
        
        try (Connection connection = factory.getConnection()) {
            String sql = "select \n" +
                    "	a.*\n" +
                    "from\n" +
                    "	aluno a\n" +
                    "inner join matricula m on a.codigo = m.codigo_aluno\n" +
                    "left join historico_matricula hm on m.codigo = hm.codigo_matricula\n" +
                    "where \n" +
                    "	hm.codigo_matricula is null\n" +
                    "    and year(a.data_nascimento) > 2000;";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();
            
            while (result.next()) {
                Aluno aluno = new Aluno();
                aluno.setCodigo(result.getInt("codigo"));
                aluno.setCpf(result.getString("cpf"));
                aluno.setDataNascimento(result.getDate("data_nascimento"));
                aluno.setEmail(result.getString("email"));
                aluno.setNome(result.getString("nome"));
                
                alunos.add(aluno);
            }
        }
        
        return alunos;
    }
    
    public List<Professor> professoresQueNaoPegaramTurmaNessePeriodo() throws SQLException {
        List<Professor> professores = new ArrayList<>();
        
        Connection connection = factory.getConnection();
        String sql = "select \n" +
                    "	* \n" +
                    "from \n" +
                    "	turma t\n" +
                    "right join professor p\n" +
                    "	on t.codigo_professor = p.codigo\n" +
                    "    and t.ano = year(now())\n" +
                    "    and semestre = (\n" +
                    "					select case\n" +
                    "						when month(now()) > 6 then 2\n" +
                    "						else 1 \n" +
                    "					end\n" +
                    "					)\n" +
                    "where\n" +
                    "   t.codigo is null";
        PreparedStatement statement = connection.prepareStatement(sql);
        ResultSet result = statement.executeQuery();

        while (result.next()) {
            Professor professor = new Professor();
            professor.setCfe(result.getString("cfe"));
            professor.setNome(result.getString("nome"));

            professores.add(professor);
        }
        
        return professores;
    }
    
    public List<Aluno> alunosQueCumpriramUmTercoDoCurso() throws SQLException {
        List<Aluno> alunos = new ArrayList<>();

        try (Connection connection = factory.getConnection()) {
            String sql = "select \n" +
                    "	a.cpf,\n" +
                    "    a.nome,\n" +
                    "    c.nome as curso,\n" +
                    "    c.carga_horaria as carga_horaria_curso,\n" +
                    "    sum(dc.carga_horaria) as carga_horaria_cumprida\n" +
                    "from\n" +
                    "	aluno a\n" +
                    "inner join matricula m on m.codigo_aluno = a.codigo\n" +
                    "inner join historico_matricula hm on m.codigo = hm.codigo_matricula\n" +
                    "inner join disciplina_curso dc on hm.codigo_curso = dc.codigo_curso and hm.codigo_disciplina = dc.codigo_disciplina\n" +
                    "inner join curso c on c.codigo = dc.codigo_curso\n" +
                    "group by\n" +
                    "	a.cpf,\n" +
                    "    a.nome,\n" +
                    "    c.nome,\n" +
                    "    c.carga_horaria\n" +
                    "having carga_horaria_cumprida > (c.carga_horaria/3);";
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                Aluno aluno = new Aluno();
                aluno.setCodigo(result.getInt("codigo"));
                aluno.setCpf(result.getString("cpf"));
                aluno.setDataNascimento(result.getDate("data_nascimento"));
                aluno.setEmail(result.getString("email"));
                aluno.setNome(result.getString("nome"));

                alunos.add(aluno);
            }
        }

        return alunos;
    }
}
