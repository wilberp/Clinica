insert into pessoa(nome,cpf,data_nascimento,prontuario,dtype) values('Alberto Augusto','12365478978','1984-05-15','123456', 'Paciente'); 
insert into endereco(rua, numero, cidade, paciente_id) values('Rua X','55','Araraquara', 1); 
insert into pessoa(nome,cpf,data_nascimento,prontuario,dtype) values('Maria Joaquina','12365478978','1858-12-21','123457', 'Paciente');
insert into endereco(rua, numero, cidade, paciente_id) values('Alameda da Lagoa','01','Portugal', 2);
insert into pessoa(nome,cpf,data_nascimento,crm, especialidade, dtype) values('Jose Tadeu','12365478978','1858-12-21','123457','Clinico Geral','Medico');
insert into pessoa(nome,cpf,data_nascimento,crm, especialidade, dtype) values('Maria do Ceu','12365478978','1858-12-21','123457','Clinico Geral','Medico');
insert into pessoa(nome,cpf,data_nascimento,crm, especialidade, dtype) values('Luiz dos Santos','12365478978','1858-12-21','123457','Pediatra','Medico');
insert into agenda(data,hora,situacao, medico_id, paciente_id) values ('2021-07-30', '11:00', 'L', 3, null);
insert into agenda(data,hora,situacao, medico_id, paciente_id) values ('2021-07-30', '10:00', 'A', 3, 1);
insert into agenda(data,hora,situacao, medico_id, paciente_id) values ('2021-07-30', '12:00', 'L', 3, null);
insert into agenda(data,hora,situacao, medico_id, paciente_id) values ('2021-07-30', '13:00', 'L', 3, null);
insert into agenda(data,hora,situacao, medico_id, paciente_id) values ('2021-07-30', '11:00', 'L', 5, null);
insert into agenda(data,hora,situacao, medico_id, paciente_id) values ('2021-07-30', '10:00', 'L', 5, null);
insert into agenda(data,hora,situacao, medico_id, paciente_id) values ('2021-07-30', '12:00', 'A', 5, 2);
insert into agenda(data,hora,situacao, medico_id, paciente_id) values ('2021-07-30', '13:00', 'L', 5, null);