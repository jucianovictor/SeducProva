INSERT INTO turma(nome, turno) VALUES("Turma A", 0);
INSERT INTO turma(nome, turno) VALUES("Turma B", 0);
INSERT INTO turma(nome, turno) VALUES("Turma C", 0);
INSERT INTO turma(nome, turno) VALUES("Turma D", 1);
INSERT INTO turma(nome, turno) VALUES("Turma E", 1);

INSERT INTO professor(nome, cpf) VALUES ("Armando", "67919844061");
INSERT INTO professor(nome, cpf) VALUES ("Paulo", "87956217091");

INSERT INTO aluno (cidade_natal, dt_nascimento, bairro, cidade, estado, num_casa, rua, matricula, nome, sexo) 
VALUES ("Fortaleza", "2002-03-01", "Aldeota", "Fortaleza", "Ceará", "809", "Rua 721", "23153920150501", "José", 0);

INSERT INTO aluno (cidade_natal, dt_nascimento, bairro, cidade, estado, num_casa, rua, matricula, nome, sexo) 
VALUES ("Fortaleza", "2002-03-10", "Conjunto Ceará", "Fortaleza", "Ceará", "11", "Rua 12", "23153920150523", "Ana", 1);

INSERT INTO aluno (cidade_natal, dt_nascimento, bairro, cidade, estado, num_casa, rua, matricula, nome, sexo) 
VALUES ("Fortaleza", "2003-04-10", "Meireles", "Fortaleza", "Ceará", "11", "Rua 12", "23153920150978", "Ana", 1);

INSERT INTO aluno (cidade_natal, dt_nascimento, bairro, cidade, estado, num_casa, rua, matricula, nome, sexo) 
VALUES ("Fortaleza", "2003-03-09", "Granja Portugal", "Fortaleza", "Ceará", "232", "Rua 333", "23153920150599", "Marcia", 1);

INSERT INTO aluno (cidade_natal, dt_nascimento, bairro, cidade, estado, num_casa, rua, matricula, nome, sexo) 
VALUES ("Fortaleza", "2003-03-07", "Parangaba", "Fortaleza", "Ceará", "819", "Rua 444", "23153920150333", "Lucas", 0);

INSERT INTO disciplina(nome, professor_id, turma_id) VALUES ("Artes", 1, 1);
INSERT INTO disciplina(nome, professor_id, turma_id) VALUES ("Matemática", 2, 1);

INSERT INTO aluno_turma (aluno_id, turma_id)  VALUES (1, 1);
INSERT INTO aluno_turma (aluno_id, turma_id)  VALUES (1, 2);

INSERT INTO aluno_turma (aluno_id, turma_id)  VALUES (2, 1);
INSERT INTO aluno_turma (aluno_id, turma_id)  VALUES (2, 2);
INSERT INTO aluno_turma (aluno_id, turma_id)  VALUES (2, 3);