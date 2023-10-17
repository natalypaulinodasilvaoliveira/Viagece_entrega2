CREATE DATABASE viagece;

USE viagece;

CREATE TABLE Destinos (
id_destino integer(20) PRIMARY KEY auto_increment,
data_entrada VARCHAR(10),
data_saida VARCHAR(10),
valor_compra Decimal (10,2)
);

CREATE TABLE Compra (
codigo_reserva integer PRIMARY KEY auto_increment,
valor_total DECIMAL(10,2),
data_compra VARCHAR(10),
id_destino varchar (20),
id_viajante integer,
foreign key (id_viajante) references Viajantes (id_viajante),
foreign key (id_destino) references Destinos (id_destino)
);

CREATE TABLE Viajantes (
id_viajante integer(10) auto_increment,
nome_viajante VARCHAR(40),
email_viajante VARCHAR(80),
senha_viajante VARCHAR(10)
);

-- salvando (create) os dados
insert into Viajantes (id_viajante, nome_viajante, email_viajante, senha_viajante) values 
(default,'Nataly','naty@gmail.com','1234'),
(default,'Joao','joao@gmail.com','5678')
;

insert into Destinos (id_destino, data_entrada, data_saida, valor_compra) values
('1','20/10/2023', 1, 2),
('2','11/03/2024', 2, 1);

insert into Compras (codigo_reserva, valor_total, data_compra, id_destino, id_viajante) values
('499.99', '12/10/2023'),
('1999.99', '23/09/1959')
;

-- consulta (read) dos dados
select * from Destinos;
select * from Viajantes;
select * from Compras;
select * from id_viajante order by codigo_reserva asc;
select c.codigo_reserva, c.data_compra, c.total_compra, d.*, v.* from Compras c, Destinos d, Viajantes v 
where c.destino = d.destino and c.id_viajante = v.id_viajante;

-- atualizando (update) os dados
update Viajantes set nome = 'Nataly', email = 'naty@gmail.com', senha = '1234' where id_viajante = 6;
update Destinos set destino = 'Jericoacoara', data_entrada = '11/05/2012', data_saida = '16/07/2013', valor_compra = '1999.99' where id_destino = 3;
update Compras set data_compra = '11/04/2012', valor_total = '2199.99', id_viajante = '1', id_destino = '3';

-- deletando (delete) os dados
delete from Viajantes where id_viajante = 1;
delete from Destinos where id_destino = 3;
delete from Compras where codigo_reserva = 8;