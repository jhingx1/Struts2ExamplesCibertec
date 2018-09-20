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

DROP TABLE IF EXISTS cursos;
DROP TABLE IF EXISTS profesores;
