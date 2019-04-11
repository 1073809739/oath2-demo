package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.authentication.BearerTokenExtractor;



@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
	
	@Override
	public void configure(ResourceServerSecurityConfigurer resources) {
		resources.tokenExtractor(new BearerTokenExtractor());
	}


	@Override
	public void configure(HttpSecurity http) throws Exception {
		//ResourceServer范围
		http.requestMatchers()
        .antMatchers("/indexB")
        .and()
		.authorizeRequests()
		.anyRequest().authenticated();
	}
}