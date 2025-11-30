package huertohogar.cl.huerto_hogar_backend.repositorio;

import huertohogar.cl.huerto_hogar_backend.modelo.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface ProductoRepositorio extends JpaRepository<Producto, String> {
    List<Producto> findByIdStartingWith(String prefijo);
}