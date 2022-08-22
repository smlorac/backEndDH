create table if not exists endereco (id int auto_increment primary key, rua varchar(255), numero int, cidade varchar(255), bairro varchar(255));

create table if not exists paciente (id int auto_increment primary key, nome varchar(255), sobrenome varchar(255), rg varchar(255), dataCadastro date, idEndereco int, foreign key (idEndereco) references endereco(id));

create table if not exists dentista(id int auto_increment primary key, sobrenome varchar(255), nome varchar(255), matricula varchar(255));