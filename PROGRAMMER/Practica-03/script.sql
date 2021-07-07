#Creacion de la base de datos
CREATE DATABASE `rfclientes`;

#Creacion de tabla clientes
CREATE TABLE rfclientes.clientes (
  `codigo` varchar(4) primary key,
  `nombre` varchar(50) NOT NULL,
  `apellido` varchar(50) NOT NULL,
  `correo` varchar(50) DEFAULT NULL,
  `telefono` varchar(50) DEFAULT NULL
);

#Creacion de clientes
INSERT INTO rfclientes.clientes (codigo, nombre,apellido, correo, telefono) VALUES ('C001', 'Jose', 'Perez', 'jperez@hotmail.com', '999-678-234');
INSERT INTO rfclientes.clientes (codigo, nombre,apellido, correo, telefono) VALUES ('C002', 'Ricardo', 'Raymondi', 'rraymondi@gmail.com', '934-624-426');
INSERT INTO rfclientes.clientes (codigo, nombre,apellido, correo, telefono) VALUES ('C003', 'Roxana', 'Villegas', 'roxana123@yahoo.es', '934-134-246');
INSERT INTO rfclientes.clientes (codigo, nombre,apellido, correo, telefono) VALUES ('C004', 'Rosa', 'Santos', 'rsantos@yahoo.es', '980-456-554');
INSERT INTO rfclientes.clientes (codigo, nombre,apellido, correo, telefono) VALUES ('C005', 'Lucia', 'Santos', 'lsantos@yahoo.es', '952-234-156');

#STORE PROCEDURE PARA LISTAR CLIENTES
create procedure rfclientes.sp_lista_cliente()
select * from rfclientes.clientes;

#LISTAR TODOS LOS CLIENTES
call rfclientes.sp_lista_cliente();

#STORE PROCEDURE PARA GRABAR CLIENTES
create procedure rfclientes.sp_graba_cliente(
in codigo varchar(4)
,in nombre varchar(50)
,in apellido varchar(50)
,in correo varchar(50)
,in telefono varchar(50)
)
insert into rfclientes.clientes values(codigo,nombre,apellido,correo,telefono);
#INGRESANDO CLIENTE NUEVO
call rfclientes.sp_graba_cliente('C006','Alisson','Arteaga','arteaga10alisson@gmail.com','934-613-745');

/*STORE PROCEDURE PARA ACTUALIZAR CLIENTES*/
create procedure rfclientes.sp_modifica_cliente(
in xcodigo varchar(4)
,in xnombre varchar(50)
,in xapellido varchar(50)
,in xcorreo varchar(50)
,in xtelefono varchar(50)
)
update rfclientes.clientes set nombre = xnombre, apellido = xapellido, correo = xcorreo, telefono = xtelefono 
where codigo = xcodigo;

#ACTUALIZANDO UN CLIENTE
call rfclientes.sp_modifica_cliente('C001','Jaime','Perez', 'jperez@hotmail.com', '999-678-234');

#STORE PROCEDURE PARA BUSCAR CLIENTE*/
create procedure rfclientes.sp_busca_cliente(
in xcodigo varchar(4)
)
select * from rfclientes.clientes where codigo=xcodigo;

#Consultando cliente por codigo
call rfclientes.sp_busca_cliente('C001');

#STORE PROCEDURE PARA ELIMINAR CLIENTES POR CODIGO
create procedure rfclientes.sp_elimina_cliente(
in xcodigo varchar(4)
)
DELETE FROM rfclientes.clientes where codigo=xcodigo;




