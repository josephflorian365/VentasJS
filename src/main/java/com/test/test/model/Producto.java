package com.test.test.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
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
    @NotBlank(message = "El nombre es obligatorio.")
    @Column(name = "NOMPRO")
    private String nombre;
    @NotNull(message = "El precio es obligatorio.")
    @DecimalMin(value = "1", message = "El precio debe ser 1 como mínimo.")
    @DecimalMax(value = "1000", message = "El precio debe ser 1,000 como máximo.")
    @Column(name = "PREPRO")
    private BigDecimal precio;
    @Column(name = "FECPRO")
    private LocalDateTime fecha;
    @NotNull(message = "La categoria es obligatorio.")
    @ManyToOne(fetch = FetchType.LAZY)
    @JsonIgnoreProperties({"hibernateLazyInitializer","handler"})
    @JoinColumn(name = "IDCAT", referencedColumnName = "IDCAT")
    private Categoria categoria;
    @Column(name = "ESTPRO")
    private String estado;
}
