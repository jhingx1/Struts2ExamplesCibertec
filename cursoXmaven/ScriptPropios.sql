select * from profesor;
select * from curso;

SELECT frases.idfrase,autores.autor,frases.frase
FROM frases
INNER JOIN autores
ON frases.idautor=autores.idautor
ORDER BY autores.autor;

SELECT idautor,autor FROM autores;

######Script para listar curso.
######Listar los cursos-tabla principal
SELECT c.idcurso,p.nombreprofesor,p.fechahoraingreso,p.carrera,c.nombrecurso,c.descripcion,c.horas
FROM curso c
INNER JOIN profesor p
ON  c.idcurso = p.idprofesor
ORDER BY c.nombrecurso

######Tabla secundaria
