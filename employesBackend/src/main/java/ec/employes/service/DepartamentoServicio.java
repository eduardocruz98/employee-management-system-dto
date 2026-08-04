package ec.employes.service;

import ec.employes.model.Departamento;
import ec.employes.repository.DepartamentoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.NoSuchElementException;

@Service
public class DepartamentoServicio implements IDepartamentoServicio{
    @Autowired
    private DepartamentoRepositorio departamentoRepositorio;

    @Override
    public List<Departamento> listarDepartamentos() {
        return this.departamentoRepositorio.findAll();
    }

    @Override
    public Departamento buscarDepartamentoPorId(Integer idDepartamento) {
        return this.departamentoRepositorio.findById(idDepartamento).orElse(null);
    }

    @Override
    public Departamento agregarDepartamento(Departamento departamento) {
        return this.departamentoRepositorio.save(departamento);
    }

    @Override
    public void eliminarDepartamentoPorId(Integer idDepartamento) {
        if (!departamentoRepositorio.existsById(idDepartamento)){
            throw new NoSuchElementException("No existe empleado con id: " + idDepartamento);
        }
        this.departamentoRepositorio.deleteById(idDepartamento);
    }
}
