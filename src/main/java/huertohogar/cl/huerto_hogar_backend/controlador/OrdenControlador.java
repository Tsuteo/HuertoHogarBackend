package huertohogar.cl.huerto_hogar_backend.controlador;

import huertohogar.cl.huerto_hogar_backend.modelo.Orden;
import huertohogar.cl.huerto_hogar_backend.servicio.OrdenServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/ordenes")
public class OrdenControlador {

    @Autowired
    private OrdenServicio ordenServicio;

    @PostMapping
    public ResponseEntity<?> crearOrden(@RequestBody Map<String, Object> payload) {
        try {
            Long usuarioId = Long.valueOf(payload.get("usuarioId").toString());

            List<Map<String, Object>> itemsMap = (List<Map<String, Object>>) payload.get("items");

            List<OrdenServicio.SolicitudItem> items = itemsMap.stream().map(i -> {
                OrdenServicio.SolicitudItem item = new OrdenServicio.SolicitudItem();
                item.productoId = i.get("productoId").toString();
                
                item.cantidad = Double.valueOf(i.get("cantidad").toString());
                
                return item;
            }).collect(Collectors.toList());

            Orden nuevaOrden = ordenServicio.crearOrden(usuarioId, items);
            return ResponseEntity.ok(nuevaOrden);

        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.internalServerError().body("Error al procesar la orden: " + e.getMessage());
        }
    }

    @GetMapping
    public List<Orden> listarOrdenes() {
        return ordenServicio.listarOrdenes();
    }

    @GetMapping("/usuario/{usuarioId}")
    public List<Orden> listarOrdenesPorUsuario(@PathVariable Long usuarioId) {
        return ordenServicio.listarOrdenesPorUsuario(usuarioId);
    }
    
    @PatchMapping("/{id}/estado")
    public ResponseEntity<Orden> actualizarEstado(@PathVariable Long id, @RequestBody Map<String, String> body) {
        String nuevoEstado = body.get("estado");
        Orden ordenActualizada = ordenServicio.actualizarEstadoOrden(id, nuevoEstado);
        return ResponseEntity.ok(ordenActualizada);
    }
}