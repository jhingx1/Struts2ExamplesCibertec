-- MySQL Workbench Forward Engineering

DROP TABLE IF EXISTS profesor;
DROP TABLE IF EXISTS curso;

-- -----------------------------------------------------
-- Schema parainfo
-- -----------------------------------------------------


-- -----------------------------------------------------
-- Table `parainfo`.`profesor`
-- -----------------------------------------------------
CREATE TABLE profesor(
  idprofesor INT NOT NULL AUTO_INCREMENT,
  nombreprofesor VARCHAR(100) NOT NULL,
  carrera VARCHAR(50) NOT NULL,
  fechahoraingreso DATETIME NOT NULL,
  tipocontrato VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idprofesor`)
)ENGINE = InnoDB DEFAULT CHARSET=utf8;

INSERT INTO profesor(nombreprofesor,carrera,fechahoraingreso,tipocontrato) 
VALUES('Albert Einstein','Lic. Fisica','2018-03-15 15:27:48','Tiempo parcial');
INSERT INTO profesor(nombreprofesor,carrera,fechahoraingreso,tipocontrato) 
VALUES('Juan Lopez','Ing. Sistemas','2018-07-20 13:27:48','Temporal');
INSERT INTO profesor(nombreprofesor,carrera,fechahoraingreso,tipocontrato) 
VALUES('Juan Perez','Ing. Electronica','2018-04-20 21:27:48','Ocacional');


-- -----------------------------------------------------
-- Table `parainfo`.`curso`
-- -----------------------------------------------------
CREATE TABLE curso(
  idcurso INT NOT NULL AUTO_INCREMENT,
  nombrecurso VARCHAR(50) NOT NULL,
  descripcion VARCHAR(50) NOT NULL,
  fechainicio DATE NOT NULL,
  fechafin DATE NOT NULL,
  tipo VARCHAR(50) NOT NULL,
  horas INT NOT NULL,
  idprofesor INT NOT NULL,
  PRIMARY KEY (idcurso),  
  CONSTRAINT fk_curso_profesor
    FOREIGN KEY (idprofesor)
    REFERENCES profesor (idprofesor)
    ON DELETE CASCADE
    ON UPDATE CASCADE
)ENGINE = InnoDB CHARSET=utf8;

INSERT INTO curso(nombrecurso,descripcion,fechainicio,fechafin,tipo,horas,idprofesor) 
VALUES('Java Fundamentos','Conceptos Basicos Java 8','2017-02-21','2018-02-20','DAT',80,1);

INSERT INTO curso(nombrecurso,descripcion,fechainicio,fechafin,tipo,horas,idprofesor) 
VALUES('Java WEB','Programacion Web con Java','2018-04-14','2018-06-14','DAT',110,2);

INSERT INTO curso(nombrecurso,descripcion,fechainicio,fechafin,tipo,horas,idprofesor) 
VALUES('Java Avanzado','Uso de Frameworks','2018-02-14','2018-08-14','DAT',140,3);



