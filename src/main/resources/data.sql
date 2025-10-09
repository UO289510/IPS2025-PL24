--Datos para carga inicial de la base de datos

delete from Usuario;
delete from Federado;
delete from Federado;
delete from Licencia;
delete from Recibo;
delete from Instalacion;
delete from Incidencia;
delete from ConsultaIncidencia;


-- =====================================
-- CARGA INICIAL DE DATOS CLUB ETI
-- =====================================

-- USUARIOS
INSERT INTO Usuario (DNI, nombre, apellido, contrasenia, fecha_nacimiento, nombre_tutor, apellido_tutor, DNI_tutor, telefono_tutor, es_directivo, IBAN)
VALUES
('12345678A', 'Laura', 'Martínez', 'laura123', '2008-04-20', 'Ana', 'Martínez', '11111111B', '600123456', 0, 'ES9820385778983000760236'),
('98765432B', 'Carlos', 'Ruiz', 'carlos123', '1990-02-10', NULL, NULL, NULL, NULL, 0, 'ES7620385778983000760456');

-- FEDERADOS
INSERT INTO Federado (codigo, DNI, deporte)
VALUES
('FED001', '12345678A', 'Tenis'),
('FED002', '98765432B', 'Futbol');

-- LICENCIAS
INSERT INTO Licencia (DNI, codigo_federacion, deporte, estado, fecha_emision, fecha_vencimiento)
VALUES
('12345678A', 'FED001', 'Tenis', 'Aceptada', '2025-01-10', '2025-12-31'),
('98765432B', 'FED002', 'Futbol', 'En_espera', '2025-02-01', '2025-12-31');

-- RECIBOS
INSERT INTO Recibo (codigo, importe, nombre, apellido, fecha_valor, fecha_emision, concepto, IBAN, estado)
VALUES
('REC001', 50.00, 'Laura', 'Martínez', '2025-09-05', '2025-09-01', 'Cuota mensual septiembre', 'ES9820385778983000760236', 'Pagado'),
('REC002', 50.00, 'Laura', 'Martínez', '2025-10-05', '2025-10-01', 'Cuota mensual octubre', 'ES9820385778983000760236', 'Pendiente'),
('REC003', 50.00, 'Carlos', 'Ruiz', '2025-09-05', '2025-09-01', 'Cuota mensual septiembre', 'ES7620385778983000760456', 'Devuelto');

-- INSTALACIONES
INSERT INTO Instalacion (nombre, codigo, deporte)
VALUES
('Campo Futbol 1', 'FUT001', 'Futbol'),
('Pista Tenis 2', 'TEN002', 'Tenis');

-- INCIDENCIAS
INSERT INTO Incidencia(tipo,localizacion,descripcion,fecha_registro,fecha_observacion,usuario_DNI) 
VALUES 
	('Instalaciones','Tenis','asasfafas','2016-10-05','2016-11-03','123'),
	('Instalaciones','Futbol','sfasf','2016-10-15','2016-11-24','1'),
	('Plataforma','Tenis','asasfhdfghhsafas','2016-10-12','2016-11-02','12'),
	('Otros','Tenis','hsdhdff','2016-10-22','2016-11-28','2'),
	('Asuntos economicos','Tenis','retegfdsh','2016-10-22','2016-11-01','3');
	
-- CONSULTAS INCIDENTES
INSERT INTO ConsultaIncidencia(id_incidencia,id_directivo,nombre_directivo,apellido_directivo,fecha_consulta) 
VALUES 
	('1','1','aasfddgdgfas','sdfsdfg','2016-10-05, 10:34'),
	('1','2','sdf','dfsfdsdf','2016-10-15, 21:35'),
	('1','3','sdfsd','fsdsdf','2016-12-12, 10:43'),
	('2','4','df','dfggdfgd','2016-11-24, 16:12'),
	('3','5','fsdfsdfd','jytnh','2016-11-22, 03:54');
