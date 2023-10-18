--liquibase formatted sql

--changeset r.shams:tbl|+tbl_purchase-order
create table tbl_purchase_order
(
    id              NUMERIC(20) not null,
    count           NUMERIC(10),
    price           NUMERIC(19, 2),
    type            VARCHAR(255),
    status          VARCHAR(255),
    settlement_date TIMESTAMP,
    client          VARCHAR(255),
    stock           VARCHAR(255),
    n_version       NUMERIC(10) NOT NULL,
    constraint pk_tbl_purchase_order
        primary key (id),
    constraint fk_tbl_purchase_order_client foreign key (client) references tbl_client (exchange_code),
    constraint fk_tbl_purchase_order_stock foreign key (stock) references tbl_stock (code),
    constraint u_tbl_purchase_order_client_stock unique (client, stock)
);

--changeset r.shams:seq|+seq_purchase-order
CREATE SEQUENCE "seq_purchase_order" MINVALUE 1 INCREMENT BY 50 START WITH 1 CACHE 20;