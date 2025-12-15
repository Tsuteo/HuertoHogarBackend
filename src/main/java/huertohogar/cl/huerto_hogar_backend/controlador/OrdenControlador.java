package huertohogar.cl.huerto_hogar_backend.controlador;

import huertohogar.cl.huerto_hogar_backend.modelo.Orden;
import huertohogar.cl.huerto_hogar_backend.servicio.OrdenServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/ordenes")
@Tag(name = "Órdenes de Compra", description = "Procesamiento de ventas y gestión del carrito")
public class OrdenControlador {

    @Autowired
    private OrdenServicio ordenServicio;

    @Operation(summary = "Historial de ventas", description = "Lista todas las órdenes generadas en el sistema")
    @GetMapping
    public List<Orden> listarOrdenes() {
        return ordenServicio.listarOrdenes();
    }

    
    @Operation(summary = "Generar nueva orden", description = "Procesa el carrito de compras. Recibe 'usuarioId' y lista de 'items' (productoId, cantidad).")
    @PostMapping
    @SuppressWarnings("unchecked")
    public ResponseEntity<?> crearOrden(@RequestBody Map<String, Object> payload) {
        try {
            Long usuarioId = Long.valueOf(payload.get("usuarioId").toString());
            
            List<Map<String, Object>> itemsMap = (List<Map<String, Object>>) payload.get("items");
            List<OrdenServicio.SolicitudItem> items = itemsMap.stream().map(i -> {
                OrdenServicio.SolicitudItem item = new OrdenServicio.SolicitudItem();
                item.productoId = i.get("productoId").toString();
                item.cantidad = (Integer) i.get("cantidad");
                return item;
            }).toList();

            Orden nuevaOrden = ordenServicio.crearOrden(usuarioId, items);
            return ResponseEntity.ok(nuevaOrden);

        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            return ResponseEntity.internalServerError().body("Error al procesar la orden: " + e.getMessage());
        }
    }
}