-- Eliminar la base si ya existe para dejar un estado limpio.
DROP DATABASE IF EXISTS escuela; -- Borra la base de datos 'escuela' si existe.

-- Crear base de datos nueva.
CREATE DATABASE escuela; -- Crea la base de datos 'escuela'.

-- Seleccionar la base de datos para ejecutar las siguientes sentencias.
USE escuela; -- Usar la base de datos 'escuela'.


-- 2. Crear el usuario (si ya existe, esto fallará, puedes usar DROP USER primero si es necesario)
CREATE USER IF NOT EXISTS 'josolmedo'@'localhost' IDENTIFIED BY 'Angel.2020';

-- 3. Darle todos los permisos sobre la base de datos escuela
GRANT ALL PRIVILEGES ON springweb.* TO 'josolmedo'@'localhost';

-- 4. Aplicar los cambios
FLUSH PRIVILEGES;