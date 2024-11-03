package pe.edu.cibertec.vehiculo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class TipoVehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTipo;

    private String descripcion;

    @OneToMany(mappedBy = "tipo", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonIgnore 
    private Set<Vehiculo> vehiculos;
}
