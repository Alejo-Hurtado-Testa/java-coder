package edu.coder.preentrega.repository;

import edu.coder.preentrega.entidades.Productos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductosRepository extends JpaRepository<Productos, Long> {
}
