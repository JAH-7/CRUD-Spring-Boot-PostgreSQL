package pe.creativity.Restfull.service;


import org.springframework.stereotype.Service;
import pe.creativity.Restfull.entity.Person;


public interface PersonService {

    public Iterable<Person> findAllPerson();

    public Person savePerson(Person personNew);
}
