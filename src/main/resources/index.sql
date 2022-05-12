USE `ventas`;

CREATE INDEX idx_NomCategoria
    ON categoria (NOMCAT);

CREATE INDEX idx_NomCliente
    ON cliente (NOMCLI);

CREATE INDEX idx_FecFacturaCabecera
    ON factura_cabecera (FECFACCAB);

CREATE INDEX idx_CanFacturaDetalle
    ON factura_detalle (CANFACDET);

CREATE INDEX idx_NomProducto
    ON producto (NOMPRO);