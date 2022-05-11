package com.test.test.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Producto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IDPRO")
    private Long id;
    @Column(name = "NOMPRO")
    private String nombre;
    @Column(name = "PREPRO")
    private String apellido;
    @Column(name = "ESTPRO")
    private String categoria;
    @Column(name = "ESTPRO")
    private Estado estado;

}
