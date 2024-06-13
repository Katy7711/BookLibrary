-- liquibase formatted sql

-- changeset denieva:1

CREATE TABLE IF NOT EXISTS books
(
    id         BIGSERIAL PRIMARY KEY,
    book_name      varchar NOT NULL,
    author_id   integer REFERENCES authors (id)
    );
