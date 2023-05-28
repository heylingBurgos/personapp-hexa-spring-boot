INSERT INTO 
	`persona_db`.`persona`(`cc`,`nombre`,`apellido`,`genero`,`edad`) 
VALUES
	(123456789,'Pepe','Perez','M',30),
	(987654321,'Pepito','Perez','M',null),
	(321654987,'Pepa','Juarez','F',30),
	(147258369,'Pepita','Juarez','F',10),
	(963852741,'Fede','Perez','M',18);

INSERT INTO
    `persona_db`.`profesion`(`id`,`nom`,`des`)
VALUES
    (1,'Ingeniería de sistemas','Profesion para personas que les gusta programar.'),
    (2,'Doctor','Personas que les gusta las ciencias y salvar vidas.'),
    (3,'Arquitecto','Les gusta diseñar casas hermosas.'),
    (4,'Microbiología','Les gusta las ciencias de lo más interno'),
    (5,'Abogado','Les gusta defender la ley');

INSERT INTO
    `persona_db`.`telefono`(`num`,`oper`,`duenio`)
VALUES
    (3333333,'Claro',123456789),
    (4444444,'Tigo',987654321),
    (5555555,'Movistar',321654987),
    (6666666,'Wom',147258369),
    (7777777,'Avantel',123456789),
    (8888888,'Claro',963852741);

INSERT INTO
    `persona_db`.`estudios`(`id_prof`, `cc_per`, `fecha`, `univer`)
   VALUES
       (1,123456789,'2000-03-24','Pontificia Universidad Javeriana'),
       (2,987654321,'2012-06-24','Universidad de los Andes'),
       (3,321654987,'2020-11,18','Sergio Arboleda'),
       (4,147258369,'2022-10-01','Universidad Nacional'),
       (5,123456789,'2023-02-13','Universidad del Rosario');