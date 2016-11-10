package com.atarwa.blma.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.authentication.encoding.ShaPasswordEncoder;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true)
@ComponentScan(value = "com.atarwa.blma.config")
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {
	@Autowired
    @Qualifier("customUserDetailsService")
    UserDetailsService userDetailsService;
	
	@Autowired
    private HttpAuthenticationEntryPoint authenticationEntryPoint;
    @Autowired
    private AuthSuccessHandler authSuccessHandler;
    @Autowired
    private AuthFailureHandler authFailureHandler;
    @Autowired
    private HttpLogoutSuccessHandler logoutSuccessHandler;

    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Bean
    @Override
    public UserDetailsService userDetailsServiceBean() throws Exception {
        return super.userDetailsServiceBean();
    }

    @Bean
    public AuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authenticationProvider = new DaoAuthenticationProvider();
        authenticationProvider.setUserDetailsService(userDetailsService);
        authenticationProvider.setPasswordEncoder(new ShaPasswordEncoder());
        return authenticationProvider;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.authenticationProvider(authenticationProvider());
    }

    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }
     
    @Override
    protected void configure(HttpSecurity http) throws Exception {

      http.csrf().disable()
      .authorizeRequests()
      .antMatchers("/").permitAll()
      .antMatchers("/login").access("hasAnyRole('USER', 'ADMIN')")
      .antMatchers("/role/user/**").access("hasRole('USER')")
      .antMatchers("/role/admin/**").access("hasRole('ADMIN')")
      .antMatchers("/role/**").access("hasAnyRole('USER', 'ADMIN')")
      .anyRequest().authenticated()
      .and()
      .authenticationProvider(authenticationProvider())
      .exceptionHandling()
      .authenticationEntryPoint(authenticationEntryPoint)
      .and()
      .formLogin()
      .permitAll()
      .loginProcessingUrl("/login")
      .usernameParameter("username")
      .passwordParameter("password")
      .successHandler(authSuccessHandler)
      .failureHandler(authFailureHandler)
      .and()
      .logout()
      .permitAll()
      .logoutRequestMatcher(new AntPathRequestMatcher("/logout", "DELETE"))
      .logoutSuccessHandler(logoutSuccessHandler)
      .and()
      .sessionManagement()
      .maximumSessions(1);
    }
}
