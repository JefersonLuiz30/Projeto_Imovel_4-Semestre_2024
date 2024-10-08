CREATE TABLE imovel (
codigo integer not null auto_increment,
rua varchar (100),
numero varchar (10),
tamanho numeric (10,3),
valor numeric (10,2),
CONSTRAINT pk_imovel PRIMARY KEY(codigo)
)ENGINE=INNODB;

--ENGINE=INNODB;(Aumentar a segurança da tabela mas deixa mais lento