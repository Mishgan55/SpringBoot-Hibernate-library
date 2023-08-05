package khorsun.hibernate.library.SpringBootHibernatelibrary.services;

import khorsun.hibernate.library.SpringBootHibernatelibrary.models.Person;
import khorsun.hibernate.library.SpringBootHibernatelibrary.repositories.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class SecurityService {

private final PersonRepository personRepository;

private final PasswordEncoder passwordEncoder;
    @Autowired
    public SecurityService(PersonRepository personRepository, PasswordEncoder passwordEncoder) {
        this.personRepository = personRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registrationPerson(Person person){
        person.setPassword(passwordEncoder.encode(person.getPassword()));
        personRepository.save(person);
    }
}
