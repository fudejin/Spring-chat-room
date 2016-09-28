package org.projectsforge.whisperer.chatroom;

import java.util.List;

/**
 * The Interface ProductService.
 */
public interface ChatRoomService {

  /**
   * Adds the chatRoom
   *
   * @param name
   *          the name
   * @return the chatRoom
   */
  ChatRoom addChatRoom(String name);

  /**
   * Find by id.
   *
   * @param id
   *          the id
   * @return the ChatRoom
   */
 ChatRoom findById(Long id);

  /**
   * Find by name.
   *
   * @param name
   *          the name
   * @return the chatRoom
   */
 ChatRoom findByName(String name);

  /**
   * Gets the all chatRooms.
   *
   * @return the all chatRooms
   */
  List<ChatRoom> getAllChatRooms();

  /**
   * New chatRoom.
   *
   * @return the chatRoom
   */
  ChatRoom newChatRoom();

  /**
   * Removes the chatRoom.
   *
   * @param id
   *          the id
   */
  void removeChatRoom(Long id);

  /**
   * Save.
   *
   * @param chatRoom
   *          the chatRoom
   * @return the chatRoom
   */
  ChatRoom save(ChatRoom chatRoom);

}
