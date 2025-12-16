package huertohogar.cl.huerto_hogar_backend.controlador;

import huertohogar.cl.huerto_hogar_backend.modelo.Producto;
import huertohogar.cl.huerto_hogar_backend.servicio.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/productos")
@Tag(name = "Gestión de Productos", description = "Catálogo de productos: Crear, Listar, Actualizar y Eliminar") 
public class ProductoControlador {

    @Autowired
    private ProductoServicio productoServicio;

    @Operation(summary = "Listar productos", description = "Devuelve el catálogo completo de productos disponibles")
    @GetMapping
    public List<Producto> listarProductos() {
        return productoServicio.obtenerTodos();
    }

    @Operation(summary = "Buscar productos", description = "Filtra productos según el criterio especificado (prefijo/categoría)")
    @GetMapping("/buscar")
    public List<Producto> buscarPorPrefijo(@RequestParam String prefijo) {
        return productoServicio.buscarPorCategoriaId(prefijo);
    }

    @Operation(summary = "Obtener por ID", description = "Busca el detalle de un producto específico")
    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtenerProducto(@PathVariable String id) {
        Optional<Producto> producto = productoServicio.obtenerPorId(id);
        return producto.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @Operation(summary = "Crear producto", description = "Agrega un nuevo producto al inventario")
    @PostMapping
    public Producto crearProducto(@Valid @RequestBody Producto producto) {
        return productoServicio.guardarProducto(producto);
    }

    @Operation(summary = "Actualizar producto", description = "Modifica los datos de un producto existente")
    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable String id, @Valid @RequestBody Producto detallesProducto) { // Agregado @Valid
        Optional<Producto> productoOptional = productoServicio.obtenerPorId(id);

        if (productoOptional.isPresent()) {
            Producto productoExistente = productoOptional.get();
            productoExistente.setNombre(detallesProducto.getNombre());
            productoExistente.setDescripcion(detallesProducto.getDescripcion());
            productoExistente.setPrecio(detallesProducto.getPrecio());
            productoExistente.setStock(detallesProducto.getStock());
            productoExistente.setImagen(detallesProducto.getImagen());
            productoExistente.setCategoria(detallesProducto.getCategoria());
            productoExistente.setUnidadMedida(detallesProducto.getUnidadMedida());

            return ResponseEntity.ok(productoServicio.guardarProducto(productoExistente));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @Operation(summary = "Eliminar producto", description = "Elimina un producto del sistema")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarProducto(@PathVariable String id) {
        Optional<Producto> producto = productoServicio.obtenerPorId(id);
        if (producto.isPresent()) {
            productoServicio.eliminarProducto(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}