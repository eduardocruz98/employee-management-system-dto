package ec.employes.dto;

import lombok.Data;

@Data
public class EmpleadoResponseDTO {
    private Integer idEmpleado;

    private String nombre;

    private String apellido;

    private String correo;

    private String telefono;

    private Double salario;

    private Integer idDepartamento;

    private String nombreDepartamento;
}
