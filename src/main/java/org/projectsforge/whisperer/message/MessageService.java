package org.projectsforge.whisperer.message;

import java.util.List;

public interface MessageService {

	  /**
	   * Adds the message.
	   *
	   * @param ipuser
	   *          the ipuser
	   * @param date
	   *          the date
	   * @param msg
	   *         the  msg
	   * @param chatRoomName
	   *         the  chatRoomName 
	   * @return the message
	   */
	  Message addMessage(String ipuser, String date, String msg, String chatRoomName);

	  /**
	   * Find by id.
	   *
	   * @param id
	   *          the id
	   * @return the message
	   */
	 Message findById(Long id);

	  /**
	   * Find by ipuser.
	   *
	   * @param ipuser
	   *          the ipuser
	   * @return the message
	   */
	  Message findByIpuser(String ipuser);
	  List<Message> findByChatRoomName(String chatRoomName);

	  /**
	   * Gets the all meaasge.
	   *
	   * @return the all message
	   */
	  List<Message> getAllMessages();
	  List<Message> getMessagesByRoomName(String chatRoomName);
	  void deleteAll();
	  /**
	   * New message.
	   *
	   * @return the message
	   */
	  Message newMessage();

	  /**
	   * Save.
	   *
	   * @param message
	   *          the message
	   * @return the message
	   */
	  Message save(Message message);
}
