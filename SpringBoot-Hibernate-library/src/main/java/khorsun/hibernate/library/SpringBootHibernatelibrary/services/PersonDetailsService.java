package khorsun.hibernate.library.SpringBootHibernatelibrary.services;

import khorsun.hibernate.library.SpringBootHibernatelibrary.models.Person;
import khorsun.hibernate.library.SpringBootHibernatelibrary.repositories.PersonRepository;
import khorsun.hibernate.library.SpringBootHibernatelibrary.security.PersonDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PersonDetailsService implements UserDetailsService {
    private final PersonRepository personRepository;
    @Autowired
    public PersonDetailsService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<Person> personByLogin = personRepository.findPersonByLogin(username);
        if (personByLogin.isEmpty())
            throw new UsernameNotFoundException("Invalid Login");

        return new PersonDetails(personByLogin.get());
    }
}
