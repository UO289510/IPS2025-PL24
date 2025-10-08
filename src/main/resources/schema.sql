--Primero se deben borrar todas las tablas (de detalle a maestro) y lugo anyadirlas (de maestro a detalle)
--(en este caso en cada aplicacion se usa solo una tabla, por lo que no hace falta)

--Para giis.demo.tkrun:

DROP TABLE IF EXISTS Federado;
DROP TABLE IF EXISTS Licencia;
DROP TABLE IF EXISTS Recibo;
DROP TABLE IF EXISTS Finanzas;
DROP TABLE IF EXISTS Incidencias;
DROP TABLE IF EXISTS Logger;
DROP TABLE IF EXISTS Actividad;
DROP TABLE IF EXISTS Asamblea;
DROP TABLE IF EXISTS Instalaciones;
DROP TABLE IF EXISTS Reserva;
DROP TABLE IF EXISTS Usuario;

CREATE TABLE Usuario (
    DNI TEXT PRIMARY KEY,
    Nombre TEXT NOT NULL,
    Apellido TEXT NOT NULL,
    Contrasenia TEXT NOT NULL,
    Fecha_nacimiento DATE NOT NULL,
    Nombre_tutor TEXT,
    Apellido_tutor TEXT,
    DNI_tutor TEXT,
    Telefono_tutor TEXT,
    EsDirectivo BOOLEAN DEFAULT 0,
    IBAN TEXT
);

CREATE TABLE Federado (
    Codigo TEXT PRIMARY KEY,
    DNI TEXT NOT NULL REFERENCES Usuario(DNI) ON DELETE CASCADE,
    Deporte TEXT CHECK(Deporte IN ('Futbol','Baloncesto','Tenis','Padel')) NOT NULL
);

CREATE TABLE Licencia (
    DNI TEXT NOT NULL REFERENCES Usuario(DNI) ON DELETE CASCADE,
    Codigo_federacion TEXT NOT NULL,
    Deporte TEXT CHECK(Deporte IN ('Futbol','Baloncesto','Tenis','Padel')) NOT NULL,
    Estado TEXT CHECK(Estado IN ('Aceptada','En_espera','Rechazada','Caducada')) NOT NULL,
    Fecha_emision DATE NOT NULL,
    Fecha_vencimiento DATE NOT NULL,
    PRIMARY KEY (DNI, Codigo_federacion)
);

CREATE TABLE Recibo (
    Codigo TEXT PRIMARY KEY,
    Importe REAL NOT NULL,
    Nombre TEXT NOT NULL,
    Apellido TEXT NOT NULL,
    Fecha_valor DATE NOT NULL,
    Fecha_emision DATE NOT NULL,
    Concepto TEXT,
    IBAN TEXT,
    Estado TEXT CHECK(Estado IN ('Pagado','Pendiente','Devuelto')) NOT NULL
);

CREATE TABLE Finanzas (
    Id INTEGER PRIMARY KEY AUTOINCREMENT,
    Importe REAL NOT NULL,
    Tipo TEXT CHECK(Tipo IN ('Ingreso','Gasto')) NOT NULL,
    Fecha DATE NOT NULL,
    Concepto TEXT
);

CREATE TABLE Incidencias (
    Id INTEGER PRIMARY KEY AUTOINCREMENT,
    Tipo TEXT CHECK(Tipo IN ('Tipo1','Tipo2','Tipo3')) NOT NULL,
    Localizacion TEXT,
    Descripcion TEXT,
    Fecha_registro DATE NOT NULL,
    Fecha_observacion DATE,
    Usuario_DNI TEXT NOT NULL REFERENCES Usuario(DNI) ON DELETE CASCADE
);

CREATE TABLE Logger (
    Id INTEGER PRIMARY KEY AUTOINCREMENT,
    Id_directivo TEXT REFERENCES Usuario(DNI),
    Id_incidencia INTEGER REFERENCES Incidencias(Id),
    Fecha DATE NOT NULL
);

CREATE TABLE Actividad (
    DNI TEXT REFERENCES Usuario(DNI),
    Fecha DATE NOT NULL,
    PRIMARY KEY (DNI, Fecha)
);

CREATE TABLE Asamblea (
    Id INTEGER PRIMARY KEY AUTOINCREMENT,
    Puntos_fijos TEXT,
    Convocatoria TEXT,
    Observaciones TEXT
);

CREATE TABLE Instalaciones (
    Nombre TEXT PRIMARY KEY,
    Codigo TEXT UNIQUE NOT NULL,
    Deporte TEXT CHECK(Deporte IN ('Futbol','Baloncesto','Tenis','Padel')) NOT NULL
);

CREATE TABLE Reserva (
    Id INTEGER PRIMARY KEY AUTOINCREMENT,
    Instalacion TEXT REFERENCES Instalaciones(Nombre) ON DELETE CASCADE,
    Hora_inicio DATETIME NOT NULL,
    Hora_final DATETIME NOT NULL
);