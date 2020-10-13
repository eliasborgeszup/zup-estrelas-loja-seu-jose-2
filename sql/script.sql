-- cria banco de dados --

create database loja_seu_jose
default character set utf8mb4
default collate utf8mb4_general_ci;

-- utiliza banco de dados --

use loja_seu_jose;

-- cria tabela de estoque --

create table estoque (
codigo_barras varchar(13) not null,
nome varchar(45) not null,
modelo_carro varchar(45) not null default 'TODOS',
fabricante varchar(45) not null,
preco_custo decimal(14, 2) not null,
preco_venda decimal(14, 2) not null,
qtd_estoque int not null,
categoria enum('MANUTENCAO', 'RODA', 'PERFORMANCE', 'SOM', '') not null,
primary key (codigo_barras)
) default charset = utf8mb4;

-- insere cinco peças no estoque --

insert into estoque

(codigo_barras, nome, modelo_carro, fabricante,
preco_custo, preco_venda, qtd_estoque, categoria)

values
('111', 'DISCO DE FREIO DIANTEIRO VENTILADO', 'C3', 'FREMAX',
'69.90', '99.90', '10', 'MANUTENÇÃO'),

('222', 'RODA RANLOW ARO 13', default, 'RANLOW',
'300.90', '330.90', '5', 'RODA'),

('333', 'PONTEIRA DUPLA DE ESCAPAMENTO', 'POLO', 'OUTS',
'100.90', '130.90', '2', 'PERFORMANCE'),

('444', 'ALTO FALANTE FULLRANGE 6 POL', default, 'NAR ÁUDIO',
'300.90', '330.90', '5', 'SOM'),

('555', 'KIT EMBREAGEM', 'CIVIC', 'LUK',
'700.90', '730.90', '1', 'MANUTENÇÃO');

-- Verifica itens em estoque --

select * from estoque;