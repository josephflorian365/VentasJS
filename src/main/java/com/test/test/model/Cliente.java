package com.test.test.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Data
@Table(name = "cliente")
public class Cliente{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDCLI")
    private Long id;
    @Column(name = "NOMCLI")
    private String nombre;
    @Column(name = "APECLI")
    private String apellido;
    @Column(name = "ESTCLI")
    private String estado;
    @Column(name = "FECREGCLI")
    private LocalDate fechaRegistro;
    @Column(name = "FECHMODCLI")
    private LocalDateTime fechaModificacion;
}
