package edu.coder.preentrega.service;

import edu.coder.preentrega.entidades.Cliente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.coder.preentrega.repository.ClienteRepository;

import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository; // Instanciamos la clase del repositorio

    // METODOS

    // Creamos un metodo para crear el cliente en el repositorio
    public Cliente crearCliente(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    public Optional<Cliente> traerCliente(Long id) {
        return clienteRepository.findById(id);
    }

    public void eliminarCliente(Long id) {
       clienteRepository.deleteById(id);
    }
}
