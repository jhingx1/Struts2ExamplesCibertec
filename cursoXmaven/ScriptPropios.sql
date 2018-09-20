select * from profesores;
select * from cursos;

SELECT frases.idfrase,autores.autor,frases.frase
FROM frases
INNER JOIN autores
ON frases.idautor=autores.idautor
ORDER BY autores.autor;

SELECT idautor,autor FROM autores;

######Script para listar cursos.
######Listar los cursos-tabla principal ,p.fechahoraingreso
SELECT c.idcursos,p.nombreprofesores,p.carrera,c.nombrecursos,c.descripcion,c.horaInicio,c.horas,c.fechainicio,c.fechafin
FROM cursos c
INNER JOIN profesores p
ON  c.idprofesores = p.idprofesores
ORDER BY c.nombrecursos;

######Tabla secundaria
SELECT idprofesores,nombreprofesores,carrera,fechahoraingreso,tipocontrato FROM profesores;

##DROP TABLE IF EXISTS cursos;
##DROP TABLE IF EXISTS profesores;

####Para insertar
###INSERT INTO cursos(idautor,frase)VALUES(?,?);

select * from cursos;
select * from profesores;

###inserta para cursos
INSERT INTO cursos(nombrecursos,descripcion,fechainicio,fechafin,horaInicio,tipo,horas,idprofesores)
VALUES('Angular','Fundamentos Angular','2013-02-14','2013-02-14','20:30:15','DAT',80,1);

###inserta para profesores
INSERT INTO profesores(nombreprofesores,carrera,fechahoraingreso,tipocontrato)
VALUES('Janet Castro','Ing. Sistemas','2018-03-10 18:00:00','Tiempo parcial');









