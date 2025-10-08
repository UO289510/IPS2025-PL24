--Primero se deben borrar todas las tablas (de detalle a maestro) y lugo anyadirlas (de maestro a detalle)
--(en este caso en cada aplicacion se usa solo una tabla, por lo que no hace falta)

--Para giis.demo.tkrun:

DROP TABLE IF EXISTS Federado;
DROP TABLE IF EXISTS Licencia;
DROP TABLE IF EXISTS Recibo;
DROP TABLE IF EXISTS Finanzas;
DROP TABLE IF EXISTS Incidencia;
DROP TABLE IF EXISTS Logger;
DROP TABLE IF EXISTS Actividad;
DROP TABLE IF EXISTS Asamblea;
DROP TABLE IF EXISTS Instalacion;
DROP TABLE IF EXISTS Reserva;
DROP TABLE IF EXISTS Usuario;

CREATE TABLE Usuario (
    DNI TEXT PRIMARY KEY,
    nombre TEXT NOT NULL,
    apellido TEXT NOT NULL,
    contrasenia TEXT NOT NULL,
    fecha_nacimiento DATE NOT NULL,
    nombre_tutor TEXT,
    apellido_tutor TEXT,
    DNI_tutor TEXT,
    telefono_tutor TEXT,
    es_directivo BOOLEAN DEFAULT 0,
    IBAN TEXT
);

CREATE TABLE Federado (
    codigo TEXT PRIMARY KEY,
    DNI TEXT NOT NULL REFERENCES Usuario(DNI) ON DELETE CASCADE,
    deporte TEXT CHECK(deporte IN ('Futbol','Baloncesto','Tenis','Padel')) NOT NULL
);

CREATE TABLE Licencia (
    DNI TEXT NOT NULL REFERENCES Usuario(DNI) ON DELETE CASCADE,
    codigo_federacion TEXT NOT NULL,
    deporte TEXT CHECK(deporte IN ('Futbol','Baloncesto','Tenis','Padel')) NOT NULL,
    estado TEXT CHECK(estado IN ('Aceptada','En_espera','Rechazada','Caducada')) NOT NULL,
    fecha_emision DATE NOT NULL,
    fecha_vencimiento DATE NOT NULL,
    PRIMARY KEY (DNI, codigo_federacion)
);

CREATE TABLE Recibo (
    codigo TEXT PRIMARY KEY,
    importe REAL NOT NULL,
    nombre TEXT NOT NULL,
    apellido TEXT NOT NULL,
    fecha_valor DATE NOT NULL,
    fecha_emision DATE NOT NULL,
    concepto TEXT,
    IBAN TEXT,
    estado TEXT CHECK(estado IN ('Pagado','Pendiente','Devuelto')) NOT NULL
);

CREATE TABLE Finanzas (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    importe REAL NOT NULL,
    tipo TEXT CHECK(tipo IN ('Ingreso','Gasto')) NOT NULL,
    fecha DATE NOT NULL,
    concepto TEXT
);

CREATE TABLE Incidencia (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    tipo TEXT CHECK(tipo IN ('Instalaciones','Plataforma','Asuntos economicos','Otros')) NOT NULL,
    localizacion TEXT,
    descripcion TEXT,
    fecha_registro DATE NOT NULL,
    fecha_observacion DATE,
    usuario_DNI TEXT NOT NULL REFERENCES Usuario(DNI) ON DELETE CASCADE
);

CREATE TABLE Logger (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    id_directivo TEXT REFERENCES Usuario(DNI),
    id_incidencia INTEGER REFERENCES Incidencia(id),
    fecha DATE NOT NULL
);

CREATE TABLE Actividad (
    DNI TEXT REFERENCES Usuario(DNI),
    fecha DATE NOT NULL,
    PRIMARY KEY (DNI, fecha)
);

CREATE TABLE Asamblea (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    puntos_fijos TEXT,
    convocatoria TEXT,
    observaciones TEXT
);

CREATE TABLE Instalacion (
    nombre TEXT PRIMARY KEY,
    codigo TEXT UNIQUE NOT NULL,
    deporte TEXT CHECK(deporte IN ('Futbol','Baloncesto','Tenis','Padel')) NOT NULL
);

CREATE TABLE Reserva (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    instalacion TEXT REFERENCES Instalacion(nombre) ON DELETE CASCADE,
    hora_inicio DATETIME NOT NULL,
    hora_final DATETIME NOT NULL
);
