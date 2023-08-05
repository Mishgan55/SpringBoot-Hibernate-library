package khorsun.hibernate.library.SpringBootHibernatelibrary.controllers;

import khorsun.hibernate.library.SpringBootHibernatelibrary.models.Person;
import khorsun.hibernate.library.SpringBootHibernatelibrary.services.SecurityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/auth")
public class RegistrationController {
    private final SecurityService securityService;
    @Autowired
    public RegistrationController(SecurityService securityService) {
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
    public String registration(@ModelAttribute("person")Person person){
        securityService.registrationPerson(person);
        return "redirect:/auth/login";
       }
}
