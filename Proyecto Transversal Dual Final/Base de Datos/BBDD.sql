CREATE DATABASE IF NOT EXISTS torneo_debate;
USE torneo_debate;

CREATE TABLE Fase (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL
);

CREATE TABLE Equipo (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    idFase INT,
    clasificado BOOLEAN DEFAULT FALSE,
    FOREIGN KEY (idFase) REFERENCES Fase(id)
);

CREATE TABLE Orador (
    id INT AUTO_INCREMENT PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    idFase INT,
    FOREIGN KEY (idFase) REFERENCES Fase(id)
);

CREATE TABLE PuntuacionOrador (
    id INT AUTO_INCREMENT PRIMARY KEY,
    idOrador INT NOT NULL,
    puntuacion DECIMAL(5,2) NOT NULL,
    idFase INT,
    FOREIGN KEY (idOrador) REFERENCES Orador(id),
    FOREIGN KEY (idFase) REFERENCES Fase(id)
);

INSERT INTO Fase (nombre) VALUES
('Clasificatoria'),
('Cuartos de Final'),
('Semifinal'),
('Final');

INSERT INTO Equipo (nombre, idFase, clasificado) VALUES
('Los Dialécticos', 1, TRUE),
('Argumentum', 1, TRUE),
('Verbo Veloz', 1, TRUE),
('Retórica Suprema', 1, TRUE),
('Los Sofistas', 1, TRUE),
('Elocuentes', 1, TRUE),
('Los Lógicos', 1, TRUE),
('Palabra Viva', 1, TRUE),
('Los Persuasivos', 2, TRUE),
('Razonadores', 2, TRUE),
('Los Disputantes', 2, TRUE),
('Foro Abierto', 2, TRUE),
('Voz y Voto', 3, TRUE),
('Convencidos', 3, TRUE),
('Los Oráculos', 4, FALSE),
('Los Dialógicos', 4, FALSE);

INSERT INTO Orador (nombre, idFase) VALUES
('Lucía Torres', 1),
('Mario Herrera', 1),
('Clara Ruiz', 1),
('Sergio Medina', 1),
('Valeria Gómez', 1),
('Iván Fernández', 1),
('Alicia Romero', 1),
('Pablo Navarro', 1),
('Elena Sánchez', 2),
('Javier Ortega', 2),
('Marta Castillo', 2),
('Rubén Morales', 2),
('Paula Díaz', 2),
('Carlos Jiménez', 2),
('Andrea Ramos', 2),
('David Lozano', 2),
('Sofía Vidal', 3),
('Gabriel Castro', 3),
('Nuria Delgado', 3),
('Álvaro Peña', 3),
('Patricia León', 3),
('Hugo Molina', 3),
('Isabel Cano', 3),
('Raúl Gil', 3),
('Teresa Paredes', 4),
('Diego Marín', 4),
('Sandra Molina', 4),
('Víctor Ríos', 4),
('Beatriz Solís', 4),
('Miguel Cordero', 4),
('Cristina Vera', 4),
('Alejandro Salas', 4);

INSERT INTO PuntuacionOrador (idOrador, puntuacion, idFase) VALUES
(1, 89.5, 1),
(2, 92.0, 1),
(3, 85.0, 1),
(4, 90.0, 1),
(5, 88.0, 1),
(6, 91.0, 1),
(7, 86.5, 1),
(8, 93.0, 1),
(9, 87.0, 2),
(10, 94.0, 2),
(11, 89.0, 2),
(12, 95.0, 2),
(13, 90.0, 2),
(14, 92.5, 2),
(15, 88.5, 2),
(16, 91.5, 2),
(17, 93.0, 3),
(18, 96.0, 3),
(19, 89.5, 3),
(20, 94.5, 3),
(21, 92.0, 3),
(22, 97.0, 3),
(23, 90.5, 3),
(24, 95.0, 3),
(25, 91.0, 4),
(26, 98.0, 4),
(27, 93.5, 4),
(28, 99.0, 4),
(29, 94.0, 4),
(30, 97.5, 4),
(31, 92.5, 4),
(32, 98.5, 4);