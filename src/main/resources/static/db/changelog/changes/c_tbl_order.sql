--liquibase formatted sql

--changeset r.shams:tbl|+tbl_order
create table tbl_order
(
    id        NUMERIC(20)  not null,
    user_id   VARCHAR(255) not null,
    count    NUMERIC(19),
    count_price    NUMERIC(19),
    type    VARCHAR(255),
    instrument_type    VARCHAR(255),
    registered_date TIMESTAMP,
    n_version NUMERIC(10)  NOT NULL,
    constraint pk_tbl_order
        primary key (id)
);

--changeset r.shams:seq|+seq_order
CREATE SEQUENCE "TBL_ORDER_SEQ" MINVALUE 1 INCREMENT BY 50 START WITH 1 CACHE 20;