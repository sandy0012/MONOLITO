package com.sistemas.monolito.dominio;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Positive;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Entity
@Data
public class Orden {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "cliente_id",
        referencedColumnName = "id",
        nullable = false,
        foreignKey = @ForeignKey(name="fk_cliente_orden"))
    private Cliente cliente;

    @Column(length = 60)
    @NotBlank(message="Debe ingresar una descripción")
    private String descripcion;

    @Positive
    @Max(value = 50)
    private Double largo;
    
    @Positive
    @Max(value = 20)
    private Double ancho;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "tarifa_id",
        referencedColumnName = "id",
        nullable = false,
        foreignKey = @ForeignKey(name="fk_tarifa_orden"))
    private Tarifa tarifa;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaOrden;
    
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaEntrega;
    
    @Positive
    private Double costo;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "orden")
    private List<Asignacion> asignaciones; 

    
}
