CREATE TABLE answer (
        id SERIAL PRIMARY KEY,
        question TEXT NOT NULL,
        category_id INTEGER NOT NULL REFERENCES category(id)
);