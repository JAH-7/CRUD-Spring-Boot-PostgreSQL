package pe.creativity.Restfull.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pe.creativity.Restfull.entity.Person;

import java.util.Optional;

@Repository
public interface PersonRepository extends CrudRepository<Person, Long> {

     Person save (Person PersonNew);

     Optional<Person> findById(Long id);

     Iterable<Person> findAll();

}
