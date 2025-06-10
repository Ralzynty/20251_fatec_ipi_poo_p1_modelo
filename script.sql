CREATE DATABASE db_personagens;

CREATE TABLE tb_personagens (
    codigo SERIAL PRIMARY KEY,
    nome VARCHAR(200) NOT NULL,
    prob_construir FLOAT NOT NULL,
    prob_coletar_madeira FLOAT NOT NULL,
    prob_minerar FLOAT NOT NULL,
    vitorias INT NOT NULL,
    derrotas INT NOT NULL
);

INSERT INTO tb_personagens (nome, prob_construir, prob_coletar_madeira, prob_minerar, vitorias, derrotas)
VALUES
('Bob', '0.2', '0.3', '0.5', '0', '0'),
('Ana', '0.2', '0.6', '0.2', '0', '0');