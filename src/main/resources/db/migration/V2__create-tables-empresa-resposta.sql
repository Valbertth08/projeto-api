CREATE TABLE tb_empresa (
    id int AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(255) NOT NULL
);
CREATE TABLE tb_resposta (
    id int AUTO_INCREMENT PRIMARY KEY,
    texto VARCHAR(255) NOT NULL,
    pergunta_id int,
    empresa_id int,
    FOREIGN KEY (pergunta_id) REFERENCES tb_pergunta(id),
    FOREIGN KEY (empresa_id) REFERENCES tb_empresa(id)
);