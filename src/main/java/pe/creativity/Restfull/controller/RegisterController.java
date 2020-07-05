package pe.creativity.Restfull.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import pe.creativity.Restfull.entity.Person;
import pe.creativity.Restfull.service.PersonService;

import javax.validation.Valid;

@RestController
@RequestMapping("/v2")
public class RegisterController {

    @Autowired
    PersonService personService;

    @ApiOperation(value = "Crear una persona usando entity")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK")})
    @PostMapping("/RegistrarCliente")
    public Person addPerson(@RequestBody @Valid Person person) {
        return personService.savePerson(person);
    }

    @ApiOperation(value = "Listar al Registro persona usando entity")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK")})
    @GetMapping("/ListarClientes")
    public Iterable<Person> ListPerson() {
        return personService.findAllPerson();
    }

}
