create table dado (
     id bigint not null auto_increment,
    sistema varchar(60) not null,
    usuario varchar(50) not null,
    senha varchar(60) not null,

    primary key (id)
) engine=InnoDB default charset=utf8;