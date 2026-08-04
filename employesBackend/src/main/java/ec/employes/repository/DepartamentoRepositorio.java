package ec.employes.repository;

import ec.employes.model.Departamento;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartamentoRepositorio  extends JpaRepository<Departamento, Integer> {
}
