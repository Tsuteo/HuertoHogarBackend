package huertohogar.cl.huerto_hogar_backend.controlador;

import huertohogar.cl.huerto_hogar_backend.modelo.Blog;
import huertohogar.cl.huerto_hogar_backend.servicio.BlogServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/blogs")
@Tag(name = "Blog", description = "Gestión de noticias y consejos del Huerto")
public class BlogControlador {

    @Autowired
    private BlogServicio blogServicio;

    @Operation(summary = "Listar blogs", description = "Devuelve todos los artículos publicados en el blog")
    @GetMapping
    public List<Blog> listarBlogs() {
        return blogServicio.obtenerTodos();
    }

    @Operation(summary = "Obtener blog por ID", description = "Busca un artículo específico por su identificador")
    @GetMapping("/{id}")
    public ResponseEntity<Blog> obtenerBlog(@PathVariable String id) {
        return blogServicio.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Publicar artículo", description = "Crea una nueva entrada en el blog")
    @PostMapping
    public Blog crearBlog(@RequestBody Blog blog) {
        return blogServicio.guardar(blog);
    }

    @Operation(summary = "Actualizar artículo", description = "Modifica el título, contenido o imagen de una noticia existente")
    @PutMapping("/{id}")
    public ResponseEntity<Blog> actualizarBlog(@PathVariable String id, @RequestBody Blog detalles) { 
        Optional<Blog> blogOpt = blogServicio.obtenerPorId(id);
        if (blogOpt.isPresent()) {
            Blog blog = blogOpt.get();
            blog.setTitulo(detalles.getTitulo());
            blog.setContenido(detalles.getContenido());
            blog.setImagen(detalles.getImagen());
            blog.setAutor(detalles.getAutor());

            return ResponseEntity.ok(blogServicio.guardar(blog));
        }
        return ResponseEntity.notFound().build();
    }

    @Operation(summary = "Eliminar artículo", description = "Elimina permanentemente una noticia del blog")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarBlog(@PathVariable String id){
        blogServicio.eliminar(id);
        return ResponseEntity.ok().build();
    }
}