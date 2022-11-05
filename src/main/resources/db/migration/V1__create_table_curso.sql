CREATE TABLE curso (
   id BIGINT AUTO_INCREMENT NOT NULL,
   nome VARCHAR(50),
   categoria VARCHAR(50),
   PRIMARY KEY (id)
);

INSERT INTO curso(id, nome, categoria) VALUES (1, 'Kotlin', 'Programacao');