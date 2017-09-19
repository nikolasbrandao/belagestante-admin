package br.edu.ifma.corpsystem.gestanteadmin;


import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
@EnableWebSecurity
public class SecurityWebConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		  http.csrf().disable()
		    .authorizeRequests()
		        .antMatchers("/resources/**", "/webjars/**", "/css/**").permitAll()
		        .antMatchers("/dicasEditar", "/dicas/remover", 
		        		"/addDica", "/remover", "/usuarioEditar", 
		        		"/usuarioDeletar", "/addUsuario", "/relatorioUsuarios").hasRole("ADMIN")
		        .anyRequest().authenticated()
		    .and()
		    .formLogin()
		        .loginPage("/login").permitAll(); 
	}
	
	@Override
	public void configure(AuthenticationManagerBuilder builder) throws Exception {
		builder.inMemoryAuthentication()
		.withUser("admin").password("12345").roles("ADMIN")
		.and()
			.withUser("user").password("12345").roles("USER");
	}

}
