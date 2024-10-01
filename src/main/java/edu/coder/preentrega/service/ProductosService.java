package edu.coder.preentrega.service;

import edu.coder.preentrega.entidades.Productos;
import edu.coder.preentrega.repository.ProductosRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductosService {

    @Autowired
    private ProductosRepository productosRepository;

    public Productos agregarProducto(Productos producto) {
        return productosRepository.save(producto);
    }

    public Optional<Productos> buscarProducto(Long id) {
        return productosRepository.findById(id);
    }

    public void eliminarProducto(Long id) {
        productosRepository.deleteById(id);
    }
}
