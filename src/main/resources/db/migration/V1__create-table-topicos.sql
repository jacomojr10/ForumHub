create table topicos(
    id BIGINT not null auto_increment,
    titulo VARCHAR(150) NOT NULL,
    mensagem VARCHAR(500) NOT NULL,
    dataCriacao TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    statustopico VARCHAR(15) NULL,
    autor VARCHAR(150) NOT NULL,
    curso VARCHAR(100),
    ativo TINYINT DEFAULT 1,

    primary key(id)

 );