package huertohogar.cl.huerto_hogar_backend.controlador;

import huertohogar.cl.huerto_hogar_backend.modelo.Producto;
import huertohogar.cl.huerto_hogar_backend.servicio.ProductoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "*")
public class ProductoControlador {

    @Autowired
    private ProductoServicio productoServicio;

    @GetMapping
    public List<Producto> listarProductos() {
        return productoServicio.obtenerTodos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Producto> obtenerProducto(@PathVariable String id) {
        Optional<Producto> producto = productoServicio.obtenerPorId(id);
        return producto.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public Producto crearProducto(@RequestBody Producto producto) {
        return productoServicio.guardarProducto(producto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Producto> actualizarProducto(@PathVariable String id, @RequestBody Producto detallesProducto) {
        Optional<Producto> productoOptional = productoServicio.obtenerPorId(id);

        if (productoOptional.isPresent()) {
            Producto productoExistente = productoOptional.get();
            productoExistente.setNombre(detallesProducto.getNombre());
            productoExistente.setDescripcion(detallesProducto.getDescripcion());
            productoExistente.setPrecio(detallesProducto.getPrecio());
            productoExistente.setStock(detallesProducto.getStock());
            productoExistente.setImagen(detallesProducto.getImagen());
            productoExistente.setCategoria(detallesProducto.getCategoria());

            return ResponseEntity.ok(productoServicio.guardarProducto(productoExistente));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

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