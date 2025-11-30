package huertohogar.cl.huerto_hogar_backend.servicio;

import huertohogar.cl.huerto_hogar_backend.modelo.Blog;
import huertohogar.cl.huerto_hogar_backend.repositorio.BlogRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BlogServicio {

    @Autowired
    private BlogRepositorio blogRepositorio;

    public List<Blog> obtenerTodos() {
        return blogRepositorio.findAll();
    }

    public Optional<Blog> obtenerPorId(String id) {
        return blogRepositorio.findById(id);
    }

    public Blog guardar(Blog blog) {
        return blogRepositorio.save(blog);
    }

    public void eliminar(String id) {
        blogRepositorio.deleteById(id);
    }
}
