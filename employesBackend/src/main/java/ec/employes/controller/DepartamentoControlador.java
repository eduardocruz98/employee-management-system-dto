package ec.employes.controller;

import ec.employes.dto.DepartamentoRequestDTO;
import ec.employes.dto.DepartamentoResponseDTO;
import ec.employes.mapper.DepartamentoMapper;
import ec.employes.model.Departamento;
import ec.employes.service.DepartamentoServicio;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("employe-app")
@CrossOrigin(origins = "http://localhost:4200")
public class DepartamentoControlador {

    private static final Logger logger =
            LoggerFactory.getLogger(DepartamentoControlador.class);

    @Autowired
    private DepartamentoServicio departamentoServicio;

    @Autowired
    private DepartamentoMapper departamentoMapper;

    @GetMapping("/departamentos")
    public List<DepartamentoResponseDTO> obtenerDepartamentos() {

        List<Departamento> departamentos = departamentoServicio.listarDepartamentos();

        logger.info("Departamentos obtenidos");
        departamentos.forEach(d -> logger.info(d.toString()));

        return departamentoMapper.toResponseDTOList(departamentos);
    }

    @GetMapping("/departamentos/{id}")
    public ResponseEntity<DepartamentoResponseDTO> buscarDepartamentoPorId(@PathVariable Integer id) {

        Departamento departamento = departamentoServicio.buscarDepartamentoPorId(id);

        if (departamento == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(departamentoMapper.toResponseDTO(departamento));
    }

    @PostMapping("/departamentos")
    public ResponseEntity<DepartamentoResponseDTO> guardarDepartamento(@Valid @RequestBody DepartamentoRequestDTO dto) {

        Departamento departamento =departamentoMapper.toEntity(dto);

        Departamento guardado =departamentoServicio.agregarDepartamento(departamento);

        return ResponseEntity.status(HttpStatus.CREATED).body(departamentoMapper.toResponseDTO(guardado));
    }

    @PutMapping("/departamentos/{id}")
    public ResponseEntity<DepartamentoResponseDTO> actualizarDepartamento(@PathVariable Integer id,
                                                                          @Valid @RequestBody DepartamentoRequestDTO dto) {

        Departamento departamento =departamentoServicio.buscarDepartamentoPorId(id);

        if (departamento == null) {
            return ResponseEntity.notFound().build();
        }

        departamentoMapper.updateEntity(departamento, dto);

        departamentoServicio.agregarDepartamento(departamento);

        return ResponseEntity.ok(departamentoMapper.toResponseDTO(departamento));
    }

    @DeleteMapping("/departamentos/{id}")
    public ResponseEntity<Void> eliminarDepartamento(@PathVariable Integer id) {

        departamentoServicio.eliminarDepartamentoPorId(id);

        return ResponseEntity.noContent().build();
    }
}