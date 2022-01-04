package com.sistemas.monolito.dominio;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Entity
@Data
public class Asignacion {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "order_id",
        referencedColumnName = "id",
        nullable = false,
        foreignKey = @ForeignKey(name="fk_orden_asignacion"))
    private Orden orden;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "fase_id",
        referencedColumnName = "id",
        nullable = false,
        foreignKey = @ForeignKey(name="fk_fase_asignacion"))
    private Fase fase;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(
        name = "empleado_id",
        referencedColumnName = "id",
        nullable = false,
        foreignKey = @ForeignKey(name="fk_empleado_asignacion"))
    private Empleado empleado;

    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaInicio;
    
    @Temporal(TemporalType.TIMESTAMP)
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date fechaFin;
}
