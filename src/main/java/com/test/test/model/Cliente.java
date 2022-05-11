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

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cliente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IDCLI")
    private Long id;
    @Column(name = "NOMCLI")
    private String nombre;
    @Column(name = "APECLI")
    private String apellido;
    @Column(name = "ESTCLI")
    private Estado estado;

    @CreationTimestamp
    @Column(name = "FECREGCLI",updatable = false)
    private Timestamp fechaRegistro;
    @UpdateTimestamp
    @Column(name = "FECHMODCLI")
    private Timestamp fechaModificacion;
}
