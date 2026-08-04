package ec.employes.controller;

import ec.employes.dto.EmpleadoRequestDTO;
import ec.employes.dto.EmpleadoResponseDTO;
import ec.employes.mapper.EmpleadoMapper;
import ec.employes.model.Departamento;
import ec.employes.model.Empleado;
import ec.employes.service.DepartamentoServicio;
import ec.employes.service.EmpleadoServicio;
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
public class EmpleadoControlador {

    private static final Logger logger =LoggerFactory.getLogger(EmpleadoControlador.class);

    @Autowired
    private EmpleadoServicio empleadoServicio;

    @Autowired
    private DepartamentoServicio departamentoServicio;

    @Autowired
    private EmpleadoMapper empleadoMapper;

    @GetMapping
    public List<EmpleadoResponseDTO> obtenerEmpleados() {

        List<Empleado> empleados =empleadoServicio.listarEmpleados();

        logger.info("Empleados obtenidos:");

        empleados.forEach(e -> logger.info(e.toString()));

        return empleadoMapper.toResponseDTOList(empleados);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<EmpleadoResponseDTO> buscarEmpleadoPorId(
            @PathVariable Integer id) {

        Empleado empleado =empleadoServicio.buscarEmpleadoPorId(id);

        if (empleado == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(empleadoMapper.toResponseDTO(empleado));
    }

    @GetMapping("/nombre/{nombre}")
    public List<EmpleadoResponseDTO> buscarEmpleadoPorNombre(
            @PathVariable String nombre) {

        List<Empleado> empleados =empleadoServicio.buscarEmpleadosPorNombre(nombre);

        return empleadoMapper.toResponseDTOList(empleados);
    }

    @GetMapping("/departamento/{departamento}")
    public List<EmpleadoResponseDTO> buscarPorDepartamento(@PathVariable String departamento) {

        List<Empleado> empleados =empleadoServicio.buscarPorDepartamento(departamento);

        return empleadoMapper.toResponseDTOList(empleados);
    }

    @PostMapping
    public ResponseEntity<EmpleadoResponseDTO> guardarEmpleado(
            @Valid @RequestBody EmpleadoRequestDTO dto) {

        Departamento departamento =departamentoServicio.buscarDepartamentoPorId(dto.getIdDepartamento());

        if (departamento == null) {
            return ResponseEntity.badRequest().build();
        }

        Empleado empleado =empleadoMapper.toEntity(dto, departamento);

        Empleado guardado =empleadoServicio.guardarEmpleado(empleado);

        return ResponseEntity.status(HttpStatus.CREATED).body(empleadoMapper.toResponseDTO(guardado));
    }

    @PutMapping("/id/{id}")
    public ResponseEntity<EmpleadoResponseDTO> actualizarEmpleado(@PathVariable Integer id, @Valid @RequestBody EmpleadoRequestDTO dto) {

        Empleado empleado =empleadoServicio.buscarEmpleadoPorId(id);

        if (empleado == null) {
            return ResponseEntity.notFound().build();
        }

        Departamento departamento =departamentoServicio.buscarDepartamentoPorId(dto.getIdDepartamento());

        if (departamento == null) {
            return ResponseEntity.badRequest().build();
        }

        empleadoMapper.updateEntity(empleado,dto,departamento);

        empleadoServicio.guardarEmpleado(empleado);

        return ResponseEntity.ok(empleadoMapper.toResponseDTO(empleado));
    }

    @DeleteMapping("/id/{id}")
    public ResponseEntity<Void> eliminarEmpleado(@PathVariable Integer id) {

        empleadoServicio.eliminarEmpleadoPorId(id);

        return ResponseEntity.noContent().build();
    }
}