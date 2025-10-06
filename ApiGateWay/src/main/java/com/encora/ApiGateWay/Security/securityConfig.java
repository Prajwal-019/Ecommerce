package com.encora.ApiGateWay.Security;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.core.userdetails.MapReactiveUserDetailsService;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.server.SecurityWebFilterChain;
import org.springframework.security.config.web.server.ServerHttpSecurity;

@Configuration
@EnableWebFluxSecurity
public class securityConfig {

    @Bean
    public MapReactiveUserDetailsService userDetailsService() {
        UserDetails admin = User
                .withUsername("admin")
                .password("{noop}adminpass")
                .roles("ADMIN")
                .build();

        UserDetails user = User
                .withUsername("user")
                .password("{noop}userpass")
                .roles("USER")
                .build();

        return new MapReactiveUserDetailsService(admin, user);
    }

    @Bean
    public SecurityWebFilterChain springSecurityFilterChain(ServerHttpSecurity http) {
        http
          .authorizeExchange(exchanges -> exchanges
            // public endpoints
            .pathMatchers("/actuator/**","/eureka/**","/swagger-ui/**","/v3/api-docs/**").permitAll()
            // product creation only admin
            .pathMatchers("/productservices/products/**").hasRole("ADMIN")
            .pathMatchers("/orderservice/orders/**").hasAnyRole("ADMIN","USER")
            .pathMatchers("/customerservice/**").hasAnyRole("ADMIN","USER")
            .anyExchange().authenticated()
          )
          .httpBasic(Customizer.withDefaults())
          .csrf(csrf -> csrf.disable());
        return http.build();
    }
}
