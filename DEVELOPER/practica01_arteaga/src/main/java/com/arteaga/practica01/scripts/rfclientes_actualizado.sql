#Base de datos para la primera practica calificada
drop database `rfclientes`;
commit;

CREATE DATABASE `rfclientes`;
# GO
USE `rfclientes`;
# GO
SET FOREIGN_KEY_CHECKS=0;

# GO
# Dumping Table Structure for clientes

#
CREATE TABLE `clientes` (
  `idcliente` int(11) NOT NULL AUTO_INCREMENT,
  `apellidos` varchar(50) NOT NULL,
  `nombres` varchar(50) NOT NULL,
  `correo` varchar(50) DEFAULT NULL,
  `telefono` varchar(50) DEFAULT NULL,
  PRIMARY KEY (`idcliente`),
  UNIQUE KEY `IDX_clientes_2` (`apellidos`,`nombres`)
) ENGINE=InnoDB AUTO_INCREMENT=14 DEFAULT CHARSET=utf8;
# GO
#

# Dumping Data for clientes
#
BEGIN;
# GO
INSERT INTO `clientes` (idcliente, apellidos, nombres, correo, telefono) VALUES (1, 'Pérez', 'Juan', 'jperez@hotmail.com', '999-678-234');
# GO
INSERT INTO `clientes` (idcliente, apellidos, nombres, correo, telefono) VALUES (8, 'Raymondi', 'Walter', 'wraymondi@gmail.com', '678-5678');
# GO
INSERT INTO `clientes` (idcliente, apellidos, nombres, correo, telefono) VALUES (11, 'Rios', 'Karla', 'karla@yahoo.es', '456-6756');
# GO
INSERT INTO `clientes` (idcliente, apellidos, nombres, correo, telefono) VALUES (12, 'Alcántara', 'Ana', 'aalcantara@yahoo.es', '980-456-554');
# GO
INSERT INTO `clientes` (idcliente, apellidos, nombres, correo, telefono) VALUES (13, 'Raymondi', 'Luciana', 'luciana@yahoo.es', '981-734-237');
# GO
INSERT INTO `clientes` (idcliente, apellidos, nombres, correo, telefono) VALUES (14, 'Rengifo', 'Ana', 'arengifo@yahoo.es', '123-234-234');
# GO
INSERT INTO `clientes` (idcliente, apellidos, nombres, correo, telefono) VALUES (15, 'Palacios', 'Ana', 'anapalacios@yahoo.es', '130-234-123');
# GO
INSERT INTO `clientes` (idcliente, apellidos, nombres, correo, telefono) VALUES (16, 'Raymondi', 'Luis', 'lraymondi@yahoo.es', '843-234-634');
# GO
INSERT INTO `clientes` (idcliente, apellidos, nombres, correo, telefono) VALUES (17, 'Chavez', 'Jose', 'joseChavez@yahoo.es', '982-135-584');
# GO
INSERT INTO `clientes` (idcliente, apellidos, nombres, correo, telefono) VALUES (18, 'Raymondi', 'Rogelio', 'rogelio@gmail.com', '942-163-823');
# GO
COMMIT;
# GO
SET FOREIGN_KEY_CHECKS=1

# GO


