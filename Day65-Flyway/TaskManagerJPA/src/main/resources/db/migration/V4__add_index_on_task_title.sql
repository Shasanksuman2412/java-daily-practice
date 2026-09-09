-- V4: An example of an INCREMENTAL migration - added after V1-V3 were
-- already applied, rather than editing them. This is the core discipline
-- of Flyway: once a migration has run anywhere (including production),
-- it is never modified again. Need a change? Write a NEW file.

CREATE INDEX idx_task_title ON task(title);
