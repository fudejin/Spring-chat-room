package org.projectsforge.whisperer.message;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {

	  /**
	   * Find by ipuser.
	   *
	   * @param ipuser
	   *          the ipuser
	   * @return the ipuser
	   */
	  Message findByIpuser(String ipuser);
	  List<Message> findByChatRoomName(String chatRoomName);

}
