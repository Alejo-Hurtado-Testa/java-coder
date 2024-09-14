package edu.coder.preentrega.service;

import edu.coder.preentrega.entidades.Cliente;
import edu.coder.preentrega.entidades.Productos;
import edu.coder.preentrega.entidades.ProductosVendidos;
import edu.coder.preentrega.entidades.Ventas;
import edu.coder.preentrega.repository.ClienteRepository;
import edu.coder.preentrega.repository.ProdVendidosRepository;
import edu.coder.preentrega.repository.ProductosRepository;
import edu.coder.preentrega.repository.VentasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Service
public class VentasService {

    @Autowired
    private VentasRepository ventasRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private ProductosRepository productosRepository;

    @Autowired
    private ProdVendidosRepository prodVendidosRepository;

    public Ventas guardarVenta(Long clienteId, Long productoId, int cantidad) {

        // Nos aseguramos de que el cliente exista, sino, lanzamos una excepcion
        Cliente cliente = clienteRepository.findById(clienteId)
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        Productos productos = productosRepository.findById(productoId)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado"));

        Ventas ventas = new Ventas();
        ventas.setFechaVenta(LocalDate.now()); // Esto nos devuelve la fecha exacta de cuando se hizo la venta
        ventas.setCliente(cliente); // Le asignamos el cliente a la venta y lo guardamos
        ventas = ventasRepository.save(ventas);

        ProductosVendidos productosVendidos = new ProductosVendidos();
        // Seteamos la venta, los productos y la cantidad a los productos vendidos
        productosVendidos.setVentas(ventas);
        productosVendidos.setProductos(productos);
        productosVendidos.setCantidad(cantidad);
        prodVendidosRepository.save(productosVendidos);

        // Y agregamos los productos vendidos a la venta en forma de array
        List<ProductosVendidos> productosVendidos1 = new ArrayList<>();
        productosVendidos1.add(productosVendidos);
        ventas.setProductosVendidos(productosVendidos1);

        return ventasRepository.save(ventas);
    }

}
