package ec.employes.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

@Data
public class EmpleadoRequestDTO {
    @NotBlank(message = "El nombre es obligatorio")
    @Size(max = 50)
    private String nombre;

    @NotBlank(message = "El apellido es obligatorio")
    @Size(max = 50)
    private String apellido;

    @NotBlank(message = "El correo es obligatorio")
    @Email
    @Size(max = 100)
    private String correo;

    @NotBlank(message = "El teléfono es obligatorio")
    @Size(min = 10, max = 15)
    private String telefono;

    @NotNull
    @Positive
    private Double salario;

    @NotNull(message = "Debe seleccionar un departamento")
    private Integer idDepartamento;
}
