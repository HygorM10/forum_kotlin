CREATE TABLE topico (
   id BIGINT AUTO_INCREMENT NOT NULL,
   titulo VARCHAR(50) NOT NULL,
   mensagem VARCHAR(300) NOT NULL,
   data_criacao datetime NOT NULL,
   status VARCHAR(255) NOT NULL,
   curso_id BIGINT NOT NULL,
   autor_id BIGINT NOT NULL,
   PRIMARY KEY (id),
   FOREIGN KEY (curso_id) REFERENCES curso(id),
   FOREIGN KEY (autor_id) REFERENCES usuario(id)
);