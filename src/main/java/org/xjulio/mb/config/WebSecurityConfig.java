//package org.xjulio.mb.config;
//import javax.inject.Inject;
//
//import org.springframework.boot.autoconfigure.security.SecurityProperties;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//
///**
// * @author <a href="mailto:xjulio@gmail.com">Julio Cesar Damasceno</a>
// */
//@EnableWebSecurity
//@Configuration
//class WebSecurityConfig extends WebSecurityConfigurerAdapter {
//    @Inject private SecurityProperties securityProperties;
//    
//	@Override
//	protected void configure(HttpSecurity http) throws Exception {
//		http.authorizeRequests().anyRequest().permitAll().and().csrf().disable();
//		if (securityProperties.isRequireSsl()) {
//			http.requiresChannel().anyRequest().requiresSecure();
//		}
//		// http.authorizeRequests().anyRequest().fullyAuthenticated().and().httpBasic().and().csrf().disable();
//	}
//}
