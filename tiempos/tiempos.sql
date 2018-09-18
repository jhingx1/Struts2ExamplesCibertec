-- En una base de datos de MySQL ejecutar este script:

DROP TABLE IF EXISTS tiempos;

-- tabla tiempos
CREATE TABLE tiempos (
    idtiempo int(11) NOT NULL AUTO_INCREMENT,
    fecha date NOT NULL,
    hora time NOT NULL,
    fechahora datetime NOT NULL,
    PRIMARY KEY (idtiempo)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;


-- insertando filas de prueba
INSERT INTO tiempos(fecha, hora, fechahora) 
VALUES('2013-02-14', '20:30:15', '2013-02-15 13:27:48');
INSERT INTO tiempos(fecha, hora, fechahora) 
VALUES('2013-02-24', '13:29:17', '2013-02-24 13:29:21');
INSERT INTO tiempos(fecha, hora, fechahora) 
VALUES('2013-12-25', '23:59:59', '2013-12-25 23:59:59');
INSERT INTO tiempos(fecha, hora, fechahora) 
VALUES('2013-09-16', '12:30:15', '2013-09-24 13:30:12');

