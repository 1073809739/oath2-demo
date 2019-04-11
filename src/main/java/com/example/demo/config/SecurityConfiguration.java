package com.example.demo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter{

	/**
	   * 配置这个bean会在做AuthorizationServerConfigurer配置的时候使用
	   * @return
	   * @throws Exception
	   */
	  @Bean
	  @Override
	  public AuthenticationManager authenticationManagerBean() throws Exception {
	    return super.authenticationManagerBean();
	  }

	  /**
	   * 配置用户
	   * 使用内存中的用户，实际项目中，一般使用的是数据库保存用户，具体的实现类可以使用JdbcDaoImpl或者JdbcUserDetailsManager
	   * @return
	   */
	  @Bean
	  @Override
	  protected UserDetailsService userDetailsService() {
	    InMemoryUserDetailsManager manager = new InMemoryUserDetailsManager();
	    manager.createUser(User.withUsername("admin").password(PasswordEncoderFactories.createDelegatingPasswordEncoder().encode("admin")).authorities("USER").build());
	    return manager;
	  }

	@Override
	public void configure(HttpSecurity http) throws Exception {
		http.requestMatchers()
		//WebSecurity过滤范围
        .antMatchers("/indexA","/login","/oauth/authorize")
        .and()
		.authorizeRequests()
		.anyRequest().authenticated()
		.and()
		.formLogin().and()
		.httpBasic();
	}
	  
   
}