package com.sistemas.monolito.dominio;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Past;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long Id;

    @Column(length = 60)
    @NotBlank(message="EL Apellido no debe estar en blanco")
    String apellido;

    @Column(length = 60)
    @NotBlank(message="EL Nombre no debe estar en blanco")
    String nombre;

    @Column(length = 8)
    @Size(min = 8, max = 8, message="EL DNI debe tener 8 dígitos")
    String dni;

    @Column(length = 9)
    @Size(min = 9, max = 9, message="EL celular debe tener 9 dígitos")
    String celular;

    @Column(length = 80)
    @Email(message = "Debe ingresar un EMAIL válido")
    String email;

    @Temporal(TemporalType.DATE)
    @Past(message = "La fecha de nacimiento debe ser anterior a la actual")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date fechaNacimiento;

    @Temporal(TemporalType.DATE)
    @Past(message = "La fecha de ingreso debe ser anterior a la actual")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    Date fechaIngreso;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "empleado")
    private List<Asignacion> asignaciones; 
}
