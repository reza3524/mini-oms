--liquibase formatted sql

--changeset r.shams:tbl|+tbl_stock
create table tbl_stock
(
    id              NUMERIC(20)  not null,
    code            VARCHAR(255) not null
        constraint code unique,
    settlement_type VARCHAR(255),
    n_version       NUMERIC(10)  NOT NULL,
    constraint pk_tbl_stock
        primary key (id)
);

--changeset r.shams:seq|+seq_stock
CREATE SEQUENCE "seq_stock" MINVALUE 1 INCREMENT BY 50 START WITH 1 CACHE 20;