--liquibase formatted sql

--changeset r.shams:tbl|+tbl_portfolio
create table tbl_portfolio
(
    id        NUMERIC(20)  not null,
    user_id   VARCHAR(255) not null,
    count    NUMERIC(19),
    instrument_type    VARCHAR(255),
    n_version NUMERIC(10)  NOT NULL,
    constraint pk_tbl_portfolio
        primary key (id),
    constraint u_tbl_portfolio_user_id_instrument_type unique (user_id, instrument_type)
);

--changeset r.shams:seq|+seq_portfolio
CREATE SEQUENCE "TBL_PORTFOLIO_SEQ" MINVALUE 1 INCREMENT BY 50 START WITH 1 CACHE 20;