package com.anthony.saml2okta.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import static org.springframework.security.config.Customizer.withDefaults;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
/**
 * we are configuring web-based security for http requests. In this example, we are simply
 * authorizing any user to issue any request if the user is authenticated by a SAML 2.0
 * Service Provider.via SAML.
 */
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .anyRequest().authenticated()
                .and()
                .saml2Login(withDefaults());

        // /future role-based authorization might be done like this:
        // http.authorizeRequests().antMatchers("/**").hasRole("LOAN_APPROVER")

    }

}
