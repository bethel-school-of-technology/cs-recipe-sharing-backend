package com.recipeshare;

import static com.recipeshare.auth.AuthorizationConstants.SIGN_UP_URL;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.recipeshare.auth.JWTAuthentication;
import com.recipeshare.auth.JWTAuthorization;
import com.recipeshare.auth.SqlUserDetailsService;


@Configuration
@EnableWebSecurity
public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
	
	@Autowired
	private SqlUserDetailsService userDetailsService;
	
	@Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
	
	@Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth
         .userDetailsService(userDetailsService)
         .passwordEncoder(passwordEncoder());
    }
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors()
	      .and()
	      .csrf().disable()
	      .authorizeRequests().antMatchers(HttpMethod.POST, SIGN_UP_URL).permitAll()
		  .antMatchers(HttpMethod.GET, "/api/recipe/*").permitAll()
		  .antMatchers(HttpMethod.GET, "/api/recipe/images/*").permitAll()
	      .anyRequest().authenticated()
	      .and()
	      .addFilter(new JWTAuthentication(authenticationManager()))
	      .addFilter(new JWTAuthorization(authenticationManager()))
	      .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	  }
	
	@Bean
	  CorsConfigurationSource corsConfigurationSource() {
	    final UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
	    CorsConfiguration corsConfig = new CorsConfiguration();
	    corsConfig.applyPermitDefaultValues();
	    corsConfig.setExposedHeaders(Arrays.asList("Authorization"));
	    corsConfig.addAllowedOrigin("*");
	    corsConfig.addAllowedMethod(HttpMethod.DELETE);
	    corsConfig.addAllowedMethod(HttpMethod.PUT);
	    source.registerCorsConfiguration("/**", corsConfig);
	    return source;
	  }

}
