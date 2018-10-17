DROP TABLE IF EXISTS frases;
DROP TABLE IF EXISTS autores;

-- tabla autores
CREATE TABLE autores (
  idautor       int(11) NOT NULL AUTO_INCREMENT,  --Debe de ser autoincremental
  autor         varchar(100) NOT NULL,
  PRIMARY KEY (idautor), ---Establecer la clave primaria
  UNIQUE KEY IDX_autores_1 (autor) ---establecer que sea unico
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

---insertando datos
INSERT INTO autores(autor) VALUES('Albert Einstein');
INSERT INTO autores(autor) VALUES('Jorge Luis Borges');
INSERT INTO autores(autor) VALUES('Miguel de Cervantes Saavedra');


-- tabla frases
CREATE TABLE frases (
  idfrase       int(11) NOT NULL AUTO_INCREMENT,
  idautor       int(11) NOT NULL,   ----- colando el id, de la tabla con que se va a relacionar
  frase         text NOT NULL,
  PRIMARY KEY (idfrase),  --- estableciendo la llave primaria
  KEY FK_frases_1 (idautor), --- estableciendo la llava foranea.
  CONSTRAINT FK_frases_1 FOREIGN KEY (idautor) REFERENCES autores (idautor) ON DELETE CASCADE ON UPDATE CASCADE ----estableciendo un constrain, con la llave foreanea y referenciandola.
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO frases(idautor, frase) VALUES(1, 'Yo no hablo de venganzas ni perdones, el olvido es la �nica venganza y el �nico perd�n.');
INSERT INTO frases(idautor, frase) VALUES(1, 'He cometido el peor pecado que uno puede cometer. No he sido feliz.');
INSERT INTO frases(idautor, frase) VALUES(2, '�Qu� locura o qu� desatino me lleva a contar las ajenas faltas, teniendo tanto que decir de las m�as');
INSERT INTO frases(idautor, frase) VALUES(2, 'No ames lo que eres, sino lo que puedes llegar a ser.');
INSERT INTO frases(idautor, frase) VALUES(3, 'Intenta no volverte un hombre de �xito, sino volverte un hombre de valor.');
INSERT INTO frases(idautor, frase) VALUES(3, 'La memoria es la inteligencia de los tontos.');
INSERT INTO frases(idautor, frase) VALUES(3, 'No entiendes realmente algo a menos que seas capaz de explicarselo a tu abuela.');
