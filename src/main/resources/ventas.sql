CREATE SCHEMA `ventas` DEFAULT CHARACTER SET utf8 ;
USE `ventas`;
-- tables
-- Table: CATEGORIA
CREATE TABLE CATEGORIA (
                           IDCAT int NOT NULL COMMENT 'Identificador de categoria',
                           NOMCAT varchar(50) NOT NULL COMMENT 'Nombre de categoria',
                           ESTCAT varchar(10) NOT NULL COMMENT 'Estado de registro',
                           CONSTRAINT CATEGORIA_pk PRIMARY KEY (IDCAT)
);

-- Table: CLIENTE
CREATE TABLE CLIENTE (
                         IDCLI int NOT NULL AUTO_INCREMENT COMMENT 'Identificador de registro de cliente',
                         NOMCLI varchar(50) NOT NULL COMMENT 'Nombre de cliente',
                         APECLI varchar(50) NOT NULL COMMENT 'Apellido de cliente',
                         ESTCLI varchar(10) NOT NULL COMMENT 'Estado de cliente',
                         FECREGCLI datetime NOT NULL COMMENT 'Fecha de registro de cliente',
                         FECHMODCLI datetime NOT NULL COMMENT 'Fecha de modificacion de registro de cliente',
                         CONSTRAINT CLIENTE_pk PRIMARY KEY (IDCLI)
);

-- Table: FACTURA_CABECERA
CREATE TABLE FACTURA_CABECERA (
                                  IDFACCAB int NOT NULL AUTO_INCREMENT COMMENT 'Identificador de registro de factura cabecera',
                                  FECFACCAB datetime NOT NULL COMMENT 'Fecha de registro de factura cabecera',
                                  IDCLI int NOT NULL COMMENT 'Foreign key de cliente',
                                  ESTFACCAB varchar(10) NOT NULL COMMENT 'Estado de registro de factura cabecera',
                                  CONSTRAINT FACTURA_CABECERA_pk PRIMARY KEY (IDFACCAB)
);

-- Table: FACTURA_DETALLE
CREATE TABLE FACTURA_DETALLE (
                                 IDFACDET int NOT NULL AUTO_INCREMENT COMMENT 'Identificador de factura detalle',
                                 IDFACCAB int NOT NULL COMMENT 'Foreign key de factura cabecera',
                                 IDPRO int NOT NULL COMMENT 'Foreign key de factura detalle',
                                 CANFACDET int NOT NULL COMMENT 'Cantidad de productos en factura detalle',
                                 PREFACDET decimal(3,2) NOT NULL COMMENT 'Precio de producto en factura detalle',
                                 ESTFACDET varchar(10) NOT NULL COMMENT 'Estado de registro de factura detalle',
                                 CONSTRAINT FACTURA_DETALLE_pk PRIMARY KEY (IDFACDET)
);

-- Table: PRODUCTO
CREATE TABLE PRODUCTO (
                          IDPRO int NOT NULL AUTO_INCREMENT COMMENT 'Identificador de producto',
                          NOMPRO varchar(50) NOT NULL COMMENT 'Nombre del producto',
                          PREPRO decimal(3,2) NOT NULL COMMENT 'Precio de producto',
                          FECPRO datetime NOT NULL COMMENT 'Fecha de registro del producto',
                          IDCAT int NOT NULL COMMENT 'Foreign key de categoria',
                          ESTPRO varchar(50) NOT NULL COMMENT 'Estado del producto',
                          CONSTRAINT PRODUCTO_pk PRIMARY KEY (IDPRO)
);

-- foreign keys
-- Reference: FACTURA_CABECERA_CLIENTE (table: FACTURA_CABECERA)
ALTER TABLE FACTURA_CABECERA ADD CONSTRAINT FACTURA_CABECERA_CLIENTE FOREIGN KEY FACTURA_CABECERA_CLIENTE (IDCLI)
    REFERENCES CLIENTE (IDCLI);

-- Reference: FACTURA_DETALLE_FACTURA_CABECERA (table: FACTURA_DETALLE)
ALTER TABLE FACTURA_DETALLE ADD CONSTRAINT FACTURA_DETALLE_FACTURA_CABECERA FOREIGN KEY FACTURA_DETALLE_FACTURA_CABECERA (IDFACCAB)
    REFERENCES FACTURA_CABECERA (IDFACCAB);

-- Reference: FACTURA_DETALLE_PRODUCTO (table: FACTURA_DETALLE)
ALTER TABLE FACTURA_DETALLE ADD CONSTRAINT FACTURA_DETALLE_PRODUCTO FOREIGN KEY FACTURA_DETALLE_PRODUCTO (IDPRO)
    REFERENCES PRODUCTO (IDPRO);

-- Reference: PRODUCTO_CATEGORIA (table: PRODUCTO)
ALTER TABLE PRODUCTO ADD CONSTRAINT PRODUCTO_CATEGORIA FOREIGN KEY PRODUCTO_CATEGORIA (IDCAT)
    REFERENCES CATEGORIA (IDCAT);

-- End of file.

