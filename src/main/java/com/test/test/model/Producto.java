package com.test.test.model;

import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Data
@Table(name = "producto")
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDPRO")
    private Long id;
    @Column(name = "NOMPRO")
    private String nombre;
    @Column(name = "PREPRO")
    private BigDecimal precio;
    @Column(name = "FECPRO")
    private LocalDateTime fecha;
    @ManyToOne
    @JoinColumn(name = "IDCAT", referencedColumnName = "IDCAT")
    private Categoria categoria;
    @Column(name = "ESTPRO")
    private String estado;
}
