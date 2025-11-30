package huertohogar.cl.huerto_hogar_backend.controlador;

import huertohogar.cl.huerto_hogar_backend.modelo.Categoria;
import huertohogar.cl.huerto_hogar_backend.servicio.CategoriaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/categorias")
@CrossOrigin(origins = "*")
public class CategoriaControlador {

    @Autowired
    private CategoriaServicio categoriaServicio;

    @GetMapping
    public List<Categoria> listarCategorias() {
        return categoriaServicio.obtenerTodas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categoria> obtenerCategoria(@PathVariable String id) {
        return categoriaServicio.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public Categoria crearCategoria(@RequestBody Categoria categoria) {
        return categoriaServicio.guardarCategoria(categoria);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categoria> actualizarCategoria(@PathVariable String id, @RequestBody Categoria detalles) {
        Optional<Categoria> categoriaOpt = categoriaServicio.obtenerPorId(id);

        if (categoriaOpt.isPresent()) {
            Categoria existente = categoriaOpt.get();
            existente.setNombre(detalles.getNombre());
            existente.setDescripcion(detalles.getDescripcion());
            existente.setImagen(detalles.getImagen());
            
            return ResponseEntity.ok(categoriaServicio.guardarCategoria(existente));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCategoria(@PathVariable String id) {
        if (categoriaServicio.obtenerPorId(id).isPresent()) {
            categoriaServicio.eliminarCategoria(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
