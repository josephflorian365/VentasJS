package com.test.test.model;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "categoria")
public class Categoria {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "IDCAT")
    private Long id;
    @Column(name = "NOMCAT")
    private String nombre;
    @Column(name = "ESTCAT")
    private String estado;

}
