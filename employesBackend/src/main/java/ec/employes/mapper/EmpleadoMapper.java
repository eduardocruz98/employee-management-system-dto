package ec.employes.mapper;

import ec.employes.dto.EmpleadoRequestDTO;
import ec.employes.dto.EmpleadoResponseDTO;
import ec.employes.model.Departamento;
import ec.employes.model.Empleado;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class EmpleadoMapper {
    // Entity -> ResponseDTO
    public EmpleadoResponseDTO toResponseDTO(Empleado empleado){

        EmpleadoResponseDTO dto = new EmpleadoResponseDTO();

        dto.setIdEmpleado(empleado.getIdEmpleado());
        dto.setNombre(empleado.getNombre());
        dto.setApellido(empleado.getApellido());
        dto.setCorreo(empleado.getCorreo());
        dto.setTelefono(empleado.getTelefono());
        dto.setSalario(empleado.getSalario());

        dto.setIdDepartamento(empleado.getDepartamento().getIdDepartamento());

        dto.setNombreDepartamento(empleado.getDepartamento().getNombre());

        return dto;
    }

    // Lista<Entity> -> Lista<ResponseDTO>
    public List<EmpleadoResponseDTO> toResponseDTOList(List<Empleado> empleados){

        return empleados.stream().map(this::toResponseDTO).collect(Collectors.toList());

    }

    // RequestDTO -> Entity
    public Empleado toEntity(EmpleadoRequestDTO dto, Departamento departamento){

        Empleado empleado = new Empleado();

        empleado.setNombre(dto.getNombre());
        empleado.setApellido(dto.getApellido());
        empleado.setCorreo(dto.getCorreo());
        empleado.setTelefono(dto.getTelefono());
        empleado.setSalario(dto.getSalario());
        empleado.setDepartamento(departamento);

        return empleado;

    }

    // Actualizar una entidad existente
    public void updateEntity(Empleado empleado, EmpleadoRequestDTO dto, Departamento departamento){

        empleado.setNombre(dto.getNombre());
        empleado.setApellido(dto.getApellido());
        empleado.setCorreo(dto.getCorreo());
        empleado.setTelefono(dto.getTelefono());
        empleado.setSalario(dto.getSalario());
        empleado.setDepartamento(departamento);

    }
}
