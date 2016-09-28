package org.projectsforge.whisperer.chatroom;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * The Interface ChatRoomRepository.
 */
interface ChatRoomRepository extends JpaRepository<ChatRoom, Long> {

  /**
   * Find by name.
   *
   * @param name
   *          the name
   * @return the chatRoom
   */
  ChatRoom findByName(String name);

}
