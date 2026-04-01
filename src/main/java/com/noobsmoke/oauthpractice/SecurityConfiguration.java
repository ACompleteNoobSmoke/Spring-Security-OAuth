package com.noobsmoke.oauthpractice;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity httpSecurity) {
        return httpSecurity
                .authorizeHttpRequests(authorizationManagerRequestMatcherRegistry ->
                authorizationManagerRequestMatcherRegistry.anyRequest().authenticated())
                .oauth2Login(Customizer.withDefaults())
                .build();
    }
}
