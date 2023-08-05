package khorsun.hibernate.library.SpringBootHibernatelibrary.repositories;


import khorsun.hibernate.library.SpringBootHibernatelibrary.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface PersonRepository extends JpaRepository<Person,Integer> {
    Optional<Person> findPersonByFullName(String fullName);

    Optional<Person> findPersonByLogin(String login);
}
