create database if not exists  gerenciadorFloricultura;
use gerenciadorFloricultura;

create table if not exists funcionarios(
idfunc int auto_increment primary key,
nomeFunc varchar(50) not null,
fonefunc varchar(15)not null, 
emailfunc varchar(50)not null,
login varchar(15) not null unique,
senha varchar(15) not null,
perfil varchar(20) not null
);

create table  if not exists clientes(
idcli int auto_increment primary key,
nomecli varchar(50) not null,
cpfcli varchar(11) not null,
endcli varchar(100) not null,
fonecli varchar(50)not null,
emailcli varchar(50)not null
);

create table if not exists produtos(
idprod int auto_increment primary key,
nomeprod varchar(50) not null,
precoprod decimal(10,2) not null,
dimensao varchar(15) not null,
descricao varchar(50)not null    
);


--- revisar e criar tabela vendas
--create table if not exists vendas(
--idvend int auto_increment primary key,
--data_vendas timestamp default current_timestamp,
--idcli int not null,
--iduser int not null,
--idprod int not null,
--foreign key(idcli) references funcionarios(idcli),
--foreign key(iduser) references usuarios(iduser),
--foreign key(idprod) references produtos(idprod)
--);
