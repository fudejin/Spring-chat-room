package org.projectsforge.whisperer.config.security;

import java.util.ArrayList;
import java.util.List;

import org.projectsforge.whisperer.chatuser.ChatUser;
import org.projectsforge.whisperer.chatuser.ChatUserService;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

/**
 * Our UserDetailsService.
 */
public class ChatUserDetailsService implements UserDetailsService {

	/** The chatUser service. */
	  private ChatUserService chatUserService;

	  /**
	   * Instantiates a new chat user service.
	   *
	   * @param chatUserService
	   *          the chatUser service
	   */
	  public ChatUserDetailsService(ChatUserService chatUserService) {
			this.chatUserService = chatUserService;
		}
	  
	  /*
	   * (non-Javadoc)
	   *
	   * @see org.springframework.security.core.userdetails.UserDetailsService#
	   * loadUserByUsername(java.lang.String)
	   */
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// look up user
	    ChatUser chatUser = chatUserService.findByName(username);

	    if (chatUser != null) {
	      List<GrantedAuthority> authorities = new ArrayList<GrantedAuthority>();
	      // grant CHATUSER role to any chatUser
	      authorities.add(new SimpleGrantedAuthority("ROLE_CHATUSER"));
	      if (chatUser.isAdmin()) {
	        // grant ADMIN role to admin customer
	        authorities.add(new SimpleGrantedAuthority("ROLE_ADMIN"));
	      }
	      return new User(chatUser.getName(), chatUser.getPassword(), authorities);
	    }
	    throw new UsernameNotFoundException("User '" + username + "' not found.");
	}

	

}
