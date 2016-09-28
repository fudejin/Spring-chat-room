/**
 * 
 */
package org.projectsforge.whisperer.chatuser;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * A database populator for chatUser
 */
@Component
public class ChatUserPopulator {

	/** The chatUser service. */
	  @Autowired
	  private ChatUserService chatUserService;

	  /**
	   * Inits the database.
	   */
	  @PostConstruct
	  void init() {
	    chatUserService.addChatUser("admin", "password", true);
	    chatUserService.addChatUser("Bonnie Parket", "rowena", false);
	    chatUserService.addChatUser("Clyde Barrow", "telico", false);
	  }
}
