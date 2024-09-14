package edu.coder.preentrega.entidades;

import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;

import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "CLIENTE") // Se usa para indicarle a JPA adonde se mapeara la entidad, sino JPA asumira que la tabla se llama igual que la clase
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // El ID, no es lo mismo que el requiredMode, al ser de solo lectura, solo le damos el acceso con accessMode y READ_ONLY, asi le declaramos que solo sera de lectura
    @Schema(description = "ID unico del cliente", example = "1", accessMode = Schema.AccessMode.READ_ONLY )
    private long id;

    // Creamos las columnas con sus respectivos nombres y le asignamos valores
    // Lo mismo que con Table, se usa para indicar donde se mapeara, sino JPA asume que la columna se llama igual que el atributo
    @Column(name = "NOMBRE") // Al ser las columnas con @, no se pone el ";"
    @Schema(description = "Nombre del cliente", example = "Alejo", requiredMode = Schema.RequiredMode.REQUIRED) // Aca se pone REQUIRED porque es requerido para crear el cliente
    private String nombre;

    @Column(name = "APELLIDO")
    @Schema(description = "Apellido del cliente", example = "Hurtado Testa", requiredMode = Schema.RequiredMode.REQUIRED)
    private String apellido;

    @Column(name = "DNI")
    @Schema(description = "DNI del cliente", example = "12345678", requiredMode = Schema.RequiredMode.REQUIRED)
    private long dni;


    // Relacion uno a muchos, un clientte puede tener muchos comprobantes de venta
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @Schema(description = "Lista de las ventas asociadas al cliente", accessMode = Schema.AccessMode.READ_ONLY)
    @JsonIgnore
    private List<Ventas> venta;

    public Cliente() {
    }

    public Cliente(String nombre, String apellido, long dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.dni = dni;
        //this.domicilio = domicilio;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public List<Ventas> getVenta() {
        return venta;
    }

    public void setVenta(List<Ventas> venta) {
        this.venta = venta;
    }

    // Usamos equals and hashCode porque cuando dos clases son hijas de la misma clase, para comparar si dos objetos son iguales comparando el contenido de adentro,
    // sobreecribimos los metodos, porque Java por defecto, compara por el nombre y discrimina el contenido
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return id == cliente.id && dni == cliente.dni && Objects.equals(nombre, cliente.nombre) && Objects.equals(apellido, cliente.apellido);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nombre, apellido, dni);
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "apellido='" + apellido + '\'' +
                ", id=" + id +
                ", nombre='" + nombre + '\'' +
                ", dni=" + dni +
                '}';
    }
}
