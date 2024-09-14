package edu.coder.preentrega.repository;

import edu.coder.preentrega.entidades.ProductosVendidos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProdVendidosRepository extends JpaRepository<ProductosVendidos, Long> {
}
