create table dados (
    id bigint not null auto_increment,
    sistema vachar(60) not null,
    usuario varchar(15) not null,
    senha varchar(20) not null,

    primary key (id)
) engine=InnoDB default character=utf8;