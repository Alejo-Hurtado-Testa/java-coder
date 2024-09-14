package edu.coder.preentrega.controller;

import edu.coder.preentrega.entidades.ProductosVendidos;
import edu.coder.preentrega.entidades.Ventas;
import edu.coder.preentrega.service.VentasService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/ventas") // Vamos a mapear el request a esta ruta
@Tag(name = "Venta", description = "Agrega una nueva venta a la BD")
public class VentasController {

    @Autowired
    private VentasService ventasService;

    @PostMapping(path = "/agregar/{clienteId}", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Ventas agregarVenta(@PathVariable Long clienteId, @RequestBody ProductosVendidos productosVendidos) { // Para crear la venta y asociarla al producto y el cliente, necesitamos pasarle dos parametros
        return ventasService.guardarVenta(clienteId, productosVendidos.getProductos().getId(), productosVendidos.getCantidad());
    }

}
