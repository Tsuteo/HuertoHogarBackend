package huertohogar.cl.huerto_hogar_backend.modelo;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "blogs")
public class Blog {

    @Id
    @Column(length = 20)
    private String id;

    @Column(nullable = false)
    private String titulo;

    @Column(length = 5000)
    private String contenido;

    private String imagen;

    private String autor;

    private LocalDate fecha;

    public Blog() {
        this.fecha = LocalDate.now();
    }

    public Blog(String id, String titulo, String contenido, String imagen, String autor) {
        this.id = id;
        this.titulo = titulo;
        this.contenido = contenido;
        this.imagen = imagen;
        this.autor = autor;
        this.fecha = LocalDate.now();
    }


    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getTitulo() { return titulo; }
    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getContenido() { return contenido; }
    public void setContenido(String contenido) { this.contenido = contenido; }

    public String getImagen() { return imagen; }
    public void setImagen(String imagen) { this.imagen = imagen; }

    public String getAutor() { return autor; }
    public void setAutor(String autor) { this.autor = autor; }

    public LocalDate getFecha() { return fecha; }
    public void setFecha(LocalDate fecha) { this.fecha = fecha; }
}