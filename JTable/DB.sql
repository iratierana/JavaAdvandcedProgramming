CREATE DATABASE Saludos;

USE Saludos;

CREATE TABLE Saludo
(
hola varchar(40),
adios varchar(40),
primary key (hola, adios)
);

INSERT INTO Saludo VALUES ('Hola', 'Adios');
INSERT INTO Saludo VALUES ('Kaixo', 'Agur');
INSERT INTO Saludo VALUES ('Hello', 'Bye');
INSERT INTO Saludo VALUES ('Hallo', 'Auf wiedersehen');

CREATE USER 'java'@'localhost' IDENTIFIED BY 'prueba';

GRANT SELECT, UPDATE ON Saludos.Saludo TO 'java'@'localhost';