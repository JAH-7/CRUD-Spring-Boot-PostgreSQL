package pe.creativity.Restfull.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import pe.creativity.Restfull.entity.Nota;

import java.io.Serializable;
import java.util.List;

@Repository("repositorio")
public interface NotaRepositorio extends JpaRepository<Nota, Serializable>, PagingAndSortingRepository<Nota, Serializable> {
    /*Repository es un DAO(acceso a los objetos de la logica del negocio)
      capa tambien llamada domain(dominio)                                */

    public abstract Nota findByNombre(String nombre);

    public abstract List<Nota> findByTitulo(String titulo);

    public abstract Nota findByNombreAndTitulo(String nombre, String titulo);

    public abstract Nota findById(Long id);

    public abstract Page<Nota> findAll(Pageable pageable);
}
