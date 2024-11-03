package pe.edu.cibertec.vehiculo.model;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Vehiculo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idVehiculo;

    @ManyToOne
    @JoinColumn(name = "idModelo")
    private Modelo modelo;

    @ManyToOne
    @JoinColumn(name = "idTipo")
    private TipoVehiculo tipo;
    @ManyToOne
    @JoinColumn(name = "idTransporte")
    private Transporte transporte;
}