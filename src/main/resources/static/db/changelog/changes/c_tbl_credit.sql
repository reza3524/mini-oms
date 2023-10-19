--liquibase formatted sql

--changeset r.shams:tbl|+tbl_credit
create table tbl_credit
(
    id        NUMERIC(20)  not null,
    user_id   VARCHAR(255) not null
        constraint user_id unique,
    amount    NUMERIC(19),
    n_version NUMERIC(10)  NOT NULL,
    constraint pk_tbl_credit
        primary key (id)
);

--changeset r.shams:seq|+seq_credit
CREATE SEQUENCE "TBL_CREDIT_SEQ" MINVALUE 1 INCREMENT BY 50 START WITH 1 CACHE 20;