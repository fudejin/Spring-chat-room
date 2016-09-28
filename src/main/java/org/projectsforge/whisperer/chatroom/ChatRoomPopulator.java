package org.projectsforge.whisperer.chatroom;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * The Class ProductPopulator.
 */
@Component
class ChatRoomPopulator {

  /** The chatRoom service. */
  @Autowired
  private ChatRoomService chatRoomService;

  /**
   * Inits the.
   */
  @PostConstruct
  void init() {
    chatRoomService.addChatRoom("world");
    chatRoomService.addChatRoom("room1");
    chatRoomService.addChatRoom("room2");
    chatRoomService.addChatRoom("room3");
    chatRoomService.addChatRoom("room4");
    chatRoomService.addChatRoom("room5");
    chatRoomService.addChatRoom("room6");
    chatRoomService.addChatRoom("room7");
    chatRoomService.addChatRoom("room8");
    chatRoomService.addChatRoom("room9");
    chatRoomService.addChatRoom("room10");
  }
}
