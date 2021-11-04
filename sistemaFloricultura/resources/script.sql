create database if not exists  gerenciadorFloricultura;
use gerenciadorFloricultura;

create table if not exists funcionarios(
idfunc int auto_increment primary key,
nomeFunc varchar(50) not null,
fonefunc varchar(15), 
emailfunc varchar(50),
login varchar(15) not null unique,
senha varchar(15) not null
);

create table  if not exists clientes(
idcli int auto_increment primary key,
nomecli varchar(50) not null,
endcli varchar(100),
fonecli varchar(50)not null,
emailcli varchar(50)
);

create table if not exists produtos(
idprod int auto_increment primary key,
nomeprod varchar(50) not null,
precoprod decimal(10,2) not null,
dimensao varchar(15) not null,
descricao varchar(50)not null    
);

create table if not exists fornercedor(
idfornec int auto_increment primary key,
nomefornec varchar(50) not null,
fornec varchar(50)not null   
);

--- revisar e criar tabela vendas
create table if not exists ordemservicos(
idos int auto_increment primary key,
data_os timestamp default current_timestamp,
idcli int not null,
iduser int not null,
idprod int not null,
foreign key(idcli) references clientes(idcli),
foreign key(iduser) references usuarios(iduser),
foreign key(idprod) references produtos(idprod)
);



-- Trazer informações de ordem de serviços

SELECT O.data_os,
C.nomecli, C.endcli,C. fonecli,
U.usuario,
P.nomeprod, P.precoprod, P.dimensao, P.descricao
FROM ordemservicos as O
inner join clientes as C on (O.idcli = C.idcli)
inner join usuarios as U on (O.iduser = U.iduser)
inner join produtos as P on (O.idprod = p.idprod);
