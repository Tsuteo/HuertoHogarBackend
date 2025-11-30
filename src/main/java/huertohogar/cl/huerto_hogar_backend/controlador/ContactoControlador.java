package huertohogar.cl.huerto_hogar_backend.controlador;

import huertohogar.cl.huerto_hogar_backend.modelo.Contacto;
import huertohogar.cl.huerto_hogar_backend.servicio.ContactoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/contactos")
@CrossOrigin(origins = "*")
public class ContactoControlador {

    @Autowired
    private ContactoServicio contactoServicio;

    @PostMapping
    public Contacto crearContacto(@RequestBody Contacto contacto) {
        return contactoServicio.guardar(contacto);
    }

    @GetMapping
    public List<Contacto> listarContactos() {
        return contactoServicio.obtenerTodos();
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarContacto(@PathVariable Long id) {
        contactoServicio.eliminar(id);
        return ResponseEntity.ok().build();
    }

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