package edu.coder.preentrega.controller;

import edu.coder.preentrega.entidades.Cliente;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import edu.coder.preentrega.service.ClienteService;

import java.util.Optional;

@RestController
@RequestMapping("/cliente") // Vamos a mapear el request a esta ruta
@Tag(name = "Cliente", description = "Agrega un nuevo cliente a la BD")
public class ClienteController {

    // El controlador recibe la peticion del front y linkea con el controlador donde esta la logica
    // El controlador solo tiene la tarea de recibir la peticion del front

    @Autowired // Esto inyecta automáticamente la dependencia requerida por el constructor de ClienteController
    private ClienteService clienteService; // Instanciamos una variable que se utilizará para interactuar con el servicio

    @PostMapping(path = "/agregar", consumes = {MediaType.APPLICATION_JSON_VALUE}) // Creamos una ruta donde recibimos un POST, sacamos del body los datos del cliente (@RequestBody Cliente cliente)
    public Cliente agregarCliente(@RequestBody Cliente cliente) {
        return clienteService.crearCliente(cliente); // Y a los datos se los pasamos a la funcion para crear el cliente
    }

    @GetMapping(path = "/buscar/{id}", produces = {MediaType.APPLICATION_JSON_VALUE}) // Creamos ruta mapeando GET pasando por URI
    public Optional<Cliente> traerCliente(@PathVariable Long id) { // Sacamos de la URI el id y se lo pasamos como parametro a traerCliente()
        return clienteService.traerCliente(id); // Retornamos los argumentos para que busque
    }

}
