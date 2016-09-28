package org.projectsforge.whisperer.chatroom;

import org.projectsforge.whisperer.message.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

/**
 * The ChatRoom entity.
 */
@Entity
public class ChatRoom {

  /** The id. */
  @Id
  @GeneratedValue
  private Long id;

  /** The name. */
  @Column(unique = true)
  private String name;

  /**
   * Instantiates a new chatRoom
   */
  
  
  public ChatRoom() {
    // nothing to do
  }

  /**
   * Instantiates a new chatRoom.
   *
   * @param name
   *          the name
   * @param message
   * 		   the message
   */
  public ChatRoom(String name) {
    this.name = name;
  }

  /**
   * Gets the id.
   *
   * @return the id
   */
  public Long getId() {
    return id;
  }

  /**
   * Gets the name.
   *
   * @return the name
   */
  public String getName() {
    return name;
  }

  /**
   * Sets the id.
   *
   * @param id
   *          the new id
   */
  public void setId(Long id) {
    this.id = id;
  }

  /**
   * Sets the name.
   *
   * @param name
   *          the new name
   */
  public void setName(String name) {
    this.name = name;
  }


}
