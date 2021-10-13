  create table authors (
       id bigint not null,
        first_name varchar(255),
        last_name varchar(255),
        primary key (id)
    );

    create table book_author_table (
       book_id bigint not null,
        author_id bigint not null
    );

    create table book_type (
       id bigint not null,
        name varchar(255),
        primary key (id)
    );

    create table books (
       id bigint not null,
        isbn varchar(255) not null,
        number_of_pages integer,
        publish_date date,
        title varchar(255) not null,
        category bigint,
        publisher bigint,
        type bigint,
        primary key (id)
    );

    create table category (
       id bigint not null,
        name varchar(255),
        primary key (id)
    );

    create table publishers (
       id bigint not null,
        name varchar(255),
        primary key (id)
    );

    alter table books
       drop constraint if exists UK_kibbepcitr0a3cpk3rfr7nihn;

    alter table books
       add constraint UK_kibbepcitr0a3cpk3rfr7nihn unique (isbn);

    alter table books
       drop constraint if exists UK_5mtto2jcmfrwfg0p1ui8mnweu;

    alter table books
       add constraint UK_5mtto2jcmfrwfg0p1ui8mnweu unique (title);
 create sequence hibernate_sequence start with 1 increment by 1;


    alter table book_author_table
       add constraint FKb0nr0sey4p78gyokwk3yleuej
       foreign key (author_id)
       references authors;

    alter table book_author_table
       add constraint FKb3trglv8l4h3b4lo11ddm4cj4
       foreign key (book_id)
       references books;

    alter table books
       add constraint FKphqmbibv4ocmalhg54wi7axfa
       foreign key (category)
       references category;

    alter table books
       add constraint FK2oqwxafx0a86monshr9mssp43
       foreign key (publisher)
       references publishers;

    alter table books
       add constraint FK6m20000d5pt2opoxaxtadv8ao
       foreign key (type)
       references book_type;