package edu.coder.preentrega.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "VENTAS")
public class Ventas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private LocalDate fechaVenta;

    // RELACIONES

    // El comprobante de venta se relaciona con el cliente de forma que, muchos comprobantes pueden tener un cliente
    @ManyToOne
    @JoinColumn(name = "CLIENTE_ID")
    @JsonIgnore
    private Cliente cliente;

    // Declaramos la relacion de una venta a muchos productos
    @OneToMany(mappedBy = "ventas", cascade = CascadeType.ALL)
    private List<ProductosVendidos> productosVendidos; // Y esto almacenara la lista de productos que le hayamos pasado

    public Ventas() {
    }


    public long getId() {
        return id;
    }

    public LocalDate getFechaVenta() {
        return fechaVenta;
    }

    public void setFechaVenta(LocalDate fechaVenta) {
        this.fechaVenta = fechaVenta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public List<ProductosVendidos> getProductosVendidos() {
        return productosVendidos;
    }

    public void setProductosVendidos(List<ProductosVendidos> productosVendidos) {
        this.productosVendidos = productosVendidos;
    }
}
