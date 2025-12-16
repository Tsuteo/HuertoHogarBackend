package huertohogar.cl.huerto_hogar_backend.controlador;

import huertohogar.cl.huerto_hogar_backend.modelo.Categoria;
import huertohogar.cl.huerto_hogar_backend.servicio.CategoriaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/categorias")
@Tag(name = "Categorías", description = "Gestión de categorías y clasificación de productos") 
public class CategoriaControlador {

    @Autowired
    private CategoriaServicio categoriaServicio;

    @Operation(summary = "Listar categorías", description = "Obtiene todas las categorías disponibles para filtrar productos")
    @GetMapping
    public List<Categoria> listarCategorias() {
        return categoriaServicio.obtenerTodas();
    }

    @Operation(summary = "Obtener categoría por ID", description = "Busca el detalle de una categoría específica")
    @GetMapping("/{id}")
    public ResponseEntity<Categoria> obtenerCategoria(@PathVariable String id) {
        return categoriaServicio.obtenerPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @Operation(summary = "Crear categoría", description = "Agrega una nueva clasificación al sistema")
    @PostMapping
    public Categoria crearCategoria(@RequestBody Categoria categoria) {
        return categoriaServicio.guardarCategoria(categoria);
    }

    @Operation(summary = "Actualizar categoría", description = "Modifica el nombre, descripción o imagen de una categoría existente")
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

    @Operation(summary = "Eliminar categoría", description = "Elimina una categoría del sistema")
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