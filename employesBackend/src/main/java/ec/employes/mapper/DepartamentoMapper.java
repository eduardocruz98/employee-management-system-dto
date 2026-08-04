package ec.employes.mapper;

import ec.employes.dto.DepartamentoRequestDTO;
import ec.employes.dto.DepartamentoResponseDTO;
import ec.employes.model.Departamento;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DepartamentoMapper {
    // Entity -> ResponseDTO
    //Response
    public DepartamentoResponseDTO toResponseDTO(Departamento departamento){

        DepartamentoResponseDTO dto = new DepartamentoResponseDTO();

        dto.setIdDepartamento(departamento.getIdDepartamento());
        dto.setNombre(departamento.getNombre());

        return dto;
    }

    // Lista<Entity> -> Lista<ResponseDTO>
    //Response
    public List<DepartamentoResponseDTO> toResponseDTOList(List<Departamento> departamentos){

        return departamentos.stream()
                .map(this::toResponseDTO)
                .collect(Collectors.toList());

    }

    // RequestDTO -> Entity
    //Request
    public Departamento toEntity(DepartamentoRequestDTO dto){

        Departamento departamento = new Departamento();

        departamento.setNombre(dto.getNombre());

        return departamento;

    }

    // Actualizar una entidad existente
    //Request
    public void updateEntity(Departamento departamento, DepartamentoRequestDTO dto){

        departamento.setNombre(dto.getNombre());

    }
}
