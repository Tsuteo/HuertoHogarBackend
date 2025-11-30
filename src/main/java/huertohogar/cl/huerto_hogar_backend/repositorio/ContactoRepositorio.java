package huertohogar.cl.huerto_hogar_backend.repositorio;

import huertohogar.cl.huerto_hogar_backend.modelo.Contacto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContactoRepositorio extends JpaRepository<Contacto, Long> {
}
