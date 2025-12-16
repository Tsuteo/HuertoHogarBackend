package huertohogar.cl.huerto_hogar_backend.repositorio;

import huertohogar.cl.huerto_hogar_backend.modelo.Orden;
import huertohogar.cl.huerto_hogar_backend.modelo.Usuario;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface OrdenRepositorio extends JpaRepository<Orden, Long> {
    List<Orden> findByUsuarioId(Long usuarioId);
    List<Orden> findByUsuario(Usuario usuario);
}