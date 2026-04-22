package dgtic.core.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        // 1. Permitir acceso libre a recursos estáticos (Punto 9c del PDF)
                        .requestMatchers("/css/**", "/js/**", "/libs/**", "/image/**", "/imagenes/**").permitAll()
                        // 2. Proteger todas las demás rutas (Punto 9d del PDF)
                        .anyRequest().authenticated()
                )
                .formLogin(login -> login
                        // 3. Definir tu login personalizado (Punto 9a del PDF)
                        .loginPage("/login")
                        // Le decimos a Spring que tu campo en HTML se llama "email" y no "username"
                        .usernameParameter("email")
                        .passwordParameter("password")
                        // Redirigir a tu página principal tras un login exitoso
                        .defaultSuccessUrl("/principal", true)
                        .permitAll()
                )
                .logout(logout -> logout
                        // 4. Configurar el logout (Punto 9b del PDF)
                        .logoutUrl("/logout")
                        .logoutSuccessUrl("/login?logout")
                        .permitAll()
                );

        return http.build();
    }

    @Bean
    public UserDetailsService userDetailsService() {
        // 5. Usuarios In-Memory (Punto 9e del PDF)
        UserDetails admin = User.withDefaultPasswordEncoder()
                .username("admin@escured.com")
                .password("12345")
                .roles("ADMIN")
                .build();

        UserDetails alumno = User.withDefaultPasswordEncoder()
                .username("alumno@escured.com")
                .password("12345")
                .roles("ALUMNO")
                .build();

        return new InMemoryUserDetailsManager(admin, alumno);
    }
}