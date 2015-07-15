create table Vacina(
	id serial,
	nome_vacina varchar(100),
	dosagem integer,
	info_vacina varchar(500),
	constraint pk_vac primary key (id)
);

create table Ubs(
	id serial,
	nome_ubs varchar(100),
	endereco varchar(200),
	hr_atendimento varchar(50),
	constraint pk_ubs primary key (id)
);

create table ProfissionalDeSaude (
	id serial,
	nome varchar (50),
	dt_nascimento date,
	n_coren numeric,
	dt_emissao_coren date,
	dt_vencimento_coren date,
	status varchar(50),
	nivel_acesso varchar(15),
	login varchar (50),
	senha varchar (20),
	constraint pk_pds primary key (id)
);

create table Paciente(
	suv serial,
	nome varchar (50),
	cpf numeric,
	dt_nascimento date,
	endereco varchar(100),
	telefone varchar(12),
	email varchar(50),
	sexo varchar(1),
	nivel_acesso varchar(15),
	login varchar (50),
	senha varchar (20),
	constraint pk_paciente primary key (suv)
);


create table Caderneta(
	id_ubs serial,
	id_pds serial,
	suv_paciente serial,
	id_vacina serial,
        dt_vacinacao date,
	dt_retorno date,
	nome_responsavel varchar (50),
	cpf_responsavel numeric,
	constraint pk_pds_cad primary key (id_ubs, id_pds, suv_paciente,id_vacina),
	constraint fk_cad_ubs foreign key (id_ubs) references Ubs (id),  
	constraint fk_cad_pds foreign key (id_pds) references ProfissionalDeSaude(id),
	constraint fk_cad_pac foreign key (suv_paciente) references Paciente(suv),
	constraint fk_cad_vac foreign key (id_vacina) references Vacina(id)
);	


insert into ProfissionalDeSaude (nome, dt_nascimento, n_coren, dt_emissao_coren, login, senha, id_nivel) values ('Paulo Eduardo', '1985-12-09',34041421879,'Paulo', '1234', 1);
insert into Usuario(nome, dt_nascimento, cpf,login, senha, id_nivel) values ('Aine', '13-05-1970',310230249,'Aline', '1234', 2);

SELECT *
FROM Usuario

select *
from vacina