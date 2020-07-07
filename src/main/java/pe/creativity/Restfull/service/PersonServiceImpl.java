package pe.creativity.Restfull.service;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.creativity.Restfull.entity.Person;
import pe.creativity.Restfull.repository.PersonRepository;



@Service
public class PersonServiceImpl implements PersonService{

    @Autowired
    private PersonRepository personRepository;

    @Override
    public Iterable<Person> findAllPerson(){
        return personRepository.findAll();
    }

    @Override
    public Person savePerson(Person personNew){
        if (personNew != null){
            return personRepository.save(personNew);
        }
        return new Person();

    }



}
