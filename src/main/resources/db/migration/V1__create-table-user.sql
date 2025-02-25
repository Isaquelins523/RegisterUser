CREATE TABLE registered_user (
     id TEXT PRIMARY KEY UNIQUE NOT NULL,
     name TEXT NOT NULL,
     email TEXT NOT NULL,
     age INTEGER NOT NULL
)