package pe.edu.cibertec.vehiculo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.cibertec.vehiculo.model.Modelo;

public interface ModeloRepository extends JpaRepository<Modelo, Integer> {
}
