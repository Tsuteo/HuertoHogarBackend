package huertohogar.cl.huerto_hogar_backend.repositorio;

import huertohogar.cl.huerto_hogar_backend.modelo.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepositorio extends JpaRepository<Blog, String> {
}