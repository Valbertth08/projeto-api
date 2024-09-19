CREATE TABLE tb_usuario(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    login VARCHAR(255) NOT NULL,
    senha VARCHAR(255) NOT NULL,
    role  VARCHAR(50) NOT NULL
);
CREATE TABLE tb_formulario(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(255) NOT NULL,
    data TIMESTAMP NOT NULL
);
CREATE TABLE tb_categoria(
    id BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL NOT NULL,
    peso DOUBLE NOT NULL,
    nome VARCHAR(50) NOT NULL
);
create table tb_pergunta(
    id BIGINT PRIMARY KEY AUTO_INCREMENT NOT NULL,
    texto VARCHAR(50) NOT NULL,
    tipo_pergunta VARCHAR(50),
    formulario_id BIGINT NOT NULL,
    categoria_id BIGINT NOT NULL,
    FOREIGN KEY (categoria_id) REFERENCES tb_categoria(id),
    FOREIGN KEY (formulario_id) REFERENCES tb_formulario(id)
);

CREATE TABLE tb_cliente(
    id BIGINT NOT NULL,
    nome VARCHAR(50) NOT NULL,
    FOREIGN KEY (id) REFERENCES tb_usuario(id)
);

CREATE TABLE tb_admin(
    id BIGINT NOT NULL,
    nome VARCHAR(50) NOT NULL,
    FOREIGN KEY (id) REFERENCES tb_usuario(id)
);

CREATE TABLE tb_resposta(
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    valor BIGINT NOT NULL,
    pergunta_id BIGINT NOT NULL ,
    usuario_id BIGINT NOT NULL,
    formulario_id BIGINT NOT NULL,
    data TIMESTAMP NOT NULL,
    FOREIGN KEY (pergunta_id) REFERENCES tb_pergunta(id),
    FOREIGN KEY (usuario_id) REFERENCES tb_usuario(id)
);

