CREATE TABLE `Produto` (
	`id_produto` int NOT NULL,
	`nome_produto` varchar(255) NOT NULL,
	`descricao_produto` TEXT NOT NULL,
	`produtor_produto` varchar(255) NOT NULL,
	`preco_produto` DECIMAL(5.0,2.0) NOT NULL,
	`foto_produto` VARCHAR(255) NOT NULL,
	`id_categoria` int NOT NULL,
	PRIMARY KEY (`id_produto`)
);

CREATE TABLE `Categoria` (
	`id_categoria` int NOT NULL,
	`tipo` varchar(255) NOT NULL,
	`organico` BOOLEAN NOT NULL,
	`unidade_medida_categoria` varchar(20) NOT NULL,
	PRIMARY KEY (`id_categoria`)
);

CREATE TABLE `Usuario` (
	`id_usuario` int NOT NULL,
	`nome_usuario` varchar(255) NOT NULL,
	`email_usuario` varchar(255) NOT NULL,
	`senha_usuario` varchar(255) NOT NULL,
	PRIMARY KEY (`id_usuario`)
);

ALTER TABLE `Produto` ADD CONSTRAINT `Produto_fk0` FOREIGN KEY (`id_categoria`) REFERENCES `Categoria`(`id_categoria`);

