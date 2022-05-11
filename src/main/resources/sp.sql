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

DELIMITER @@

CREATE DEFINER=`root`@`localhost` PROCEDURE `paginado`(
IN p_table_name VARCHAR (1024),
 IN p_fields VARCHAR (1024),
 IN p_page_size INT,
 IN p_page_now INT,
 IN p_order_string VARCHAR (128),
 IN p_where_string VARCHAR (1024),
 OUT p_out_rows INT
)

BEGIN

DECLARE m_begin_row INT DEFAULT 0;
DECLARE m_limit_string CHAR(64);


SET m_begin_row = (p_page_now - 1) * p_page_size;
SET m_limit_string = CONCAT(' LIMIT ', m_begin_row, ', ', p_page_size);

SET @COUNT_STRING = CONCAT('SELECT COUNT(*) INTO @ROWS_TOTAL FROM ', p_table_name, ' ', p_where_string);
SET @MAIN_STRING = CONCAT('SELECT ', p_fields, ' FROM ', p_table_name, ' ', p_where_string, ' ', p_order_string, m_limit_string);

PREPARE count_stmt FROM @COUNT_STRING;
EXECUTE count_stmt;
DEALLOCATE PREPARE count_stmt;
SET p_out_rows = @ROWS_TOTAL;

PREPARE main_stmt FROM @MAIN_STRING;
EXECUTE main_stmt;
DEALLOCATE PREPARE main_stmt;
END @@
DELIMITER ;