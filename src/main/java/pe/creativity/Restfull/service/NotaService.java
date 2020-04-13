package pe.creativity.Restfull.service;

import org.springframework.data.domain.Pageable;
import pe.creativity.Restfull.entity.Nota;
import java.util.List;
import java.util.Optional;


public interface NotaService {

    public List<Nota> findAllNotas();

    public Optional<Nota> findNotasById(Long id);

    public Nota saveNota(Nota notaNew);

    public String deleteNota(Long id);

    public String updateNota(Nota notaNew);

    public List<Nota> getPaginacion(Pageable pageable);
}
