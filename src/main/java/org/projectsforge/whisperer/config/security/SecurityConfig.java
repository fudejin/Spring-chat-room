package org.projectsforge.whisperer.config.security;

import org.projectsforge.whisperer.chatuser.ChatUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

/**
 * Configure Spring security.
 */
// declare the class as a configuration class
@Configuration
// enable spring security
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

	/** The chatUser service. */
	  @Autowired
	  private ChatUserService chatUserService;
	  
  /*
   * (non-Javadoc)
   *
   * @see org.springframework.security.config.annotation.web.configuration.
   * WebSecurityConfigurerAdapter#configure(org.springframework.security.config.
   * annotation.authentication.builders.AuthenticationManagerBuilder)
   */
  @Override
  protected void configure(AuthenticationManagerBuilder auth) throws Exception {
	// override the UserDetailsService
	auth.userDetailsService(new ChatUserDetailsService(chatUserService));
  }

  /*
   * (non-Javadoc)
   *
   * @see org.springframework.security.config.annotation.web.configuration.
   * WebSecurityConfigurerAdapter#configure(org.springframework.security.config.
   * annotation.web.builders.HttpSecurity)
   */
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    http.authorizeRequests()
    	// for matching URL, require ADMIN role
    	.antMatchers("/management/**", "/chatUser/**").hasAnyRole("ADMIN")
        // for all request, allow access
        .anyRequest().permitAll()
        // provide the login page
        .and().formLogin()
        // provide the logout page and redirect to / after logout
        .and().logout().logoutUrl("/")
        // allow HTTP basic authentification
        .and().httpBasic();
  }

}
