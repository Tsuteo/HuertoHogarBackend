package huertohogar.cl.huerto_hogar_backend.servicio;

import huertohogar.cl.huerto_hogar_backend.modelo.Categoria;
import huertohogar.cl.huerto_hogar_backend.repositorio.CategoriaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaServicio {

    @Autowired
    private CategoriaRepositorio categoriaRepositorio;

    public List<Categoria> obtenerTodas() {
        return categoriaRepositorio.findAll();
    }

    public Optional<Categoria> obtenerPorId(String id) {
        return categoriaRepositorio.findById(id);
    }

    public Categoria guardarCategoria(Categoria categoria) {
        return categoriaRepositorio.save(categoria);
    }

    public void eliminarCategoria(String id) {
        categoriaRepositorio.deleteById(id);
    }
}