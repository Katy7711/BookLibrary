-- liquibase formatted sql

-- changeset denieva:1

CREATE TABLE IF NOT EXISTS authors
(
    id         BIGSERIAL PRIMARY KEY,
    author_full_name       varchar NOT NULL
);
