DROP TABLE IF EXISTS company;

CREATE TABLE company (
    id SERIAL,
    name VARCHAR(255) NOT NULL,
    surname VARCHAR(255) NOT NULL,
    email VARCHAR(255)
);

INSERT INTO company(name, surname, email) VALUES ('Vaadin', 'Java', 'vaadin@corp.com');
INSERT INTO company(name, surname, email) VALUES ('Stanislav', 'Terehin', 'stas@gmail.com');
INSERT INTO company(name, surname, email) VALUES ('Galina', 'Shmeleva', 'galashmel@yandex.ru');
INSERT INTO company(name, surname, email) VALUES ('Roman', 'Kruglov', 'krom@rambler.ru');
INSERT INTO company(name, surname, email) VALUES ('Margo', 'Nerobi', 'margosha@gmail.com');
