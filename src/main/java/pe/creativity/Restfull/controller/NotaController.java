package pe.creativity.Restfull.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;
import pe.creativity.Restfull.entity.Nota;
import pe.creativity.Restfull.service.NotaService;

import javax.validation.Valid;
import java.util.List;

@Api(value = "API para ver las notas")
@RestController
@RequestMapping("/v1")
public class NotaController {

    @Autowired
    private NotaService notaService;

    @ApiOperation(value = "Crear una persona con una nota")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK")})
    @PostMapping("/nota/add")
    public Nota addNota(@RequestBody @Valid Nota nota){
        return notaService.saveNota(nota);
    }

    @PutMapping("/nota/update/{id}")
    public String updateNota(@PathVariable("id") Long id, @Valid Nota notaNew){
        return notaService.updateNota(notaNew);
    }

    @DeleteMapping("/nota/delete/{id}")
    public String deleteNota(@PathVariable Long id){
        return notaService.deleteNota(id);
    }

    @ApiOperation("Obteniendo todas las notas")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK"), @ApiResponse(code = 404, message = "No encontrado")})
    @GetMapping("/nota/all")
    public List<Nota> getNota(){

        return notaService.findAllNotas();
    }

//http://localhost:8090/v1/notas?page=0&size=5
    @GetMapping("/notas")
    public List<Nota> getPaginacion(Pageable pageable){
    return notaService.getPaginacion(pageable);
    }

}
