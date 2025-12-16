package huertohogar.cl.huerto_hogar_backend.controlador;

import huertohogar.cl.huerto_hogar_backend.modelo.Contacto;
import huertohogar.cl.huerto_hogar_backend.servicio.ContactoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/contactos")
@Tag(name = "Contacto", description = "Buzón de mensajes y solicitudes de clientes")
public class ContactoControlador {

    @Autowired
    private ContactoServicio contactoServicio;

    @Operation(summary = "Enviar mensaje", description = "Registra una nueva solicitud de contacto o duda de un cliente")
    @PostMapping
    public Contacto crearContacto(@RequestBody Contacto contacto) {
        return contactoServicio.guardar(contacto);
    }

    @Operation(summary = "Listar mensajes", description = "Muestra todos los mensajes recibidos en el buzón (Admin)")
    @GetMapping
    public List<Contacto> listarContactos() {
        return contactoServicio.obtenerTodos();
    }
    
    @Operation(summary = "Eliminar mensaje", description = "Borra un registro de contacto de la base de datos")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarContacto(@PathVariable Long id) {
        contactoServicio.eliminar(id);
        return ResponseEntity.ok().build();
    }

    @Operation(summary = "Marcar como Revisado", description = "Cambia el estado del mensaje para indicar que ya fue atendido")
    @PutMapping("/{id}/revisado")
    public ResponseEntity<Contacto> marcarRevisado(@PathVariable Long id) {
        Contacto contactoActualizado = contactoServicio.marcarComoRevisado(id);
        
        if (contactoActualizado != null) {
            return ResponseEntity.ok(contactoActualizado);
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}