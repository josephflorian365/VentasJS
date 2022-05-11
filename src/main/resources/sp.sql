DELIMITER
@@
CREATE PROCEDURE ProcedimientoInsertar
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
