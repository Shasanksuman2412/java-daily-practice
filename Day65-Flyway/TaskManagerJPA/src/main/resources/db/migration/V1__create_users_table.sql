-- V1: Creates the users table.
-- Named "users", not "user" - "user" is a reserved word in the SQL
-- standard, and while some databases tolerate it as a table name,
-- deliberately avoiding it here sidesteps a genuinely common gotcha.
-- This matches @Table(name = "users") on the User entity.

CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    username VARCHAR(255) NOT NULL UNIQUE,
    password VARCHAR(255) NOT NULL,
    role VARCHAR(255) NOT NULL
);
