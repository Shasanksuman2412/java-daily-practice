-- V3: Creates the task table, including the project_id foreign key
-- (matching @JoinColumn(name = "project_id") on the Task entity).
-- Depends on V2 already having created the project table.

CREATE TABLE task (
    id SERIAL PRIMARY KEY,
    title VARCHAR(100) NOT NULL,
    completed BOOLEAN NOT NULL DEFAULT FALSE,
    project_id INTEGER REFERENCES project(id) ON DELETE CASCADE
);
