package pe.creativity.Restfull.service;

import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import pe.creativity.Restfull.entity.Person;
import pe.creativity.Restfull.repository.PersonRepository;

import java.util.List;

@Component
public class PersonServiceImpl implements PersonService{

    @Autowired
    private PersonRepository personRepository;

    private static final Log logger = LogFactory.getLog(PersonServiceImpl.class);

    @Override
    public Iterable<Person> findAllPerson(){
        return personRepository.findAll();
    }

    @Override
    public Person savePerson(Person personNew){
        logger.info("Creando un nuevo usuario");
//        logger.info(personNew.getPerson_id());
//        logger.info(personNew.getFirst_name());
//        logger.info(personNew.getLast_name());
//        logger.info(personNew.getPhone());
//        logger.info(personNew.getEmail());
//        logger.info(personNew.getDoc_type());
//        logger.info(personNew.getDoc_number());
//        logger.info(personNew.getIs_able_to_transfer());
//        logger.info(personNew.getCountry_code());
        if (personNew != null){
            return personRepository.save(personNew);
        }
        return new Person();

    }



}
