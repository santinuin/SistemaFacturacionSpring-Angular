--Populate table regiones
INSERT INTO regiones (id, nombre) VALUES (1, 'Sudamérica');
INSERT INTO regiones (id, nombre) VALUES (2, 'Centroamérica');
INSERT INTO regiones (id, nombre) VALUES (3, 'Norteamérica');
INSERT INTO regiones (id, nombre) VALUES (4, 'Europa');
INSERT INTO regiones (id, nombre) VALUES (5, 'Asia');
INSERT INTO regiones (id, nombre) VALUES (6, 'Africa');
INSERT INTO regiones (id, nombre) VALUES (7, 'Oceanía');
INSERT INTO regiones (id, nombre) VALUES (8, 'Antártida');


--Populate tabla clientes
INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES (1, 'Fern', 'Dany', 'fdany0@ihg.com', '2021-10-25');
INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES (2, 'Jolie', 'Rogan', 'jrogan1@fotki.com', '2022-06-27');
INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES (4, 'Aggi', 'Nabbs', 'anabbs2@blog.com', '2022-07-30');
INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES (4, 'Clotilda', 'Hamon', 'chamon3@goodreads.com', '2022-02-28');
INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES (4, 'Griffin', 'Warstall', 'gwarstall4@npr.org', '2021-10-23');
INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES (3, 'Myrtie', 'Dodamead', 'mdodamead5@joomla.org', '2021-12-28');
INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES (3, 'Dominique', 'Jobke', 'djobke6@google.com.br', '2022-07-19');
INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES (3, 'Dicky', 'Van Arsdalen', 'dvanarsdalen7@gmpg.org', '2022-04-06');
INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES (3, 'Lurline', 'Chazette', 'lchazette8@senate.gov', '2022-02-05');
INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES (5, 'Itch', 'Sands-Allan', 'isandsallan9@noaa.gov', '2022-02-26');
INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES (6, 'Koenraad', 'O''Curneen', 'kocurneena@desdev.cn', '2022-10-07');
INSERT INTO clientes (region_id, nombre, apellido, email, create_at) VALUES (7, 'Willetta', 'Carlsen', 'wcarlsenb@istockphoto.com', '2022-06-15');

--Create users with theirs roles
INSERT INTO `usuarios` (username, password, enabled, nombre, apellido, email) VALUES ('santi','$2a$10$0lH4diDk7VSMaiz883jfo.pr9Ylz12wiyKYeFXybCuYCjD1Wg8SbS',1, 'Santiago', 'Núñez', 'santinuin@outlook.com');
INSERT INTO `usuarios` (username, password, enabled, nombre, apellido, email) VALUES ('admin','$2a$10$1E4rxD1YPYH7FrocHBUcwOuHDhC2LOEFglcjn12VQqP35gNffkFWu',1, 'Fern', 'Dany', 'fdany0@ihg.com');

INSERT INTO `roles` (name) VALUES ('ROLE_USER');
INSERT INTO `roles` (name) VALUES ('ROLE_ADMIN');

INSERT INTO `users_authorities` (usuario_id, role_id) VALUES (1, 1);
INSERT INTO `users_authorities` (usuario_id, role_id) VALUES (2, 2);
INSERT INTO `users_authorities` (usuario_id, role_id) VALUES (2, 1);

--Populate tabla productos
INSERT INTO productos (nombre, precio, create_at) VALUES('Panasonic Pantalla LCD', 259990, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Sony Camara digital DSC-W320B', 123490, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Apple iPod shuffle', 1499990, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Sony Notebook Z110', 37990, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Hewlett Packard Multifuncional F2280', 69990, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Bianchi Bicicleta Aro 26', 69990, NOW());
INSERT INTO productos (nombre, precio, create_at) VALUES('Mica Comoda 5 Cajones', 299990, NOW());

--Create some facturas
INSERT INTO facturas (descripcion, observacion, cliente_id, create_at) VALUES('Factura equipos de oficina', null, 1, NOW());

INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(1, 1, 1);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(2, 1, 4);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(1, 1, 5);
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(1, 1, 7);

INSERT INTO facturas (descripcion, observacion, cliente_id, create_at) VALUES('Factura Bicicleta', 'Alguna nota importante!', 1, NOW());
INSERT INTO facturas_items (cantidad, factura_id, producto_id) VALUES(3, 2, 6);