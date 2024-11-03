package pe.edu.cibertec.vehiculo.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.cibertec.vehiculo.model.Vehiculo;
import pe.edu.cibertec.vehiculo.repository.VehiculoRepository;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class VehiculoService {

    @Autowired
    private VehiculoRepository vehiculoRepository;

    // Método para obtener todos los vehículos
    public List<Vehiculo> getAllVehiculos() {
        return vehiculoRepository.findAll();
    }

 // Método para obtener la lista de vehículos con detalles de tipo, modelo y marca
    public List<String> getVehiculosWithDetails() {
        return vehiculoRepository.findAll().stream()
                .map(vehiculo -> {
                    String transporte =vehiculo.getTransporte() != null? vehiculo.getTransporte().getDescripcion() :"Sin transporte";
                    String tipo = vehiculo.getTipo() != null ? vehiculo.getTipo().getDescripcion() : "Sin tipo";
                    String modelo = vehiculo.getModelo() != null ? vehiculo.getModelo().getNombre() : "Sin modelo";
                    String marca = vehiculo.getModelo() != null && vehiculo.getModelo().getMarca() != null 
                                   ? vehiculo.getModelo().getMarca().getNombre() 
                                   : "Sin marca";
                    return String.format("Tipo vehiculo %s,Tipo: %s, Modelo: %s, Marca: %s",transporte, tipo, modelo, marca);
                })
                .collect(Collectors.toList());
    }
}