INSERT INTO CATEGORY(id, name) VALUES (1, 'Eurogames');
INSERT INTO CATEGORY(id, name) VALUES (2, 'Ameritrash');
INSERT INTO CATEGORY(id, name) VALUES (3, 'Familiar');

INSERT INTO AUTHOR(id, name, nationality) VALUES (1, 'Alan R. Moon', 'US');
INSERT INTO AUTHOR(id, name, nationality) VALUES (2, 'Vital Lacerda', 'PT');
INSERT INTO AUTHOR(id, name, nationality) VALUES (3, 'Simone Luciani', 'IT');
INSERT INTO AUTHOR(id, name, nationality) VALUES (4, 'Perepau Llistosella', 'ES');
INSERT INTO AUTHOR(id, name, nationality) VALUES (5, 'Michael Kiesling', 'DE');
INSERT INTO AUTHOR(id, name, nationality) VALUES (6, 'Phil Walker-Harding', 'US');

INSERT INTO GAME(id, title, age, category_id, author_id) VALUES (1, 'On Mars', '14', 1, 2);
INSERT INTO GAME(id, title, age, category_id, author_id) VALUES (2, 'Aventureros al tren', '8', 3, 1);
INSERT INTO GAME(id, title, age, category_id, author_id) VALUES (3, '1920: Wall Street', '12', 1, 4);
INSERT INTO GAME(id, title, age, category_id, author_id) VALUES (4, 'Barrage', '14', 1, 3);
INSERT INTO GAME(id, title, age, category_id, author_id) VALUES (5, 'Los viajes de Marco Polo', '12', 1, 3);
INSERT INTO GAME(id, title, age, category_id, author_id) VALUES (6, 'Azul', '8', 3, 5);

INSERT INTO CLIENT(id, name) VALUES (1, 'Juan Díez');
INSERT INTO CLIENT(id, name) VALUES (2, 'José López');
INSERT INTO CLIENT(id, name) VALUES (3, 'Javi Alfaro');
INSERT INTO CLIENT(id, name) VALUES (4, 'Andrés Iniesta');

INSERT INTO LOAN(id, game_id, client_id, borrowed_date, return_date) VALUES (1, 1, 1, '2020-01-01', '2020-01-06');
INSERT INTO LOAN(id, game_id, client_id, borrowed_date, return_date) VALUES (2, 2, 2, '2020-01-20', '2020-01-30');
INSERT INTO LOAN(id, game_id, client_id, borrowed_date, return_date) VALUES (3, 3, 3, '2020-02-01', '2020-02-06');
INSERT INTO LOAN(id, game_id, client_id, borrowed_date, return_date) VALUES (4, 4, 4, '2020-03-01', '2020-03-06');
INSERT INTO LOAN(id, game_id, client_id, borrowed_date, return_date) VALUES (5, 5, 1, '2020-04-01', '2020-04-06');
INSERT INTO LOAN(id, game_id, client_id, borrowed_date, return_date) VALUES (6, 6, 2, '2020-05-01', '2020-05-06');
INSERT INTO LOAN(id, game_id, client_id, borrowed_date, return_date) VALUES (7, 1, 3, '2020-06-01', '2020-06-06');