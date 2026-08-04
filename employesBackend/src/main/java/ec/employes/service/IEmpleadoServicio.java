package ec.employes.service;

import ec.employes.model.Empleado;

import java.util.List;

public interface IEmpleadoServicio {
    List<Empleado> listarEmpleados();

    Empleado buscarEmpleadoPorId(Integer idEmpleado);

    List<Empleado> buscarEmpleadosPorNombre(String nombre);

    List<Empleado> buscarPorDepartamento(String departamento);

    Empleado guardarEmpleado(Empleado empleado);

    void eliminarEmpleadoPorId(Integer idEmpleado);
}
