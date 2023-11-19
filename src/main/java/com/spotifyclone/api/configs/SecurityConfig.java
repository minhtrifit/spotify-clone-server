package com.spotifyclone.api.configs;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.spotifyclone.api.filters.JwtAuthFilter;
import com.spotifyclone.api.services.UserService;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity
public class SecurityConfig {
    @Autowired
    private AuthEntryPointJwt unauthorizedHandler;

    @Autowired
    private JwtAuthFilter authFilter; 
  
    // User Creation 
    @Bean
    public UserDetailsService userDetailsService() { 
        return new UserService(); 
    } 

    @Bean
    public PasswordEncoder passwordEncoder() { 
        return new BCryptPasswordEncoder(); 
    }

    @Bean
    public AuthenticationProvider authenticationProvider() { 
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider(); 
        authenticationProvider.setUserDetailsService(userDetailsService()); 
        authenticationProvider.setPasswordEncoder(passwordEncoder()); 
        return authenticationProvider; 
    } 
  
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration config) throws Exception { 
        return config.getAuthenticationManager(); 
    } 

    // Configuring HttpSecurity 
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http.csrf(csrf -> csrf.disable())
            .exceptionHandling(exception -> exception.authenticationEntryPoint(unauthorizedHandler))
            .sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
            .authorizeHttpRequests(auth -> 
            auth.requestMatchers("/**").permitAll()
                .requestMatchers("/api/v1/audios", "api/v1/artists", "api/v1/albums").permitAll()
                 .requestMatchers("/upload/**").permitAll()
                .requestMatchers("/auth", "/auth/all", "/auth/register", "/auth/login").permitAll()
                .requestMatchers("/auth/profile").authenticated()
                .requestMatchers("/auth/refresh").authenticated()
                .requestMatchers("/auth/user/**").authenticated()
                .requestMatchers("/auth/admin/**").authenticated()
                .requestMatchers("/api/v1/add/audio", "/api/v1/delete/audio/**").authenticated()
                .requestMatchers("/api/v1/add/album", "/api/v1/edit/album", "/api/v1/delete/album/**").authenticated()
                .requestMatchers("/api/v1/add/playlist", "/api/v1/edit/playlist", "/api/v1/delete/playlist/**").authenticated()
                .requestMatchers("/error").permitAll()
                .anyRequest().authenticated()
            );
        
        // fix H2 database console: Refused to display ' in a frame because it set 'X-Frame-Options' to 'deny'
        http.headers(headers -> headers.frameOptions(frameOption -> frameOption.sameOrigin()));
        
        http.authenticationProvider(authenticationProvider());

        http.addFilterBefore(authFilter, UsernamePasswordAuthenticationFilter.class);
        
        return http.build();
    }
}
