package com.test.test.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "producto")
public class Producto{
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
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    @JoinColumn(name = "IDCAT", referencedColumnName = "IDCAT")
    private Categoria categoria;
    @Column(name = "ESTPRO")
    private String estado;
}
