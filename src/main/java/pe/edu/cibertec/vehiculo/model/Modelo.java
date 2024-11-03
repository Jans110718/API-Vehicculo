package pe.edu.cibertec.vehiculo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class Modelo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idModelo;

    private String nombre;

    @ManyToOne
    @JoinColumn(name = "idMarca")
    private Marca marca;
}