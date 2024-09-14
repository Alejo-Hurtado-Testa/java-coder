package edu.coder.preentrega.repository;

import edu.coder.preentrega.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

/* Crear el repositorio implica crear solamente una interfaz que extiende de JpaRepository, por lo tanto,
 todas las cosas que esten definidas en la interface (JpaRepository) pasa a existir en ClienteRepository */
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
}
