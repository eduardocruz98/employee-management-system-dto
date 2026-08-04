package ec.employes.service;

import ec.employes.model.Departamento;

import java.util.List;

public interface IDepartamentoServicio {
    List<Departamento> listarDepartamentos();

    Departamento buscarDepartamentoPorId(Integer idDepartamento);

    Departamento agregarDepartamento(Departamento departamento);

    void eliminarDepartamentoPorId(Integer idDepartamento);
}
