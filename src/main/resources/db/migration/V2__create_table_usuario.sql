CREATE TABLE usuario (
   id BIGINT AUTO_INCREMENT NOT NULL,
   nome VARCHAR(255) NOT NULL,
   email VARCHAR(255) NOT NULL,
   PRIMARY KEY (id)
);

INSERT INTO usuario(id, nome, email) VALUES (1, 'Hygor Martins', 'hygor@email.com')