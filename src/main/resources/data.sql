INSERT INTO rol (id_rol, nombre, estado)
VALUES ('ADMIN', 'Administrador', true),
       ('USU', 'Usuario', true)
ON CONFLICT (id_rol) DO NOTHING;

INSERT INTO persona (apellido, celular, correo, dni, nombre)
VALUES ('Gomez', '123456789', 'gomez@example.com', '12345678', 'Juan'),
       ('Martinez', '234567890', 'martinez@example.com', '23456789', 'Ana'),
       ('Lopez', '345678901', 'lopez@example.com', '34567890', 'Carlos'),
       ('Perez', '456789012', 'perez@example.com', '45678901', 'Maria'),
       ('Rodriguez', '567890123', 'rodriguez@example.com', '56789012', 'Jose'),
       ('Hernandez', '678901234', 'hernandez@example.com', '67890123', 'Laura'),
       ('Diaz', '789012345', 'diaz@example.com', '78901234', 'Pedro'),
       ('Gonzalez', '890123456', 'gonzalez@example.com', '89012345', 'Luis'),
       ('Sanchez', '901234567', 'sanchez@example.com', '90123456', 'Ana'),
       ('Ramirez', '012345678', 'ramirez@example.com', '01234567', 'Roberto'),
       ('Torres', '112233445', 'torres@example.com', '11223344', 'Elena'),
       ('Martinez', '223344556', 'martinez2@example.com', '22334455', 'Felipe'),
       ('Ruiz', '334455667', 'ruiz@example.com', '33445566', 'Pedro'),
       ('Alvarez', '445566778', 'alvarez@example.com', '44556677', 'Mariana'),
       ('Jimenez', '556677889', 'jimenez@example.com', '55667788', 'Fernando'),
       ('Fernandez', '667788990', 'fernandez@example.com', '66778899', 'Sofia'),
       ('Castro', '778899001', 'castro@example.com', '77889900', 'Manuel'),
       ('Mendez', '889900112', 'mendez@example.com', '88990011', 'Paola'),
       ('Vega', '990011223', 'vega@example.com', '99001122', 'Andrea'),
       ('Soto', '101112233', 'soto@example.com', '10111223', 'David'),
       ('Curillo', '0981101464', 'bryancurillo@gmail.com', '0106046709', 'Bryan')
ON CONFLICT (dni) DO NOTHING;

INSERT INTO usuario(password, username, id_persona, id_rol)
values ('$2a$10$EgigjHpqZChvw2cVdNVlf.0ZReo.1oqQrJqviQHNcrXeY7hVK2PEa', 'admin', 21, 'ADMIN')
ON CONFLICT (username) DO NOTHING;


INSERT INTO tipo_pago(id_tipo_pago, descripcion, tipo)
VALUES (1, 'Tarjeta de Crédito', 'Tarjeta'),
       (2, 'Transferencia Bancaria', 'Transferencia'),
       (3, 'Efectivo', 'Pago Directo'),
       (4, 'PayPal', 'Plataforma Digital'),
       (5, 'Cheque', 'Documento')
ON CONFLICT (id_tipo_pago) DO NOTHING;;

