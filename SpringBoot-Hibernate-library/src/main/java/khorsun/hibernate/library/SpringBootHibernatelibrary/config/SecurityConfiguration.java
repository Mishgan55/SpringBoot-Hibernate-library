package khorsun.hibernate.library.SpringBootHibernatelibrary.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration)
            throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .authorizeRequests()// не аутефицированный пользователь
                .antMatchers("/auth/login","/auth/registration","/error").permitAll()// пускаем его на эту страницу
                .anyRequest().authenticated()//для всех других запросов пользователь должен быть аутенфицирован
                .and()
                .formLogin() // форма для логина
                .loginPage("/auth/login")// по какой ссылке переходим
                .loginProcessingUrl("/process_login")// указываем на какую сслыку переходим при сабмите формы
                .defaultSuccessUrl("/people",true)//после успешной аунтефикации перенапрваление на страницу
                .failureUrl("/auth/login?error")
                .and()
                .logout()
                .logoutUrl("/logout")
                .logoutSuccessUrl("/auth/login");// при неудачной попытке входа

        return http.build();
    }

    @Bean
    public PasswordEncoder getPasswordEncoder(){
        return new BCryptPasswordEncoder();
    }
}
