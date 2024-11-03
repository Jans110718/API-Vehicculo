package pe.edu.cibertec.vehiculo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import pe.edu.cibertec.vehiculo.model.Vehiculo;

public interface VehiculoRepository extends JpaRepository<Vehiculo, Integer> {
}
