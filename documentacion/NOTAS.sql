drop database NotasCastores;
CREATE SCHEMA IF NOT EXISTS `NotasCastores` DEFAULT CHARACTER SET utf8 ;
USE `NotasCastores` ;

DROP TABLE IF EXISTS `NotasCastores`.`personal` ;

CREATE TABLE IF NOT EXISTS `NotasCastores`.`personal` (
  `apePaterno` VARCHAR(45) NOT NULL,
  `idPersonal` INT NOT NULL AUTO_INCREMENT,
  `apeMaterno` VARCHAR(45) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `direccion` VARCHAR(45) NOT NULL,
  `fechadeIngreso` BIGINT DEFAULT 0,
  PRIMARY KEY (`idPersonal`));


DROP TABLE IF EXISTS `NotasCastores`.`usuarios` ;

CREATE TABLE IF NOT EXISTS `NotasCastores`.`usuarios` (
  `idUsuario` INT NOT NULL,
  `userType` INT NOT NULL DEFAULT 0, #0:externo , 1:interno
  `userName` VARCHAR(45) NOT NULL,
  `userPassword` VARCHAR(45) NOT NULL,
  `idPersona` INT NOT NULL,
  PRIMARY KEY (`idUsuario`),
    FOREIGN KEY (`idPersona`)
    REFERENCES `NotasCastores`.`personal` (`idPersonal`));


DROP TABLE IF EXISTS `NotasCastores`.`notas` ;

CREATE TABLE IF NOT EXISTS `NotasCastores`.`notas` (
  `idNota` INT NOT NULL AUTO_INCREMENT,
   `title` VARCHAR(255) NULL,
  `description` VARCHAR(255) NULL,
  `idUsuario` INT NOT NULL,
  `date` TIMESTAMP NOT NULL default now(),
  PRIMARY KEY (`idNota`),
  CONSTRAINT `fk_notas_usuarios`
    FOREIGN KEY (`idUsuario`)
    REFERENCES `NotasCastores`.`usuarios` (`idUsuario`)
    );


DROP TABLE IF EXISTS `NotasCastores`.`comentarios` ;

CREATE TABLE IF NOT EXISTS `NotasCastores`.`comentarios` (
  `idComentario` INT NOT NULL AUTO_INCREMENT,
  `comentario` VARCHAR(255) NULL,
  `idNota` INT NOT NULL,
  `idUsuario` INT NOT NULL,
  `date` TIMESTAMP NOT NULL,
  PRIMARY KEY (`idComentario`),
    FOREIGN KEY (`idNota`)
    REFERENCES `NotasCastores`.`notas` (`idNota`),
    FOREIGN KEY (`idUsuario`)
    REFERENCES `NotasCastores`.`usuarios` (`idUsuario`)
    );


DROP TABLE IF EXISTS `NotasCastores`.`respuestas` ;

CREATE TABLE IF NOT EXISTS `NotasCastores`.`respuestas` (
  `idRespuesta` INT NOT NULL AUTO_INCREMENT,
  `respuesta` VARCHAR(255) NOT NULL,
  `idComentario` INT NOT NULL,
  `idUsuario` INT NOT NULL,
  `date` TIMESTAMP NOT NULL,
  PRIMARY KEY (`idRespuesta`),
    FOREIGN KEY (`idComentario`)
    REFERENCES `NotasCastores`.`comentarios` (`idComentario`),
    FOREIGN KEY (`idUsuario`)
    REFERENCES `NotasCastores`.`usuarios` (`idUsuario`)
   );
   
   
   -- Inserts de prueba para la tabla `personal`
INSERT INTO `NotasCastores`.`personal` (`apePaterno`, `apeMaterno`, `nombre`, `direccion`, `fechadeIngreso`) 
VALUES ('González', 'López', 'Juan', 'Calle Principal 123', NOW());
-- Insertar registros en la tabla personal

INSERT INTO `NotasCastores`.`personal` (`apePaterno`, `apeMaterno`, `nombre`, `direccion`, `fechadeIngreso`) 
VALUES ('López', 'García', 'María', 'Avenida Central 456', NOW());

INSERT INTO `NotasCastores`.`personal` (`apePaterno`, `apeMaterno`, `nombre`, `direccion`, `fechadeIngreso`) 
VALUES ('Martínez', 'Sánchez', 'Pedro', 'Calle Secundaria 789', NOW());

INSERT INTO `NotasCastores`.`personal` (`apePaterno`, `apeMaterno`, `nombre`, `direccion`, `fechadeIngreso`) 
VALUES ('Hernández', 'Gómez', 'Luisa', 'Avenida Norte 1011', NOW());

INSERT INTO `NotasCastores`.`personal` (`apePaterno`, `apeMaterno`, `nombre`, `direccion`, `fechadeIngreso`) 
VALUES ('Rodríguez', 'Pérez', 'Carlos', 'Calle Este 1213', NOW());

INSERT INTO `NotasCastores`.`personal` (`apePaterno`, `apeMaterno`, `nombre`, `direccion`, `fechadeIngreso`) 
VALUES ('Gómez', 'Martínez', 'Ana', 'Avenida Oeste 1415', NOW());

INSERT INTO `NotasCastores`.`personal` (`apePaterno`, `apeMaterno`, `nombre`, `direccion`, `fechadeIngreso`) 
VALUES ('Sánchez', 'Hernández', 'Javier', 'Calle Central 1617', NOW());

INSERT INTO `NotasCastores`.`personal` (`apePaterno`, `apeMaterno`, `nombre`, `direccion`, `fechadeIngreso`) 
VALUES ('Pérez', 'Rodríguez', 'Laura', 'Avenida Sur 1819', NOW());

INSERT INTO `NotasCastores`.`personal` (`apePaterno`, `apeMaterno`, `nombre`, `direccion`, `fechadeIngreso`) 
VALUES ('Martínez', 'González', 'Daniel', 'Calle Norte 2021', NOW());

INSERT INTO `NotasCastores`.`personal` (`apePaterno`, `apeMaterno`, `nombre`, `direccion`, `fechadeIngreso`) 
VALUES ('García', 'López', 'Elena', 'Avenida Este 2223', NOW());

INSERT INTO `NotasCastores`.`personal` (`apePaterno`, `apeMaterno`, `nombre`, `direccion`, `fechadeIngreso`) 
VALUES ('González', 'Martínez', 'Roberto', 'Calle Sur 2425', NOW());

SELECT UNIX_TIMESTAMP(NOW());


-- Inserts de prueba para la tabla `usuarios`
INSERT INTO `NotasCastores`.`usuarios` (`userType`, `userName`, `userPassword`, `idPersona`) 
VALUES (1, 1, 'interno', 'interno', 1);


-- Inserts de prueba para la tabla `notas`
INSERT INTO `NotasCastores`.`notas` (`title`,`description`, `idUsuario`, `date`) 
VALUES ('titulo de prueba','Esta es una nota de prueba', 1, NOW());

-- Inserts de prueba para la tabla `comentarios`
INSERT INTO `NotasCastores`.`comentarios` (`comentario`, `idNota`, `idUsuario`, `date`) 
VALUES ('Este es un comentario de prueba', 1, 1, NOW());

-- Inserts de prueba para la tabla `respuestas`
INSERT INTO `NotasCastores`.`respuestas` (`respuesta`, `idComentario`, `idUsuario`, `date`) 
VALUES ('Esta es una respuesta de prueba', 1, 1, NOW());


SELECT n.idNota, n.title, n.description, n.date AS fecha_nota, u.userName
FROM `NotasCastores`.`notas` AS n
INNER JOIN `NotasCastores`.`usuarios` AS u ON n.idUsuario = u.idUsuario;

select * from notas;
select * from personal;






