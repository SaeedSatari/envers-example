create table customers
(
    customer_id      bigint not null auto_increment,
    first_name       varchar(255),
    last_name        varchar(255),
    created_by       varchar(255),
    created_at       datetime(6),
    last_modified_by varchar(255),
    last_modified_at datetime(6),
    primary key (customer_id)
) engine = InnoDB;

create table customers_aud
(
    customer_id      bigint  not null,
    first_name       varchar(255),
    last_name        varchar(255),
    created_by       varchar(255),
    created_at       datetime(6),
    last_modified_by varchar(255),
    last_modified_at datetime(6),
    rev              integer not null,
    revtype          tinyint,
    primary key (customer_id, rev)
) engine = InnoDB;

create table hibernate_sequence
(
    next_val bigint
) engine = InnoDB;

insert into hibernate_sequence
values (1);

create table revinfo
(
    revision_number    integer not null,
    revision_timestamp bigint,
    primary key (revision_number)
) engine = InnoDB;
