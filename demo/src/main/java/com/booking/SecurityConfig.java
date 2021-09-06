package com.booking;



import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;

import com.booking.repositories.UserRepo;

import io.swagger.models.HttpMethod;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    // Details omitted for brevity
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		  auth.inMemoryAuthentication()
		  .withUser("salsabeel")
		  .password("{noop}sal@!@#@!")
		  .roles("admin")
		  .and()
		  .withUser("marah")
		  .password("{noop}mar@!@#@!")
		  .roles("user");


    // Used by spring security if CORS is enabled.
	}
	}