package pe.creativity.Restfull.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.modelmapper.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;
import pe.creativity.Restfull.dto.NotaDto;
import pe.creativity.Restfull.entity.Nota;
import pe.creativity.Restfull.service.NotaService;
import pe.creativity.Restfull.util.Converter;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Api(value = "API para ver las notas")
@RestController
@RequestMapping("/v1")
public class NotaController {
    /*El controller solo controla los datos de entrada y salida
     y es donde se forman los endpoints y donde se consumen los servicios Rest*/

    public static final ModelMapper modelMapper = new ModelMapper();
    private static final Log LOGGER = LogFactory.getLog(NotaController.class);

    @Autowired
    private NotaService notaService;
    private Object NotaDto;

    private Converter converter;

    @ApiOperation(value = "Crear una persona usando entity")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK")})
    @PostMapping("/nota/add")
    public Nota addNota(@RequestBody @Valid Nota nota) {
        return notaService.saveNota(nota);
    }

    @ApiOperation(value = "Crear una persona correctamente desde DTO")
    @ApiResponses(value = {@ApiResponse(code = 201, message = "ok")})
    @PostMapping("/note/add/type2")
    private void addNotes(@RequestBody @Valid NotaDto dtoNote) {
        LOGGER.info("INGRESO AL ENDPOINT /v1/note/add/type2");
        notaService.saveNote(dtoNote.getNombre(), dtoNote.getTitulo(), dtoNote.getContenido());

    }

    @PutMapping("/nota/update/{id}")
    public String updateNota(@PathVariable("id") Long id, @Valid Nota notaNew) {
        return notaService.updateNota(notaNew);
    }

    @PutMapping("/note/updatedto/{id}")
    public NotaDto updateNote(@PathVariable("id") Long id, @Valid NotaDto notaDto){
        LOGGER.info("INGRESO AL ENDPOINT /note/updatedto/{}");
        //falta la conversion
        return notaService.updateNote(converter.toConvertNoteDTO(notaDto.getNombre(),notaDto.getTitulo(),notaDto.getContenido()));
    }

    @DeleteMapping("/nota/delete/{id}")
    public String deleteNota(@PathVariable Long id) {
        return notaService.deleteNota(id);
    }

    @ApiOperation("Obteniendo todas las notas")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 404, message = "No encontrado")})
    @GetMapping("/nota/all")
    public List<Nota> getNota() {
        return notaService.findAllNotas();
    }

    @ApiOperation("Obteniendo solo una de las notas con DTO")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 404, message = "No encontrado")})
    @GetMapping("/nota/get/")
    private void getIdNota(@RequestParam("id") NotaDto dto) {
        LOGGER.info("INGRESO AL ENDPOINT /v1/nota/get/id");
        //convertir a entity
       // Nota notaEntity = modelMapper.map(NotaDto,Nota.class);
     //   notaService.findNotaByID(dto.getId());
    }



    //http://localhost:8090/v1/notas?page=0&size=5
    @GetMapping("/notas")
    public List<Nota> getPaginacion(Pageable pageable) {
        return notaService.getPaginacion(pageable);
    }
}
