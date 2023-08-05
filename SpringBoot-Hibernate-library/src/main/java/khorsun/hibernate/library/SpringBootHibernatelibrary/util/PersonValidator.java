package khorsun.hibernate.library.SpringBootHibernatelibrary.util;

import khorsun.hibernate.library.SpringBootHibernatelibrary.models.Person;
import khorsun.hibernate.library.SpringBootHibernatelibrary.services.PersonService;
import khorsun.hibernate.library.SpringBootHibernatelibrary.services.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
/*Class for checking name uniqueness*/
@Component
public class PersonValidator implements Validator {
    private final PersonService personService;

    @Autowired
    public PersonValidator(PersonService personService) {
        this.personService = personService;

    }

    @Override
    public boolean supports(Class<?> aClass) {
        return Person.class.equals(aClass);
    }

    @Override
    public void validate(Object o, Errors errors) {

        Person person=(Person) o;

        /*check if we already have a person with that login*/
        if(personService.findPersonByLogin(person.getLogin()).isPresent()){
            errors.rejectValue("login","", "This login is already exist");}



    }
}
