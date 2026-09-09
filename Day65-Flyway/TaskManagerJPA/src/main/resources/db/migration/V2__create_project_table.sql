-- V2: Creates the project table (Hibernate's default table name for the
-- Project entity, since it's a single-word class name - no @Table
-- override needed here, unlike User).

CREATE TABLE project (
    id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL
);
