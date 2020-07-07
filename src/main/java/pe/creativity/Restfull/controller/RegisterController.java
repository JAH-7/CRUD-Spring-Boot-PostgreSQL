package pe.creativity.Restfull.controller;

import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

import pe.creativity.Restfull.entity.Person;
import pe.creativity.Restfull.service.PersonService;

import javax.validation.Valid;

@RestController
@RequestMapping("/v2")
public class RegisterController {

    Logger logger = LogManager.getLogger(RegisterController.class);

    @Autowired
    PersonService personService;

    @ApiOperation(value = "Crear una persona usando entity")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK")})
    @PostMapping("/RegistrarCliente")
    public Person addPerson(@RequestBody @Valid Person person) {
        logger.info("Ingreso metodo endpoint  -- INICIO Creando un nuevo usuario");
        logger.debug("Get Person Id: {}", person.getId());
        logger.debug("Get FirstName: {}", person.getFirstName());
        logger.debug("Get LastName: {}", person.getLastName());
        logger.debug("Get Phone: {}", person.getPhone());
        logger.debug("Get Email: {}", person.getEmail());
        logger.debug("Get DocType: {}", person.getDocType());
        logger.debug("Get DocNumber: {}", person.getDocNumber());
        logger.debug("Get To Transfer: {}", person.getIsAbleToTransfer());
        logger.debug("Get Country Code: {}", person.getCountryCode());
        return personService.savePerson(person);
    }

    @ApiOperation(value = "Listar al Registro persona usando entity")
    @ApiResponses(value = {@ApiResponse(code = 200, message = "OK")})
    @GetMapping("/ListarClientes")
    public Iterable<Person> ListPerson() {
        return personService.findAllPerson();
    }

}
