DELIMITER
@@
CREATE PROCEDURE ProcedimientoInsertarCategoria
(
nombre varchar (50),
estado varchar(10)
)
BEGIN
INSERT INTO categoria(NOMCAT,
                      ESTCAT)
VALUES (nombre, estado);
END @
@
DELIMITER ;

DELIMITER @@
CREATE PROCEDURE ProcedimientoActualizarCategoria
(
id int,
nombre varchar (30),
estado varchar(30)
)
BEGIN
UPDATE categoria SET
                     IDCAT=id,
                     NOMCAT=nombre,
                     ESTCAT=estado
WHERE IDCAT=id;
END @@
DELIMITER ;

DELIMITER @@
CREATE PROCEDURE deleteCategoria
(
  id int
)
BEGIN
delete from categoria where IDCAT=id;
END @@
DELIMITER ;

DELIMITER @@
DROP PROCEDURE getMostrarUsuario @@
CREATE PROCEDURE curso.getMostrarUsuario
()
BEGIN
SELECT *FROM Usuarios
END @@
DELIMITER ;
