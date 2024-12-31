INSERT INTO rol (id_rol, descripcion, estado, nombre)
VALUES ('ADMIN', 'Rol con acceso completo al sistema', true, 'Administrador'),
       ('USU', 'Rol con acceso limitado a funcionalidades', true, 'Usuario'),
       ('MOD', 'Rol con acceso para moderar contenido', true, 'Moderador'),
       ('VIP', 'Rol con acceso a contenido exclusivo y funciones premium', true, 'Usuario VIP'),
       ('GUEST', 'Rol con acceso limitado solo para visualización', true, 'Visitante')
ON CONFLICT (id_rol) DO NOTHING;

INSERT INTO competencia (id_competencia, descripcion, nombre)
VALUES (1, 'Evaluar la habilidad técnica en programación', 'Programación'),
       (2, 'Evaluar la capacidad de liderazgo de equipos', 'Liderazgo'),
       (3, 'Analizar la toma de decisiones bajo presión', 'Toma de decisiones'),
       (4, 'Evaluar la comunicación interpersonal', 'Comunicación'),
       (5, 'Evaluar el dominio en lenguajes de programación', 'Lenguajes de programación'),
       (6, 'Evaluar la gestión de proyectos', 'Gestión de proyectos'),
       (7, 'Evaluar la innovación y creatividad', 'Innovación'),
       (8, 'Evaluar el trabajo en equipo', 'Trabajo en equipo'),
       (9, 'Evaluar la adaptabilidad a cambios', 'Adaptabilidad'),
       (10, 'Evaluar la resolución de conflictos', 'Resolución de conflictos')
ON CONFLICT (id_competencia) DO NOTHING;

INSERT INTO rol_competencia (id_rol, id_competencia)
VALUES ('ADMIN', 1), -- ADMIN -> Programación
       ('ADMIN', 2), -- ADMIN -> Liderazgo
       ('ADMIN', 3), -- ADMIN -> Toma de decisiones
       ('ADMIN', 4), -- ADMIN -> Comunicación
       ('ADMIN', 5), -- ADMIN -> Lenguajes de programación
       ('USU', 6),   -- USU -> Gestión de proyectos
       ('USU', 7),   -- USU -> Innovación
       ('USU', 8),   -- USU -> Trabajo en equipo
       ('MOD', 9),   -- MOD -> Adaptabilidad
       ('MOD', 10),  -- MOD -> Resolución de conflictos
       ('VIP', 1),   -- VIP -> Programación
       ('VIP', 2),   -- VIP -> Liderazgo
       ('VIP', 6),   -- VIP -> Gestión de proyectos
       ('VIP', 9),   -- VIP -> Adaptabilidad
       ('GUEST', 8)  -- GUEST -> Trabajo en equipo
ON CONFLICT (id_rol, id_competencia) DO NOTHING;



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

-- username: admin
-- pasword: 1234
INSERT INTO usuario(password, username, id_persona, id_rol)
values ('$2a$10$EgigjHpqZChvw2cVdNVlf.0ZReo.1oqQrJqviQHNcrXeY7hVK2PEa', 'admin', 21,
        'ADMIN')
ON CONFLICT (username) DO NOTHING;


INSERT INTO tipo_pago(id_tipo_pago, descripcion, tipo)
VALUES (1, 'Tarjeta de Crédito', 'Tarjeta'),
       (2, 'Transferencia Bancaria', 'Transferencia'),
       (3, 'Efectivo', 'Pago Directo'),
       (4, 'PayPal', 'Plataforma Digital'),
       (5, 'Cheque', 'Documento')
ON CONFLICT (id_tipo_pago) DO NOTHING;

INSERT INTO clasificacion (id_clasificacion, grupo)
VALUES (1, 'Electrónica'),
       (2, 'Hogar'),
       (3, 'Ropa'),
       (4, 'Deportes'),
       (5, 'Alimentos'),
       (6, 'Muebles'),
       (7, 'Juguetes'),
       (8, 'Libros'),
       (9, 'Automotriz'),
       (10, 'Salud')
ON CONFLICT (id_clasificacion) DO NOTHING;

INSERT INTO proveedores (id_Proveedor, correo, moneda, nombre, pais, ruc, telefono)
VALUES (1, 'proveedor1@empresa.com', 'USD', 'Proveedor Uno', 'México', 'RUC123456789', '1234567890'),
       (2, 'proveedor2@empresa.com', 'EUR', 'Proveedor Dos', 'España', 'RUC987654321', '0987654321'),
       (3, 'proveedor3@empresa.com', 'MXN', 'Proveedor Tres', 'México', 'RUC123123123', '2345678901'),
       (4, 'proveedor4@empresa.com', 'USD', 'Proveedor Cuatro', 'EE.UU.', 'RUC456456456', '3456789012'),
       (5, 'proveedor5@empresa.com', 'USD', 'Proveedor Cinco', 'Reino Unido', 'RUC789789789', '4567890123'),
       (6, 'proveedor6@empresa.com', 'USD', 'Proveedor Seis', 'Argentina', 'RUC321321321', '5678901234'),
       (7, 'proveedor7@empresa.com', 'USD', 'Proveedor Siete', 'Brasil', 'RUC654654654', '6789012345'),
       (8, 'proveedor8@empresa.com', 'MXN', 'Proveedor Ocho', 'México', 'RUC987987987', '7890123456'),
       (9, 'proveedor9@empresa.com', 'EUR', 'Proveedor Nueve', 'Francia', 'RUC123456788', '8901234567'),
       (10, 'proveedor10@empresa.com', 'USD', 'Proveedor Diez', 'EE.UU.', 'RUC567567567', '9012345678'),
       (11, 'proveedor11@empresa.com', 'USD', 'Proveedor Once', 'Japón', 'RUC222222222', '0123456789'),
       (12, 'proveedor12@empresa.com', 'MXN', 'Proveedor Doce', 'México', 'RUC333333333', '1234567891'),
       (13, 'proveedor13@empresa.com', 'EUR', 'Proveedor Trece', 'Alemania', 'RUC444444444', '2345678902'),
       (14, 'proveedor14@empresa.com', 'USD', 'Proveedor Catorce', 'Canadá', 'RUC555555555', '3456789013'),
       (15, 'proveedor15@empresa.com', 'BRL', 'Proveedor Quince', 'Brasil', 'RUC666666666',
        '4567890124')
ON CONFLICT (ruc) DO NOTHING;

INSERT INTO producto(idproducto, descripcion, iva, precio_unitario, stock, id_clasificacion, id_proveedor, unidad)
VALUES (1, 'Samsung Galaxy S23', true, 999.99, 200, 1, 1, 'Unidad'),
       (2, 'Microsoft Office 2021', false, 149.99, 150, 2, 2, 'Caja'),
       (3, 'Sony WH-1000XM5', true, 349.99, 300, 3, 3, 'Unidad'),
       (4, 'Lysol Desinfectante', true, 7.99, 50, 1, 4, 'Paquete'),
       (5, 'Kellogg Cornflakes', true, 4.99, 500, 2, 5, 'Unidad'),
       (6, 'Bosch Drill Set', true, 59.99, 100, 4, 6, 'Paquete'),
       (7, 'Nike Air Max 270', true, 130.00, 250, 5, 7, 'Unidad'),
       (8, 'Instant Pot 7-in-1', true, 89.99, 350, 6, 8, 'Caja'),
       (9, 'Fiskars Pruning Shears', false, 20.99, 400, 3, 9, 'Unidad'),
       (10, 'Neutrogena Hydro Boost', true, 12.99, 50, 2, 10, 'Paquete'),
       (11, 'Fitbit Charge 5', true, 179.99, 600, 1, 11, 'Unidad'),
       (12, 'Brother HL-L2350DW Printer', true, 119.99, 150, 4, 12, 'Caja'),
       (13, 'Apple MacBook Air M2', true, 1199.00, 300, 5, 13, 'Unidad'),
       (14, 'Dyson V11 Cordless Vacuum', true, 599.99, 50, 6, 14, 'Paquete'),
       (15, 'Dell UltraSharp Monitor', true, 499.99, 450, 2, 15, 'Unidad'),
       (16, 'Harman Kardon Onyx Studio', true, 249.99, 80, 3, 14, 'Caja'),
       (17, 'Pedigree Dog Food', true, 25.00, 500, 1, 13, 'Unidad'),
       (18, 'DeWalt Cordless Drill', true, 129.99, 120, 4, 11, 'Paquete'),
       (19, 'Sony 55 4K LED TV', true, 899.99, 600, 5, 10, 'Unidad'),
       (20, 'JBL Charge 5 Bluetooth Speaker', true, 179.99, 350, 6, 6, 'Caja')
ON CONFLICT (idproducto) DO NOTHING;

INSERT INTO factura(descuento, total, fecha, id_factura, id_persona, id_tipo_pago, ruc)
VALUES (10.00, 1129.90, '2024-12-30', 1, 1, 1, '1234567890123'),
       (5.00, 759.99, '2024-12-30', 2, 2, 2, '9876543210987'),
       (15.00, 389.97, '2024-12-30', 3, 3, 1, '5555555555555'),
       (20.00, 899.96, '2024-12-30', 4, 4, 2, '6666666666666')
ON CONFLICT (id_factura) DO NOTHING;


INSERT INTO item_factura(cantidad, precio, subtotal, id_factura, id_item_factura, id_producto)
VALUES (2, 499.99, 999.98, 1, 1, 1), -- Producto 1 en factura 1
       (1, 149.99, 149.99, 1, 2, 2), -- Producto 2 en factura 1
       (1, 59.99, 59.99, 1, 3, 3),   -- Producto 3 en factura 1
       (2, 349.99, 699.98, 2, 4, 4), -- Producto 4 en factura 2
       (3, 20.99, 62.97, 2, 5, 5),   -- Producto 5 en factura 2
       (1, 119.99, 119.99, 3, 6, 6), -- Producto 6 en factura 3
       (2, 59.99, 119.98, 3, 7, 1),  -- Producto 1 en factura 3
       (1, 349.99, 349.99, 4, 8, 2), -- Producto 2 en factura 4
       (2, 179.99, 359.98, 4, 9, 3), -- Producto 3 en factura 4
       (1, 99.99, 99.99, 4, 10, 4)
ON CONFLICT (id_item_factura) DO NOTHING; -- Producto 4 en factura 4
