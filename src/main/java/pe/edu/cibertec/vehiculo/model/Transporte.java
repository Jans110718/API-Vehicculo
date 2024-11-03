package pe.edu.cibertec.vehiculo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.util.List;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Transporte {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idTransporte;

    private String descripcion; // Este podría ser el nombre de la marca

    @OneToMany(mappedBy = "transporte")
    private List<Vehiculo> vehiculos;
}
