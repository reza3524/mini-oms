--liquibase formatted sql

--changeset r.shams:tbl|+tbl_client
create table tbl_client
(
    id            NUMERIC(20)  not null,
    exchange_code VARCHAR(255) not null
        constraint exchange_code unique,
    firstname     VARCHAR(255),
    lastname      VARCHAR(255),
    n_version     NUMERIC(10) NOT NULL,
    constraint pk_tbl_client
        primary key (id)
);

--changeset r.shams:seq|+seq_client
CREATE SEQUENCE "TBL_CLIENT_SEQ" MINVALUE 1 INCREMENT BY 50 START WITH 1 CACHE 20;