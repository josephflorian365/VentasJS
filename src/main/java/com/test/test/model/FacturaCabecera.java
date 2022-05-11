package com.test.test.model;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;


public class FacturaCabecera implements Serializable {

    private Long id;
    private Timestamp fechaRegistro;
    private Estado estado;
}
