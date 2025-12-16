package huertohogar.cl.huerto_hogar_backend.modelo;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;

@Entity
@Table(name = "productos")
public class Producto {

    @Id
    @Column(length = 20)
    private String id;

    @Column(nullable = false, length = 100)
    private String nombre;

    @Column(length = 500)
    private String descripcion;

    @Min(value = 0, message = "El precio no puede ser negativo")
    @Column(nullable = false)
    private Integer precio;

    @Min(value = 0, message = "El stock no puede ser negativo")
    @Column(nullable = false)
    private Double stock;

    @Column(name = "imagen")
    private String imagen;

    @Column(length = 50)
    private String categoria;
    
    @Column(name = "unidad_medida", length = 20)
    private String unidadMedida;

    public Producto() {
    }

    public Producto(String id, String nombre, String descripcion, Integer precio, Double stock, String imagen, String categoria, String unidadMedida) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.stock = stock;
        this.imagen = imagen;
        this.categoria = categoria;
        this.unidadMedida = unidadMedida;
    }

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public String getDescripcion() { return descripcion; }
    public void setDescripcion(String descripcion) { this.descripcion = descripcion; }

    public Integer getPrecio() { return precio; }
    public void setPrecio(Integer precio) { this.precio = precio; }

    public Double getStock() { return stock; }
    public void setStock(Double stock) { this.stock = stock; }

    public String getImagen() { return imagen; }
    public void setImagen(String imagen) { this.imagen = imagen; }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
    
    public String getUnidadMedida() { return unidadMedida; }
    public void setUnidadMedida(String unidadMedida) { this.unidadMedida = unidadMedida; }
}