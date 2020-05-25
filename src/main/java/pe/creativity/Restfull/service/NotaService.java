package pe.creativity.Restfull.service;

import org.springframework.data.domain.Pageable;
import pe.creativity.Restfull.dto.NotaDto;
import pe.creativity.Restfull.entity.Nota;
import java.util.List;
import java.util.Optional;


public interface NotaService {

    public List<Nota> findAllNotas();

//    public Optional<Nota> findNotasById(Long id);
//
//    public Optional<NotaDto> findNotaByID(Long id);

    public Nota saveNota(Nota notaNew);

    void saveNote(String nombre, String titulo, String contenido);

    public String deleteNota(Long id);

    public String updateNota(Nota notaNew);

    Nota updateNote(String nombre, String titulo, String contenido);

    public List<Nota> getPaginacion(Pageable pageable);
}
