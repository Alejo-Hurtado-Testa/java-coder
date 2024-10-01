package edu.coder.preentrega.controller;

import edu.coder.preentrega.entidades.Productos;
import edu.coder.preentrega.service.ProductosService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/productos")
@Tag(name = "Productos", description = "Agrega un nuevo producto a la BD")
public class ProdController {

    // PONER VALIDACIONES PARA NO AGREGAR UN PRECIO NEGATIVO O COMPRAR MAS DE LOS PRODUCTOS ESTABLECIDOS

    @Autowired
    private ProductosService productosService;

    @PostMapping(path = "/agregar", consumes = {MediaType.APPLICATION_JSON_VALUE})
    public Productos agregarProducto(@RequestBody Productos producto) {
        return productosService.agregarProducto(producto);
    }

    @GetMapping(path = "/buscarprod/{id}", produces = {MediaType.APPLICATION_JSON_VALUE})
    public Optional<Productos> buscarProducto(@PathVariable long id) {
        return productosService.buscarProducto(id);
    }

    @DeleteMapping(path = "/eliminarprod/{id}")
    public ResponseEntity<String> eliminarCliente(@PathVariable Long id) {
        Optional<Productos> productos = productosService.buscarProducto(id); // Traemos el producto con su id
        if (productos.isPresent()) { // Si el producto esta presente, lo trae y lo eliminamos
            productosService.eliminarProducto(id);
            return ResponseEntity.ok("Producto eliminado correctamente"); // Retornamos una respuesta OK en caso de que el cliente haya sido eliminado
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("El producto con ID " + id + " no existe.");
        }
    }


}
