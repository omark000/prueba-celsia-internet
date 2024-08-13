CREATE TABLE clientes (
  id BigInt NOT NULL PRIMARY KEY,
  identificacion VARCHAR(20) NOT NULL PRIMARY KEY,
  nombres VARCHAR(80) NOT NULL,
  apellidos VARCHAR(80) NOT NULL,
  tipoIdentificacion VARCHAR(2) NOT NULL,
  fechaNacimiento DATE NOT NULL,
  numeroCelular VARCHAR(20) NOT NULL,
  correoElectronico VARCHAR(80) NOT NULL
);

CREATE SEQUENCE sqclientes START WITH 1 INCREMENT BY 1;

CREATE TABLE servicios (
  id BigInt NOT NULL PRIMARY KEY,
  identificacion VARCHAR(20) NOT NULl,
  servicio VARCHAR(80) NOT NULl,
  fechaInicio DATE NOT NULL,
  ultimaFacturacion DATE NOT NULL,
  ultimoPago INTEGER NOT NULl DEFAULT 0,
  PRIMARY KEY (identificacion, servicio),
  CONSTRAINT servicios_FK1 FOREIGN KEY (identificacion) REFERENCES clientes(identificacion) ON UPDATE CASCADE ON DELETE NO ACTION
)

CREATE SEQUENCE sqServicios START WITH 1 INCREMENT BY 1;