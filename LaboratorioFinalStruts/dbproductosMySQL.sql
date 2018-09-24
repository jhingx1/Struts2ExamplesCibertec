-- En una base de datos de MySQL ejecutar este script:

DROP TABLE IF EXISTS productos;

-- tabla productos
CREATE TABLE productos (
    codigoproducto  int(11) NOT NULL AUTO_INCREMENT,
    nombre      varchar(200) NOT NULL,   
    precio      double(10,2) NOT NULL,
    PRIMARY KEY (codigoproducto),
    UNIQUE KEY IDX_productos_1 (nombre)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- insertando filas de prueba
INSERT INTO productos(nombre, precio) 
VALUES('Consulta Paginada con jQuery',10.0);
INSERT INTO productos(nombre, precio) 
VALUES('Combos Anidados con jQuery',15.0);
INSERT INTO productos(nombre, precio) 
VALUES('Transacciones en MySQL',20.0);
INSERT INTO productos(nombre, precio) 
VALUES('Store Procedure en Oracle',30.0);
INSERT INTO productos(nombre, precio) 
VALUES('PDF con Spring',35.0);
