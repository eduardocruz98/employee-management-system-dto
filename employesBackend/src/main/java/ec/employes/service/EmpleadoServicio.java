package ec.employes.service;

import ec.employes.model.Empleado;
import ec.employes.repository.EmpleadoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class EmpleadoServicio implements IEmpleadoServicio{
    @Autowired
    private EmpleadoRepositorio empleadoRepositorio;

    @Override
    public List<Empleado> listarEmpleados() {
        return this.empleadoRepositorio.findAll();
    }

    @Override
    public Empleado buscarEmpleadoPorId(Integer idEmpleado) {
        return this.empleadoRepositorio.findById(idEmpleado).orElse(null);
    }

    @Override
    public List<Empleado> buscarEmpleadosPorNombre(String nombre) {
        return empleadoRepositorio.findByNombreContainingIgnoreCase(nombre);
    }

    @Override
    public List<Empleado> buscarPorDepartamento(String departamento) {
        return empleadoRepositorio.findByDepartamentoIdDepartamento(departamento);
    }


    @Override
    public Empleado guardarEmpleado(Empleado empleado) {
        return this.empleadoRepositorio.save(empleado);
    }

    @Override
    public void eliminarEmpleadoPorId(Integer idEmpleado) {
        if (!empleadoRepositorio.existsById(idEmpleado)){
            throw new NoSuchElementException("No existe empleado con id: " + idEmpleado);
        }
        this.empleadoRepositorio.deleteById(idEmpleado);
    }
}
