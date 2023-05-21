DROP DATABASE IF EXISTS empleado;
CREATE DATABASE empleado;
\c empleado -- Postgres
-- USE empleado; -- MySQL

CREATE TABLE oficina(
    oficina SERIAL PRIMARY KEY,
    ciudad VARCHAR(50) NOT NULL,
    superficie INTEGER NOT NULL,
    ventas INTEGER NOT NULL
);

CREATE TABLE empleado(
    numemp SERIAL PRIMARY KEY,
    nombre VARCHAR(50) NOT NULL,
    edad INTEGER NOT NULL,
    oficina INTEGER NOT NULL,
    puesto VARCHAR(50) NOT NULL,
    contrato DATE NOT NULL,
    FOREIGN KEY (oficina) REFERENCES oficina(oficina)
);

INSERT INTO oficina(ciudad, superficie, ventas) VALUES
('Madrid', 100, 1000),
('Barcelona', 200, 2000),
('Valencia', 300, 3000),
('Sevilla', 400, 4000),
('Bilbao', 500, 5000);

INSERT INTO empleado(nombre, edad, oficina, puesto, contrato) VALUES
('Juan', 30, 1, 'Director', '2010-01-01'),
('Pedro', 25, 1, 'Programador', '2010-01-01'),
('Luis', 20, 1, 'Programador', '2010-01-01'),
('Ana', 30, 2, 'Director', '2010-01-01'),
('Maria', 25, 2, 'Programador', '2010-01-01'),
('Luisa', 20, 2, 'Programador', '2010-01-01'),
('Antonio', 30, 3, 'Director', '2010-01-01'),
('Manuel', 25, 3, 'Programador', '2010-01-01'),
('Luis', 20, 3, 'Programador', '2010-01-01'),
('Jose', 30, 4, 'Director', '2010-01-01'),
('Ramon', 25, 4, 'Programador', '2010-01-01'),
('Luis', 20, 4, 'Programador', '2010-01-01'),
('Javier', 30, 5, 'Director', '2010-01-01'),
('Raul', 25, 5, 'Programador', '2010-01-01'),
('Luis', 20, 5, 'Programador', '2010-01-01');