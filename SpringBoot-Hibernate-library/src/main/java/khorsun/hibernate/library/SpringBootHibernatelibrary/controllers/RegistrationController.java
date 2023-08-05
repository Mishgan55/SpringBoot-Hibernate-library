package khorsun.hibernate.library.SpringBootHibernatelibrary.controllers;

import khorsun.hibernate.library.SpringBootHibernatelibrary.models.Person;
import khorsun.hibernate.library.SpringBootHibernatelibrary.services.SecurityService;
import khorsun.hibernate.library.SpringBootHibernatelibrary.util.PersonValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/auth")
public class RegistrationController {
    private final PersonValidator personValidator;
    private final SecurityService securityService;
    @Autowired
    public RegistrationController(PersonValidator personValidator, SecurityService securityService) {
        this.personValidator = personValidator;
        this.securityService = securityService;
    }

    @GetMapping("/login")
    public String login(){
           return "auth/login";
       }

       @GetMapping("/registration")
    public String formForRegistration(@ModelAttribute("person")Person person){

           return "auth/registration";
       }

       @PostMapping("/registration")
    public String registration(@ModelAttribute("person")@Valid Person person, BindingResult bindingResult){
        personValidator.validate(person,bindingResult);
        if (bindingResult.hasErrors()){
            return "auth/registration";}
        securityService.registrationPerson(person);
        return "redirect:/auth/login";
       }
}
