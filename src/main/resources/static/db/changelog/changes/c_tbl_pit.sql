--liquibase formatted sql

--changeset r.shams:tbl|+tbl_pit
create table tbl_pit
(
    id        NUMERIC(20) not null,
    location  NUMERIC(10),
    size      NUMERIC(10),
    name      VARCHAR(255),
    side      VARCHAR(255),
    is_main   BOOLEAN,
    n_version NUMERIC(10) NOT NULL,
    constraint pk_tbl_pit
        primary key (id)
);

--changeset r.shams:seq|+seq_pit
CREATE SEQUENCE "TBL_PIT_SEQ" MINVALUE 1 INCREMENT BY 50 START WITH 1 CACHE 20;