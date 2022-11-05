CREATE TABLE resposta (
   id BIGINT AUTO_INCREMENT NOT NULL,
   mensagem VARCHAR(300) NOT NULL,
   data_criacao datetime NOT NULL,
   autor_id BIGINT,
   topico_id BIGINT,
   solucao BOOLEAN NOT NULL,
   PRIMARY KEY (id),
   FOREIGN KEY (topico_id) REFERENCES topico (id),
   FOREIGN KEY (autor_id) REFERENCES usuario (id)
);