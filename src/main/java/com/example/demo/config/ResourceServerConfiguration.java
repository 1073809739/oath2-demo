package com.example.demo.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.authentication.BearerTokenExtractor;

/**
 * 
 * @author cf
 * Description: 作为资源服务器的配置
 *
 */

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {
	
	@Override
	public void configure(ResourceServerSecurityConfigurer resources) {
		resources.tokenExtractor(new BearerTokenExtractor());
	}

	
	/**
	 * 作为资源服务器的安全配置，和webSecurity之间有个优先级关系。默认情况下如果同时使用了@EnableResourceServer和@EnableWebSecurity
	 * 优先是作为资源服务器。
	 */
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