/*criando schema da tabela agencia*/ 
create schema agencia;

/*usar schema da tabela agencia*/
use agencia;

/*criando, inserinfo, atualizando  delenado as informações dos clientes*/
create table if not exists cliente (
	CPF_Cliente varchar(14) primary key not null,
    Nome_Cliente varchar(40) not null,
    Email_Cliente varchar(40) not null,
    Telefone_Cliente varchar(15) not null
);
insert into cliente (
	CPF_Cliente, Nome_Cliente, Email_Cliente, Telefone_Cliente
)
VALUES
	('02502603504', 'João Ricardo', 'joaoricardo@gmail.com', '88223536'),
    ('01402503699', 'Maria Vitoria', 'mariavitoria@gmail.com', '88223738'), 
    ('02504209853','Carlos Magno', 'carlosmagno@gmail.com', '92223132');

select * from cliente;
select * from cliente where CPF_Cliente = '01402503699';
update cliente set CPF_Cliente = '02502603504' where CPF_Cliente = '025.026.035-05';
delete from cliente where CPF_Cliente = '02504209853';

/*criando, inserinfo, atualizando  delenado as informações dos contatos*/
create table if not exists contato (
	Assunto varchar(40) not null,
    Mensagem varchar(100) not null,
    fk_Cliente_CPF_Cliente varchar(14),
    constraint foreign key (fk_Cliente_CPF_Cliente) references Cliente(CPF_Cliente) on delete cascade on update cascade
);
insert into contato (
	Assunto, Mensagem, fk_Cliente_CPF_Cliente
)
VALUES
	('Reserva 1',  'olá, gostaria de ter informações sobre reservas 1', '02502603504'),
    ('Reserva 2',  'olá, gostaria de ter informações sobre reservas 2', '01402503699'),
    ('Reserva 3',  'olá, gostaria de ter informações sobre reservas 3', '02504209853');

select * from contato;
update contato set Assunto = 'Reserva 4', Mensagem ='bla bla bla bla' where fk_Cliente_CPF_Cliente = '02504209853';
delete from contato where fk_Cliente_CPF_Cliente = '02502603504';
    
/*criando, inserinfo, atualizando  delenado as informações das Reservas*/
create table if not exists reserva (
	Numero_Reserva int auto_increment primary key,
    Data_Reserva date not null,
    Valor_Reserva decimal(10,2) not null,
    Forma_Pagamento varchar(40) not null,
    fk_Cliente_CPF_Cliente varchar(14),
    fk_Destino_Id_Destino int,
    constraint foreign key (fk_Cliente_CPF_Cliente) references Cliente(CPF_Cliente) on delete cascade on update cascade,
    constraint foreign key (fk_Destino_Id_Destino) references Destino(Id_Destino) on delete cascade on update cascade
);
insert into reserva (
	Data_Reserva, Valor_Reserva, Forma_Pagamento, fk_Cliente_CPF_Cliente, fk_Destino_Id_Destino 
)
VALUES
	('2023-09-25', 850.00, 'Cartão de Crédito', '02502603504', 1),
    ('2023-09-25', 1250.00, 'Pix', '01402503699', 2),
    ('23-12-12', 2000.00, 'pix', '02504209853', 1);

select * from reserva;
update reserva set Data_Reserva = '2023-11-26', Valor_Reserva ='1150.00', Forma_Pagamento = 'pix' 
where Numero_Reserva = 1;
delete from reserva where Numero_Reserva = '1';

/*criando, inserinfo, atualizando  delenado as informações dos destinos*/
create table if not exists destino (
	Id_Destino int auto_increment primary key,
    Nome_Destino varchar(40),
    Preco_Destino decimal(10, 2)
);
insert into Destino (
	Nome_Destino, Preco_Destino
)
VALUES
	('São Paulo', 850.00),
    ('Rio de Janeiro',  1250.00),
    ('Recife', 735.00);
    
select * from destino;
select * from destino where Id_Destino = 1; 
update destino set Nome_Destino = 'SP', Preco_Destino ='950.00' where Id_Destino = 1;
delete from destino where Id_Destino = '1';