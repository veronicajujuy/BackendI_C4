package dh.backend.clinicamvc.configuration;

import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfiguration {
    private final AuthenticationProvider authenticationProvider;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        return http.authorizeHttpRequests(auth ->
                {
                    // Endpoints sin autenticación
                    auth.requestMatchers("/api/auth/**").permitAll();
                    auth.requestMatchers(HttpMethod.GET, "/odontologo/**").permitAll();

                    // Endpoints con roles específicos
                    auth.requestMatchers(HttpMethod.POST, "/odontologo/**").hasRole("ADMIN");
                    auth.requestMatchers(HttpMethod.PUT, "/odontologo/**").hasRole("ADMIN");
                    auth.requestMatchers(HttpMethod.DELETE, "/odontologo/**").hasRole("ADMIN");

                    auth.requestMatchers(HttpMethod.POST, "/paciente/**").hasRole("ADMIN");
                    auth.requestMatchers(HttpMethod.PUT, "/paciente/**").hasRole("ADMIN");
                    auth.requestMatchers(HttpMethod.DELETE, "/paciente/**").hasRole("ADMIN");

                    // Endpoints que requieren autenticación
                    auth.requestMatchers("/turno/**").authenticated();
                    auth.requestMatchers(HttpMethod.GET, "/paciente/**").authenticated();

                    // Cualquier otra solicitud debe estar autenticada
                    auth.anyRequest().authenticated();
                })
                .csrf(config -> config.disable()) // SOLO PARA THYMELEAF
                .sessionManagement(management -> management.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
                .authenticationProvider(authenticationProvider)
                .build();
    }
}
