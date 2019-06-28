
CREATE TABLE articulos (
  ida INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  descripcion VARCHAR(30),
  modelo VARCHAR(30),
  precio DECIMAL,
  existencia INT
)

CREATE TABLE cliente (
  idc INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  nombre VARCHAR(30),
  appaterno VARCHAR(30),
  apmaterno VARCHAR(30),
  rfc VARCHAR(30)
)

CREATE TABLE venta (
  FolioVenta INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  ClaveCliente INT,
  Nombre VARCHAR(30),
  Total INT,
  Fecha DATE
);

