create table coffee
(
    id              bigserial
        constraint coffee_pkey
            primary key,
    brand           varchar(255),
    characteristics varchar(255),
    origin          varchar(255)
);

alter table coffee
    owner to postgres;