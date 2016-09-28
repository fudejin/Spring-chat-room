package org.projectsforge.whisperer.chatuser;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The Spring data repository (It's like magic but better).
 */
public interface ChatUserRepository extends JpaRepository<ChatUser, Long> {

	/**
	   * Find a chatUser by name.
	   *
	   * @param name
	   *          the name
	   * @return the chatUser
	   */
	  ChatUser findByName(String name);

}
