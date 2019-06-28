
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

CREATE TABLE articulosvendidos (
  idav INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  cantidad INT(6),
  precio INT(6),
  ida INT(6),
  FOREIGN KEY (ida) REFERENCES articulos(ida)
);

CREATE TABLE venta (
  idv INT(6) UNSIGNED AUTO_INCREMENT PRIMARY KEY,
  folio VARCHAR(50),
  idc INT(50),
  idav INT(6),
  idav INT(6),
  fecha VARCHAR(50),
  cantidadID VARCHAR(50),
  FOREIGN KEY (idc) REFERENCES cliente(idc)
  FOREIGN KEY (idav) REFERENCES articulosvendidos(idav)
);

