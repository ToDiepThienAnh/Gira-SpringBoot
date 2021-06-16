package cybersoft.backend.java11.gira.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import io.swagger.models.HttpMethod;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	private UserDetailsService userDetailService;
	
	@Bean
	public PasswordEncoder getPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailService)
							.passwordEncoder(getPasswordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		// enable cors
		http.cors();
		
		
		// disable csrf for development environment
		http.csrf();
		// config authentication for apis
		http.antMatcher("/api/**").authorizeRequests()
					.antMatchers("/swagger-ui.html").permitAll()
//					.antMatchers("/api/**").permitAll()
					.antMatchers("/role/**").authenticated()
					.anyRequest().authenticated();
		// make server stateless
		http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
	}
	
	
	
}
