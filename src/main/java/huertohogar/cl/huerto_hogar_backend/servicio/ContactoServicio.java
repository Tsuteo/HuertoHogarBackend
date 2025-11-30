package huertohogar.cl.huerto_hogar_backend.servicio;

import huertohogar.cl.huerto_hogar_backend.modelo.Contacto;
import huertohogar.cl.huerto_hogar_backend.repositorio.ContactoRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ContactoServicio {

    @Autowired
    private ContactoRepositorio contactoRepositorio;

    public Contacto guardar(Contacto contacto) {
        if (contacto.getEstado() == null) {
            contacto.setEstado("PENDIENTE");
        }
        return contactoRepositorio.save(contacto);
    }

    public List<Contacto> obtenerTodos() {
        return contactoRepositorio.findAll();
    }
    
    public void eliminar(Long id) {
        contactoRepositorio.deleteById(id);
    }

    public Contacto marcarComoRevisado(Long id) {
        Optional<Contacto> contactoOpt = contactoRepositorio.findById(id);
        
        if (contactoOpt.isPresent()) {
            Contacto contacto = contactoOpt.get();
            contacto.setEstado("REVISADO");
            return contactoRepositorio.save(contacto);
        }
        return null;
    }
}
