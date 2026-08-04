package ec.employes.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString

public class Empleado {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEmpleado;

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 50)
    private String nombre;

    @NotBlank(message = "El apellido es obligatorio")
    @Size(max = 50)
    private String apellido;

    @NotBlank(message = "El correo es obligatorio")
    @Email(message = "Correo invalido")
    @Size(max = 100)
    private String correo;

    @NotBlank(message = "El telefono es obligatorio")
    @Size(min = 10, max = 15)
    private String telefono;

    @NotNull(message = "El salario es obligatorio")
    @Positive(message = "El salario debe ser mayor que cero")
    private Double salario;

    @NotNull(message = "Debe seleccionar un departamento")
    @ManyToOne
    @JoinColumn(name = "id_departamento")
    private Departamento departamento;

}
