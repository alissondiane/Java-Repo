/* Populate tables */
INSERT INTO clientes (nombre, apellido, email, telefono, foto) VALUES('Edwin', 'Maravi', 'emaravi@cjavaperu.com', '634542346', '');
INSERT INTO clientes (nombre, apellido, email, telefono, foto) VALUES('Katherine', 'Sulbaran', 'ksulbaran@cjavaperu.com', '987654322', '');
INSERT INTO clientes (nombre, apellido, email, telefono, foto) VALUES('Linus', 'Torvalds', 'linus.torvalds@gmail.com', '987654322', '');
INSERT INTO clientes (nombre, apellido, email, telefono, foto) VALUES('Jane', 'Doe', 'jane.doe@gmail.com', '987654322', '');
INSERT INTO clientes (nombre, apellido, email, telefono, foto) VALUES('Rasmus', 'Lerdorf', 'rasmus.lerdorf@gmail.com', '342362474', '');
INSERT INTO clientes (nombre, apellido, email, telefono, foto) VALUES('Erich', 'Gamma', 'erich.gamma@gmail.com', '234973450', '');
INSERT INTO clientes (nombre, apellido, email, telefono, foto) VALUES('Richard', 'Helm', 'richard.helm@gmail.com', '124567023', '');
INSERT INTO clientes (nombre, apellido, email, telefono, foto) VALUES('Ralph', 'Johnson', 'ralph.johnson@gmail.com', '983564239', '');
INSERT INTO clientes (nombre, apellido, email, telefono, foto) VALUES('John', 'Vlissides', 'john.vlissides@gmail.com', '653425698', '');
INSERT INTO clientes (nombre, apellido, email, telefono, foto) VALUES('James', 'Gosling', 'james.gosling@gmail.com', '237680450', '');
INSERT INTO clientes (nombre, apellido, email, telefono, foto) VALUES('Bruce', 'Lee', 'bruce.lee@gmail.com', '134587430', '');
INSERT INTO clientes (nombre, apellido, email, telefono, foto) VALUES('Johnny', 'Doe', 'johnny.doe@gmail.com', '657803461', '');
INSERT INTO clientes (nombre, apellido, email, telefono, foto) VALUES('John', 'Roe', 'john.roe@gmail.com', '873467091', '');


/* Creamos algunos usuarios con sus roles */
INSERT INTO `users` (username, password, enabled) VALUES ('emaravi','$2a$10$O9wxmH/AeyZZzIS09Wp8YOEMvFnbRVJ8B4dmAMVSGloR62lj.yqXG',1);
INSERT INTO `users` (username, password, enabled) VALUES ('admin','$2a$10$DOMDxjYyfZ/e7RcBfUpzqeaCs8pLgcizuiQWXPkU35nOhZlFcE9MS',1);

INSERT INTO `authorities` (user_id, authority) VALUES (1,'ROLE_USER');
INSERT INTO `authorities` (user_id, authority) VALUES (2,'ROLE_ADMIN');
INSERT INTO `authorities` (user_id, authority) VALUES (2,'ROLE_USER');