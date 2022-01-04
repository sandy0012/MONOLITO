package com.sistemas.monolito.dominio;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Entity
@Data
public class Tarifa {

    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long Id;

    @Column(length = 80)
    @NotBlank(message="Debe ingresar una descripción")
    private String descripcion;

    @Min(value = 0)
    private Double areaMinima;

    @NotNull
    @Min(value = 0)
    private Double precio;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "tarifa")
    private List<Orden> ordenes;
}
