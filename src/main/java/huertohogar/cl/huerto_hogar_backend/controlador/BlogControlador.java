package huertohogar.cl.huerto_hogar_backend.controlador;

import huertohogar.cl.huerto_hogar_backend.modelo.Blog;
import huertohogar.cl.huerto_hogar_backend.servicio.BlogServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/blogs")
@CrossOrigin(origins = "*")
public class BlogControlador {

    @Autowired
    private BlogServicio blogServicio;

    @GetMapping
    public List<Blog> listarBlogs() {
        return blogServicio.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Blog> obtenerBlog(@PathVariable String id) {
        return blogServicio.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Blog crearBlog(@RequestBody Blog blog) {
        return blogServicio.guardar(blog);
    }

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

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarBlog(@PathVariable String id){
        blogServicio.eliminar(id);
        return ResponseEntity.ok().build();
    }
}