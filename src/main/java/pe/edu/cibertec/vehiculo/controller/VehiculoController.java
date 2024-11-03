package pe.edu.cibertec.vehiculo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pe.edu.cibertec.vehiculo.repository.VehiculoRepository;

import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin(origins = "http://localhost:8080") // Origen permitido
@RestController
@RequestMapping("/api")
public class VehiculoController {

    @Autowired
    private VehiculoRepository vehiculoRepository;

    @GetMapping("/vehiculos")
    public ResponseEntity<List<VehiculoResponse>> getVehiculosWithDetails() {
        List<VehiculoResponse> vehiculosConDetalles = vehiculoRepository.findAll().stream()
                .map(vehiculo -> new VehiculoResponse(
                        vehiculo.getTipo() != null ? vehiculo.getTipo().getDescripcion() : "Sin tipo",
                        vehiculo.getModelo() != null ? vehiculo.getModelo().getNombre() : "Sin modelo",
                        vehiculo.getModelo() != null && vehiculo.getModelo().getMarca() != null ? vehiculo.getModelo().getMarca().getNombre() : "Sin marca",
                        vehiculo.getTransporte() != null ? vehiculo.getTransporte().getDescripcion() : "Sin tipos"
                ))
                .collect(Collectors.toList());

        return ResponseEntity.ok(vehiculosConDetalles);
    }

    // Clase estática para la respuesta
    static class VehiculoResponse {
        private String tipo;
        private String modelo;
        private String marca;
        private String transporte;

        public VehiculoResponse(String tipo, String modelo, String marca, String transporte) {
            this.tipo = tipo;
            this.modelo = modelo;
            this.marca = marca;
            this.transporte = transporte;
        }

        public String getTipo() {
            return tipo;
        }

        public String getModelo() {
            return modelo;
        }

        public String getMarca() {
            return marca;
        }

        public String getTransporte() {
            return transporte;
        }
    }
}
