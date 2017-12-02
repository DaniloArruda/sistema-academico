drop table if exists aluno;
create table aluno(
	codigo int primary key auto_increment,
    cpf char(11) unique not null,
    nome varchar(60) not null,
    data_nascimento date not null,
    email varchar(50) not null
);

insert into aluno(cpf, nome, data_nascimento, email) values ('19100000000', 'Danilo Arruda', '1997-01-25', 'danilo@email.com');
insert into aluno(cpf, nome, data_nascimento, email) values ('00000000191', 'Moaci Martins', '1998-04-22', 'moaci@email.com');
insert into aluno(cpf, nome, data_nascimento, email) values ('76871739530', 'Lincoln Silva', '1988-11-25', 'lincoln@email.com');
insert into aluno(cpf, nome, data_nascimento, email) values ('69346882280', 'Paulo Silva', '1988-01-25', 'paulo@email.com');
insert into aluno(cpf, nome, data_nascimento, email) values ('23547730481', 'Uirá Silva', '1912-03-11', 'uira@email.com');
insert into aluno(cpf, nome, data_nascimento, email) values ('64394683408', 'Ricardo Silva', '2012-03-11', 'ricardo@email.com');
insert into aluno(cpf, nome, data_nascimento, email) values ('53542632554', 'Rafael Silva', '2012-03-11', 'rafael@email.com');
insert into aluno(cpf, nome, data_nascimento, email) values ('52264264705', 'Lucas Silva', '2012-03-11', 'lucas@email.com');
insert into aluno(cpf, nome, data_nascimento, email) values ('91384375708', 'Rodrigo Silva', '2012-03-11', 'rodrigo@email.com');
insert into aluno(cpf, nome, data_nascimento, email) values ('95380813828', 'Bernardo Silva', '2012-03-11', 'bernardo@email.com');
insert into aluno(cpf, nome, data_nascimento, email) values ('18621294877', 'Gabriel Silva', '2012-03-11', 'gabriel@email.com');

drop table if exists telefone;
create table telefone(
	codigo_aluno int,
    ddd char(2) not null,
    telefone varchar(9) not null,
    
    primary key(codigo_aluno, ddd, telefone),
    foreign key(codigo_aluno) references aluno(codigo)
);

insert into telefone(codigo_aluno, ddd, telefone) values (1, '81', '30231234');
insert into telefone(codigo_aluno, ddd, telefone) values (1, '81', '982398202');
insert into telefone(codigo_aluno, ddd, telefone) values (2, '81', '30279829');
insert into telefone(codigo_aluno, ddd, telefone) values (3, '81', '31398273');
insert into telefone(codigo_aluno, ddd, telefone) values (4, '81', '33223298');
insert into telefone(codigo_aluno, ddd, telefone) values (5, '81', '32572983');

drop table if exists endereco;
create table endereco(
	codigo_aluno int primary key,
    logradouro varchar(60) not null,
    bairro varchar(20) not null,
    cidade varchar(20) not null,
    numero varchar(10) not null,
    cep char(8) not null,
    
    foreign key(codigo_aluno) references aluno(codigo)
);

insert into endereco values (1, 'Rua tal', 'Casa Amarela', 'Recife', '123', '12345678');
insert into endereco values (2, 'Rua tel', 'Casa Verde', 'Recife', '435', '12424322');
insert into endereco values (3, 'Rua til', 'Casa Azul', 'Recife', '23', '43622345');
insert into endereco values (4, 'Rua tol', 'Casa Vermelha', 'Recife', '1234', '64232366');
insert into endereco values (5, 'Rua tul', 'Casa Laranja', 'Recife', '543', '54243267');

drop table if exists departamento;
create table departamento(
	codigo int primary key auto_increment,
    nome varchar(45) not null
);

insert into departamento(nome) values ('Centro de Ciências de Tecnologia');
insert into departamento(nome) values ('Centro de Ciências Sociais');
insert into departamento(nome) values ('Centro de Ciências Jurídicas');
insert into departamento(nome) values ('Centro de Teologia e Ciências Humanas');
insert into departamento(nome) values ('Centro de Ciências Biológicas e Saúde');

drop table if exists curso;
create table curso(
	codigo int primary key auto_increment,
    nome varchar(45) not null,
    num_creditos int not null,
    num_total_disciplinas_obg int not null,
    carga_horaria int not null,
    codigo_departamento int not null,
    
    foreign key(codigo_departamento) references departamento(codigo)
);

insert into curso(nome, num_creditos, num_total_disciplinas_obg, carga_horaria, codigo_departamento) values ('Ciência da computação', 360, 40, 360, 1);
insert into curso(nome, num_creditos, num_total_disciplinas_obg, carga_horaria, codigo_departamento) values ('Sistemas de informação', 360, 40, 360, 1);
insert into curso(nome, num_creditos, num_total_disciplinas_obg, carga_horaria, codigo_departamento) values ('Administração', 360, 40, 360, 2);
insert into curso(nome, num_creditos, num_total_disciplinas_obg, carga_horaria, codigo_departamento) values ('Ciências contábeis', 360, 40, 360, 2);
insert into curso(nome, num_creditos, num_total_disciplinas_obg, carga_horaria, codigo_departamento) values ('Direito', 360, 40, 360, 3);
insert into curso(nome, num_creditos, num_total_disciplinas_obg, carga_horaria, codigo_departamento) values ('História', 360, 40, 360, 4);
insert into curso(nome, num_creditos, num_total_disciplinas_obg, carga_horaria, codigo_departamento) values ('Teologia', 360, 40, 360, 4);
insert into curso(nome, num_creditos, num_total_disciplinas_obg, carga_horaria, codigo_departamento) values ('Ciências biológicas', 360, 40, 360, 5);
insert into curso(nome, num_creditos, num_total_disciplinas_obg, carga_horaria, codigo_departamento) values ('Administração', 360, 40, 360, 5);


drop table if exists professor;
create table professor(
	codigo int primary key auto_increment,
    cfe varchar(10) unique not null,
    nome varchar(60) not null,
    codigo_departamento int not null,
    
    foreign key(codigo_departamento) references departamento(codigo)
);

insert into professor(cfe, nome, codigo_departamento) values ('123', 'Mozá Silva', 1);
insert into professor(cfe, nome, codigo_departamento) values ('111', 'Sergio Murilo', 1);

insert into professor(cfe, nome, codigo_departamento) values ('222', 'Caroline Silva', 2);
insert into professor(cfe, nome, codigo_departamento) values ('333', 'Ricardo Gomes', 2);

insert into professor(cfe, nome, codigo_departamento) values ('433', 'Elania Silva', 3);
insert into professor(cfe, nome, codigo_departamento) values ('461', 'Eduardo Murilo', 3);

insert into professor(cfe, nome, codigo_departamento) values ('444', 'Liborio Silva', 4);
insert into professor(cfe, nome, codigo_departamento) values ('555', 'Abigaiu Silva', 4);

insert into professor(cfe, nome, codigo_departamento) values ('597', 'Rafael Silva', 5);
insert into professor(cfe, nome, codigo_departamento) values ('888', 'Edvaldo Santana', 5);

drop table if exists disciplina;
create table disciplina(
	codigo int primary key auto_increment,
    nome varchar(50) not null,
    periodo int not null,
	codigo_departamento int not null,
    
    foreign key(codigo_departamento) references departamento(codigo)
);


insert into disciplina(nome, periodo, codigo_departamento) values ('Introdução a programação I', 1, 1);
insert into disciplina(nome, periodo, codigo_departamento) values ('Introdução a programação II', 1, 1);
insert into disciplina(nome, periodo, codigo_departamento) values ('Estrutura de dados I', 1, 1);
insert into disciplina(nome, periodo, codigo_departamento) values ('Arquitetura de computadores', 1, 1);
insert into disciplina(nome, periodo, codigo_departamento) values ('Libras', 2, 2);


drop table if exists disciplina_pre_requisito;
create table disciplina_pre_requisito(
	codigo_disciplina int,
    codigo_disciplina_pre_requisito int,
    
    primary key(codigo_disciplina, codigo_disciplina_pre_requisito),
    foreign key(codigo_disciplina) references disciplina(codigo),
    foreign key(codigo_disciplina_pre_requisito) references disciplina(codigo)
);

delimiter //
drop trigger if exists verificar_limite_disciplina_prerequisito //
create trigger verificar_limite_disciplina_prerequisito before insert on disciplina_pre_requisito
for each row
begin
	
	set @quantidade = (select
							count(*)
						from
							disciplina_pre_requisito dp
						where dp.codigo_disciplina = new.codigo_disciplina);
    
    if @quantidade >= 3 then
		signal sqlstate '45000' set message_text = 'Uma disciplina deve ter no máximo 3 pré-requisitos.';
	end if;
    
end;//
delimiter ;


insert into disciplina_pre_requisito values (2, 1);
insert into disciplina_pre_requisito values (3, 2);
insert into disciplina_pre_requisito values (4, 3);

drop table if exists disciplina_curso;
create table disciplina_curso (
	codigo_curso int,
    codigo_disciplina int,
    num_creditos int not null,
    carga_horaria int not null,
    obrigatoria boolean not null,
    
    primary key(codigo_curso, codigo_disciplina),
    
    foreign key(codigo_curso) references curso(codigo),
    foreign key(codigo_disciplina) references disciplina(codigo)
);

insert into disciplina_curso values (1, 1, 60, 60, true);
insert into disciplina_curso values (1, 2, 60, 60, true);
insert into disciplina_curso values (1, 3, 60, 60, true);
insert into disciplina_curso values (1, 4, 60, 60, true);
insert into disciplina_curso values (1, 5, 60, 60, false);


drop table if exists matricula;
create table matricula(
	codigo int primary key auto_increment,
	matricula char(8) unique not null,
    coeficiente_rendimento decimal(3,1),
    situacao enum('ATIVA', 'TRANCADA', 'ENCERRADA') not null,
    codigo_aluno int not null,
    codigo_curso int not null,
    
    foreign key(codigo_aluno) references aluno(codigo),
    foreign key(codigo_curso) references curso(codigo)
);

insert into matricula(matricula, situacao, codigo_aluno, codigo_curso) values ('20161123', 2, 1, 1);
insert into matricula(matricula, situacao, codigo_aluno, codigo_curso) values ('20161065', 2, 2, 1);
insert into matricula(matricula, situacao, codigo_aluno, codigo_curso) values ('20162443', 2, 3, 1);
insert into matricula(matricula, situacao, codigo_aluno, codigo_curso) values ('20172987', 2, 4, 1);
insert into matricula(matricula, situacao, codigo_aluno, codigo_curso) values ('20172067', 2, 5, 1);
insert into matricula(matricula, situacao, codigo_aluno, codigo_curso) values ('20172068', 2, 6, 1);
insert into matricula(matricula, situacao, codigo_aluno, codigo_curso) values ('20172069', 2, 7, 1);
insert into matricula(matricula, situacao, codigo_aluno, codigo_curso) values ('20172070', 2, 8, 1);
insert into matricula(matricula, situacao, codigo_aluno, codigo_curso) values ('20172071', 2, 9, 1);
insert into matricula(matricula, situacao, codigo_aluno, codigo_curso) values ('20172072', 2, 10, 1);
insert into matricula(matricula, situacao, codigo_aluno, codigo_curso) values ('20172073', 2, 11, 1);

 delimiter //

create trigger gerar_matricula before insert on matricula
for each row
begin
	
	set @data_atual = now();
	set @ano = cast(Year(@data_atual) as char(4));
    set @mes = Month(@data_atual);
    if (@mes >= 1 and @mes <= 6) then
		set @semestre = '1';
	else
		set @semestre = '2';
	end if;
    set new.matricula = concat( @ano, @semestre, (select max(codigo) from matricula) + 1);
end;//
delimiter ;



drop table if exists matricula_transferencia;
create table matricula_transferencia(
	codigo_transferencia int auto_increment,
    codigo_matricula int,
    
    primary key(codigo_transferencia, codigo_matricula),
    foreign key(codigo_matricula) references matricula(codigo)
);

drop table if exists intencao_disciplina;
create table intencao_disciplina (
	codigo_matricula int,
    codigo_curso int not null,
    codigo_disciplina int not null,
    
    primary key(codigo_matricula, codigo_curso, codigo_disciplina),
    foreign key(codigo_matricula) references matricula(codigo),
    foreign key(codigo_curso, codigo_disciplina) references disciplina_curso(codigo_curso, codigo_disciplina)
);

insert into intencao_disciplina values (1, 1, 1);
insert into intencao_disciplina values (2, 1, 1);
insert into intencao_disciplina values (3, 1, 1);
insert into intencao_disciplina values (4, 1, 1);
insert into intencao_disciplina values (5, 1, 1);
insert into intencao_disciplina values (6, 1, 1);
insert into intencao_disciplina values (7, 1, 1);
insert into intencao_disciplina values (8, 1, 1);
insert into intencao_disciplina values (9, 1, 1);
insert into intencao_disciplina values (10, 1, 1);

drop table if exists desempenho;
create table desempenho(
	codigo_matricula int,
    codigo_curso int not null,
    codigo_disciplina int not null,
    ano int not null,
    semestre int not null,
    nota1 decimal(3,1),
    nota2 decimal(3,1),
    media decimal(3,1),
    nota_final decimal(3,1),
    num_faltas int,
    
    primary key(codigo_matricula, codigo_curso, codigo_disciplina, ano, semestre),
    foreign key(codigo_matricula) references matricula(codigo),
    foreign key(codigo_curso, codigo_disciplina) references disciplina_curso(codigo_curso, codigo_disciplina)
);

insert into desempenho(codigo_matricula, codigo_curso, codigo_disciplina, ano, semestre) values (1, 1, 1, 2017, 1);
insert into desempenho(codigo_matricula, codigo_curso, codigo_disciplina, ano, semestre) values (2, 1, 2, 2017, 1);
insert into desempenho(codigo_matricula, codigo_curso, codigo_disciplina, ano, semestre) values (3, 1, 3, 2017, 1);
insert into desempenho(codigo_matricula, codigo_curso, codigo_disciplina, ano, semestre) values (4, 1, 4, 2017, 1);


drop table if exists turma;
create table turma(
	codigo int primary key auto_increment,
    ano int not null,
    semestre int not null, -- ano e semestre adicionados 
    codigo_professor int not null,
    codigo_curso int not null,
    codigo_disciplina int not null,
    
    unique(ano, semestre, codigo_curso, codigo_disciplina, codigo_professor),
    
    foreign key(codigo_professor) references professor(codigo),
    foreign key(codigo_curso, codigo_disciplina) references disciplina_curso(codigo_curso, codigo_disciplina)
);

insert into turma(ano, semestre, codigo_curso, codigo_disciplina, codigo_professor) values (2017, 1, 1, 1, 1);
insert into turma(ano, semestre, codigo_curso, codigo_disciplina, codigo_professor) values (2017, 1, 1, 2, 2);
insert into turma(ano, semestre, codigo_curso, codigo_disciplina, codigo_professor) values (2017, 1, 1, 3, 1);
insert into turma(ano, semestre, codigo_curso, codigo_disciplina, codigo_professor) values (2017, 1, 1, 4, 1);

delimiter $
create trigger validar_qtd_minima_aluno_turma before insert on turma
for each row
begin
	
	set @quantidade = (select
							count(*)
						from
							intencao_disciplina
						where 
							codigo_disciplina = new.codigo_disciplina);

    
    if @quantidade < 10 then
		signal sqlstate '45000' set message_text = 'Uma turma deve ter no mínimo 10 alunos.';
	end if;
    
end; $
delimiter ;


delimiter $
drop trigger if exists trigger_validar_qtd_maxima_aluno_turma $
create trigger trigger_validar_qtd_maxima_aluno_turma before insert on turma  
for each row
begin
	 
	set @quantidade = (select
							count(*)
						from
							intencao_disciplina
						where 
							codigo_disciplina = new.codigo_disciplina);

    
    if @quantidade > 30 then
		signal sqlstate '45000' set message_text = 'Uma turma deve ter no máximo 30 alunos.';
	end if;
end $
delimiter ;

drop table if exists matricula_turma;
create table matricula_turma(
	codigo_turma int,
    codigo_matricula int,
    
    primary key(codigo_turma, codigo_matricula),
    
    foreign key(codigo_turma) references turma(codigo),
    foreign key(codigo_matricula) references matricula(codigo)
);

delimiter $$

create procedure get_periodo_atual (out ano int, out semestre int)
begin
	set @data_atual = now();
    set ano = year(@data_atual);
    set @mes = month(@data_atual);
    
    if (@mes <= 6) then
		set semestre = 1;
	else
		set semestre = 2;
	end if;
end $$

delimiter ;

delimiter $$
drop trigger if exists trigger_limitar_disciplinas_do_aluno_no_periodo $$
create trigger trigger_limitar_disciplinas_do_aluno_no_periodo before insert on matricula_turma
for each row
begin
	declare v_ano, v_semestre int;
    call get_periodo_atual(v_ano, v_semestre);
    
	set @qtd_turmas = (	select count(*) 
						from matricula_turma mt
                        inner join turma t on t.codigo = mt.codigo_turma
						where 
							mt.codigo_matricula = new.codigo_matricula
                            and t.ano = v_ano
                            and t.semestre = v_semestre);
	
    if @qtd_turmas > 7 then
		signal sqlstate '45000' set message_text = 'Um aluno só pode se inscrever em no máximo 7 disciplinas.';
	end if;
    
end $$

delimiter ;

insert into matricula_turma values (1, 1);
insert into matricula_turma values (1, 2);
insert into matricula_turma values (2, 3);
insert into matricula_turma values (3, 4);
insert into matricula_turma values (4, 5);

drop table if exists disciplina_aproveitada;
create table disciplina_aproveitada(
	codigo_transferencia int,
    codigo_curso int,
    codigo_disciplina int,
    
    primary key(codigo_transferencia, codigo_curso, codigo_disciplina),
    
    foreign key(codigo_transferencia) references matricula_transferencia(codigo_transferencia),
    foreign key(codigo_curso, codigo_disciplina) references disciplina_curso(codigo_curso, codigo_disciplina)
);

drop table if exists historico_matricula;
create table historico_matricula(
	codigo_matricula int,
    codigo_curso int,
    codigo_disciplina int,
    ano int not null,
    semestre int not null,
    nota_final decimal(3, 1) not null,
    
    primary key(codigo_matricula, codigo_curso, codigo_disciplina),
    
    foreign key(codigo_matricula) references matricula(codigo),
    foreign key(codigo_curso, codigo_disciplina) references disciplina_curso(codigo_curso, codigo_disciplina)
);

insert into historico_matricula values (4, 1, 1, 2015, 2, 8.0);
insert into historico_matricula values (4, 1, 2, 2016, 1, 9.5);
insert into historico_matricula values (4, 1, 3, 2016, 2, 7.2);

insert into historico_matricula values (3, 1, 1, 2016, 1, 10.0);
insert into historico_matricula values (3, 1, 2, 2016, 2, 7.0);

insert into historico_matricula values (2, 1, 1, 2016, 2, 8.0);


DELIMITER $$
DROP PROCEDURE IF EXISTS fechar_turma $$
CREATE PROCEDURE fechar_turma(in curso int, in disciplina int, in professor int)
BEGIN
	declare done int default false;
	declare codigo_turma_atual, matricula_aluno, v_ano, v_semestre int;
    
    declare cur1 cursor for ( 
								select codigo_matricula 
								from intencao_disciplina 
								where 
									codigo_curso = curso 
									and codigo_disciplina = disciplina
							);
    
    declare continue handler for not found set done = true;
	
    -- call get_periodo_atual(v_ano, v_semestre);
    set @data_atual = now();
    set @ano = year(@data_atual);
    set @mes = month(@data_atual);
    
    if (@mes <= 6) then
		set @semestre = 1;
	else
		set @semestre = 2;
	end if;
    
    insert into turma (ano, semestre, codigo_professor, codigo_curso, codigo_disciplina) values (@ano, @semestre, professor, curso, disciplina);
    select max(codigo) into codigo_turma_atual from turma;
    
    open cur1;
    loop_intencao_disciplina: loop
		fetch cur1 into matricula_aluno;
        if done then 
			leave loop_intencao_disciplina; 
		end if;
        
        insert into matricula_turma (codigo_turma, codigo_matricula) values (codigo_turma_atual, matricula_aluno);
        insert into desempenho (codigo_matricula, codigo_curso, codigo_disciplina, ano, semestre) 
        values (matricula_aluno, curso, disciplina, @ano, @semestre);
    end loop;    
    
    
    delete from intencao_disciplina
    where 
		codigo_curso = curso
        and codigo_disciplina = disciplina;
END $$
DELIMITER ;

DELIMITER $$
drop procedure if exists get_disciplinas_do_periodo $$
CREATE PROCEDURE get_disciplinas_do_periodo (in cpf_aluno int)
BEGIN
	select *
	from aluno a
	inner join matricula m on a.codigo = m.codigo_aluno
	inner join desempenho d on m.codigo = d.codigo_matricula
    where a.cpf = cpf_aluno;
END $$

DELIMITER ;

DELIMITER $$
drop procedure if exists get_matriculas_trancadas $$
CREATE PROCEDURE get_matriculas_trancadas()
BEGIN
	select a.*, m.codigo as codigo_matricula, m.matricula, m.coeficiente_rendimento, m.situacao, m.codigo_aluno, m.codigo_curso
	from aluno a
	inner join matricula m on a.codigo = m.codigo_aluno
    where m.situacao = 2;
END $$

DELIMITER ;

