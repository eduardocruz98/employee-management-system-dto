package ec.employes.repository;

import ec.employes.model.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmpleadoRepositorio  extends JpaRepository<Empleado, Integer> {
    //Busca empleados por nombre, por lo tanto regresa una Lista por que no solo puede haber un empleado con ese
    //nombre, puede haber varios empleados con ese mismo nombre.
    List<Empleado> findByNombreContainingIgnoreCase(String nombre);

    //Buscar empleados por id de departamento
    List<Empleado> findByDepartamentoIdDepartamento(String departamento);
}
