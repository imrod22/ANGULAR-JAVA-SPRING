USE veterinaria;
 
SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";
 
INSERT INTO especie (id, descripcion) VALUES(1, 'Perro');
INSERT INTO especie (id, descripcion) VALUES (2, 'Gato');
INSERT INTO especie (id, descripcion) VALUES (3, 'Ave');
 
INSERT INTO hibernate_sequence(next_val) VALUES(25);
INSERT INTO hibernate_sequence(next_val) VALUES(25);
INSERT INTO hibernate_sequence(next_val) VALUES(25);
INSERT INTO hibernate_sequence(next_val) VALUES(25);
INSERT INTO hibernate_sequence(next_val) VALUES(25);
INSERT INTO hibernate_sequence(next_val) VALUES(25);
INSERT INTO hibernate_sequence(next_val) VALUES(25);
INSERT INTO hibernate_sequence(next_val) VALUES(25);
INSERT INTO hibernate_sequence(next_val) VALUES(25);
INSERT INTO hibernate_sequence(next_val) VALUES(25);
INSERT INTO hibernate_sequence(next_val) VALUES(25); 
 
INSERT INTO nombrecampo(id, nombre) VALUES(18, 'Nombre');
INSERT INTO nombrecampo(id, nombre) VALUES(19, 'FechaNacimiento');
INSERT INTO nombrecampo(id, nombre) VALUES(20, 'Sexo');
INSERT INTO nombrecampo(id, nombre) VALUES(21, 'Color');
INSERT INTO nombrecampo(id, nombre) VALUES(22, 'SenasParticulares');
INSERT INTO nombrecampo(id, nombre) VALUES(23, 'Veterinario');
 
INSERT INTO raza(id, descripcion, especie_id) VALUES(4, 'Labrador', 1);
INSERT INTO raza(id, descripcion, especie_id) VALUES(5, 'Chihuahua', 1);
INSERT INTO raza(id, descripcion, especie_id) VALUES(6, 'Dogo', 1);
INSERT INTO raza(id, descripcion, especie_id) VALUES(7, 'Pitbull', 1);
INSERT INTO raza(id, descripcion, especie_id) VALUES(8, 'Mestizo', 1);
INSERT INTO raza(id, descripcion, especie_id) VALUES(9, 'Siames', 2);
INSERT INTO raza(id, descripcion, especie_id) VALUES(10, 'Persa', 2);
INSERT INTO raza(id, descripcion, especie_id) VALUES(11, 'Bengala', 2);
INSERT INTO raza(id, descripcion, especie_id) VALUES(12, 'Loro', 3);
INSERT INTO raza(id, descripcion, especie_id) VALUES(13, 'Papagayo', 3);
INSERT INTO raza(id, descripcion, especie_id) VALUES(14, 'Canario', 3); 
 
INSERT INTO tipousuario(id, descripcion) VALUES (15, 'Administrador');
INSERT INTO tipousuario(id, descripcion) VALUES (16, 'Veterinario');
INSERT INTO tipousuario(id, descripcion) VALUES (17, 'Dueno');
 
INSERT INTO informacionveterinaria(id, domicilioclinica, nombreclinica) VALUES(1, '59 numero 4115', 'Patan');
 
INSERT INTO usuario(id, apellido, contrasena, email, nombre, nombreUsuario, telefono, TIPO_ID, veterinaria_id) VALUES(24, 'Rodriguez', '1234', 'imrod22@gmail.com', 'Imanol', 'imrod', '221532355', 17, NULL);
INSERT INTO usuario(id, apellido, contrasena, email, nombre, nombreUsuario, telefono, TIPO_ID, veterinaria_id) VALUES(25, 'Pontiroli', '12345', 'gasparpontiroli@gmail.com', 'Gaspar', 'gaspar', '221456789', 16, 1);
INSERT INTO usuario(id, apellido, contrasena, email, nombre, nombreUsuario, telefono, TIPO_ID, veterinaria_id) VALUES(26, 'Pagano', 'lucho123', 'lucho@gmail.com', 'Luciano', 'lucho', '221567333', 15, NULL);

INSERT INTO mascota(id, qr, duenio_id, raza_id, veterinario_id) VALUES(1, '123', 24, 6, 25);
INSERT INTO mascota(id, qr, duenio_id, raza_id, veterinario_id) VALUES(2, '456', 24, 8, 25);

INSERT INTO campoficha(id, valor, visibilidad, CAMPO_ID, MascotaId) VALUES(1, 'Firulais', 1,  18, 1);
INSERT INTO campoficha(id, valor, visibilidad, CAMPO_ID, MascotaId) VALUES(2, '12-11-2010', 1, 19, 1);
INSERT INTO campoficha(id, valor, visibilidad, CAMPO_ID, MascotaId) VALUES(3, 'M', 0, 20, 1);
INSERT INTO campoficha(id, valor, visibilidad, CAMPO_ID, MascotaId) VALUES(4, 'Negro', 1, 21, 1);
INSERT INTO campoficha(id, valor, visibilidad, CAMPO_ID, MascotaId) VALUES(5, 'Cola cortada', 1, 22, 1);

INSERT INTO campoficha(id, valor, visibilidad, CAMPO_ID, MascotaId) VALUES(6, 'Mocha', 1,  18, 2);
INSERT INTO campoficha(id, valor, visibilidad, CAMPO_ID, MascotaId) VALUES(7, '01-03-2017', 1, 19, 2);
INSERT INTO campoficha(id, valor, visibilidad, CAMPO_ID, MascotaId) VALUES(8, 'F', 0, 20, 2);
INSERT INTO campoficha(id, valor, visibilidad, CAMPO_ID, MascotaId) VALUES(9, 'Blanca', 1, 21, 2);
INSERT INTO campoficha(id, valor, visibilidad, CAMPO_ID, MascotaId) VALUES(10, 'N/A', 0, 22, 2);

COMMIT;