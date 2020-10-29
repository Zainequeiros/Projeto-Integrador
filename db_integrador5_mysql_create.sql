CREATE TABLE `Produto` (
	`id_produto` INT NOT NULL AUTO_INCREMENT,
	`nome_produto` varchar(255) NOT NULL,
	`descricao_produto` TEXT NOT NULL,
	`produtor_produto` varchar(255) NOT NULL,
	`preco_produto` DECIMAL(5,2) NOT NULL,
	`id_categoria` INT NOT NULL,
	PRIMARY KEY (`id_produto`)
);

CREATE TABLE `Categoria` (
	`id_categoria` INT NOT NULL AUTO_INCREMENT,
	`tipo` varchar(255) NOT NULL,
	`organico` BOOLEAN NOT NULL,
	`unidade_medida_categoria` varchar(20) NOT NULL,
	PRIMARY KEY (`id_categoria`)
);

CREATE TABLE `Usuario` (
	`id_usuario` INT NOT NULL AUTO_INCREMENT,
	`nome_usuario` varchar(255) NOT NULL,
	`email_usuario` varchar(255) NOT NULL,
	`senha_usuario` varchar(255) NOT NULL,
	PRIMARY KEY (`id_usuario`)
);

ALTER TABLE `Produto` ADD CONSTRAINT `Produto_fk0` FOREIGN KEY (`id_categoria`) REFERENCES `Categoria`(`id_categoria`);

