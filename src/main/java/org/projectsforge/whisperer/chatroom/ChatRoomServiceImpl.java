package org.projectsforge.whisperer.chatroom;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.google.inject.spi.Message;

/**
 * The Class ProductServiceImpl.
 */
@Component
public class ChatRoomServiceImpl implements ChatRoomService {

  /** The repository. */
  @Autowired
  private ChatRoomRepository repository;

  /*
   * (non-Javadoc)
   * 
   * @see
   * org.projectsforge.whisperer.chatroom.ChatRoomService#addChatRoom(java.lang.
   * String)
   */
  @Override
  public ChatRoom addChatRoom(String name) {
    return repository.save(new ChatRoom(name));
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * org.projectsforge.whisperer.chatroom.ChatRoomService#findById(java.lang.Long)
   */
  @Override
  public ChatRoom findById(Long id) {
    return repository.findOne(id);
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * org.projectsforge.whisperer.chatroom.ChatRoomService#findByName(java.lang.
   * String)
   */
  @Override
  public ChatRoom findByName(String name) {
    return repository.findByName(name);
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.projectsforge.whisperer.chatroom.ChatRoomService#getAllChatRooms()
   */
  @Override
  public List<ChatRoom> getAllChatRooms() {
    return repository.findAll();
  }

  /*
   * (non-Javadoc)
   * 
   * @see org.projectsforge.whisperer.chatroom.ChatRoomService#newChatRoom()
   */
  @Override
  public ChatRoom newChatRoom() {
    return new ChatRoom();
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * org.projectsforge.whisperer.chatroom.ChatRoomService#removeChatRoom(java.lang.
   * Long)
   */
  @Override
  public void removeChatRoom(Long id) {
    repository.delete(id);
  }

  /*
   * (non-Javadoc)
   * 
   * @see
   * org.projectsforge.whisperer.chatroom.ChatRoomService#save(org.projectsforge.
   * whisperer.chatroom.ChatRoom)
   */
  @Override
  public ChatRoom save(ChatRoom chatRoom) {
    return repository.save(chatRoom);
  }

}
