package com.sistemas.monolito.dominio;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;

import lombok.Data;

@Entity
@Data
public class Fase {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(length = 30)
    @NotBlank(message="EL nombre no debe estar en blanco")
    private String nombre;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "fase")
    private List<Asignacion> asignaciones; 
}
