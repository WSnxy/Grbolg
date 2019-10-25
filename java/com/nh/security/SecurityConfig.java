package com.nh.security;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	@Autowired
	UserDetailsServiceImpl userDetailsService;
   
	@Autowired
	private DataSource dataSource;
	
//	认证管理
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService).passwordEncoder(new BCryptPasswordEncoder());
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.formLogin().loginPage("/userLogin")
		.defaultSuccessUrl("/grbolg/manage")
		.loginProcessingUrl("/login")
		.and()
		.rememberMe()
		.userDetailsService(userDetailsService)
		.tokenRepository(tokenRepository())
		.tokenValiditySeconds(3600 * 24 * 7)  //一周
		.and()
		.csrf().disable()
		.authorizeRequests()
		.antMatchers("/userLogin").permitAll() //允许登录界面直接访问
		.antMatchers("/grbolg/manage/**","/management.html").authenticated();

	}

	   @Bean
	    public PersistentTokenRepository tokenRepository() {
	        JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
	        tokenRepository.setDataSource(dataSource);
//	         tokenRepository.setCreateTableOnStartup(true); 
	        return tokenRepository;
	    }
}
