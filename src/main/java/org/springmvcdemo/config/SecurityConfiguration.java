package org.springmvcdemo.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userService;

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.authorizeRequests().antMatchers("/login", "/home", "/customer/showForm", "/customer/saveCustomer")
				.permitAll().antMatchers("/loan/showForm", "/loan/saveLoan").hasAuthority("USER")
				.antMatchers("/loan/listLoan").hasAuthority("ADMIN")
				.antMatchers("/customer-profile/showForm", "/customer-profile/saveCustomerProfile").hasAuthority("USER")
				.and().formLogin().and().logout().permitAll().and().exceptionHandling().accessDeniedPage("/403");

	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userService);

	}

}