package edu.unam.spring_security_101.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

import java.util.Collections;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

        /*
        http
        //autorizar mis ENDPOINTS
        //metiendo seguridad a nivel de endpoint
        .authorizeHttpRequests(
            (authorize) -> authorize
                .requestMatchers("/auth/welcome").authenticated()
                // para cualquier endpoint
                //.requestMatchers("/auth/**").authenticated() PARA QUE TODOS SEAN AUTENTICADOS
                .anyRequest().denyAll() //ES ZERO TRUST FUERTE
        )
        .httpBasic(Customizer.withDefaults())
        .formLogin(Customizer.withDefaults());
         */

        http
                //autorizar mis ENDPOINTS
                //metiendo seguridad a nivel endpoint
                .authorizeHttpRequests((authorize) -> authorize
                        //para cualquier endpoint
                        //.requestMatchers("/auth/**").authenticated()
                        .anyRequest().authenticated()
                )
                .httpBasic(Customizer.withDefaults())
                .formLogin(Customizer.withDefaults());

        return http.build();

    }

    @Bean
    public UserDetailsService userDetailsService() {

        // Escuela (junior)
        UserDetails userDetails = new User(
                "josolmedo",
                "Angel.2020",
                true,
                true,
                true,
                true,
                Collections.singletonList(new SimpleGrantedAuthority("Admin"))
        );

        InMemoryUserDetailsManager userDetailsManager = new InMemoryUserDetailsManager();

        // Builder de la clase User.
        UserDetails userDetails2 = User.withDefaultPasswordEncoder()
                .username("Wilson")
                .password("Wilson.2020") // ¿está codificado?
                .build();

        return new InMemoryUserDetailsManager(userDetails, userDetails2);
    }





}
