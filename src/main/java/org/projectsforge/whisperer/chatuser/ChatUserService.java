package org.projectsforge.whisperer.chatuser;

import java.util.List;

/**
 * The ChatUserService interface.
 */
public interface ChatUserService {

	  /**
	   * Adds the chatUser.
	   *
	   * @param name
	   *          the name
	   * @param password
	   *          the password
	   * @param admin
	   *          the admin
	   * @return the chatUser
	   */
	  ChatUser addChatUser(String name, String password, boolean admin);

	  /**
	   * Find a chatUser by id.
	   *
	   * @param id
	   *          the id
	   * @return the chatUser
	   */
	  ChatUser findById(Long id);

	  /**
	   * Find a chatUser by name.
	   *
	   * @param name
	   *          the name
	   * @return the chatUser
	   */
	  ChatUser findByName(String name);

	  /**
	   * Gets all the chatUsers.
	   *
	   * @return the all chatUsers
	   */
	  List<ChatUser> getAllChatUsers();

	  /**
	   * New chatUser.
	   *
	   * @return the chatUser
	   */
	  ChatUser newChatUser();

	  /**
	   * Removes the chatUser.
	   *
	   * @param id
	   *          the id
	   */
	  void removeChatUser(Long id);

	  /**
	   * Saves a chatUser.
	   *
	   * @param chatUser
	   *          the chatUser
	   * @return the chatUser
	   */
	  ChatUser save(ChatUser chatUser);
	  List<String> getUsersByRoom(String RoomName);
}
