package org.projectsforge.whisperer.message;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * The Message entity.
 */
@Entity
public class Message {

	/** The id. */
	  @Id
	  @GeneratedValue
	  private Long id;

	  /** The ipuser. */
	  private String ipuser;

	  /** The date. */
	  private String date;

	  /** The msg. */
	  private String msg;
	  
	  /** The chatRoomName.*/
	  private String chatRoomName;
	  
	  /**
	   * Instantiates a new message.
	   */
	  public Message() {
	    // nothing to do
	  }

	  /**
	   * Instantiates a new message.
	   *
	   * @param ipuser
	   *          the ipuser
	   * @param date
	   *          the date
	   * @param msg
	   *          the msg
	   * @param chatRoomName
	   * 		   the chatRoomName
	   */
	  Message(String ipuser, String date, String msg, String chatRoomName) {
	    this.ipuser = ipuser;
	    this.date = date;
	    this.msg = msg;
	    this.chatRoomName=chatRoomName;
	  }

	  /**
	   * Gets the chatRoomName.
	   *
	   * @return the chatRoomName
	   */
	  public String getChatRoomName() {
		return chatRoomName;
	}

	  /**
	   * Sets the chatRoomName.
	   *
	   * @param chatRoomName
	   *          the new chatRoomName
	   */  
	public void setChatRoomName(String chatRoomName) {
		this.chatRoomName = chatRoomName;
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
	   * Sets the id.
	   *
	   * @param id
	   *          the new id
	   */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	   * Gets the ipuser.
	   *
	   * @return the ipuser
	   */
	public String getIpuser() {
		return ipuser;
	}

	/**
	   * Sets the ipuser.
	   *
	   * @param ip
	   *          the new ip
	   */	
	public void setIpuser(String ipuser) {
		this.ipuser = ipuser;
	}

	/**
	   * Gets the date.
	   *
	   * @return the date
	   */
	public String getDate() {
		return date;
	}

	/**
	   * Sets the date.
	   *
	   * @param date
	   *          the new date
	   */
	public void setDate(String date) {
		this.date = date;
	}

	/**
	   * Gets the msg.
	   *
	   * @return the msg
	   */
	public String getMsg() {
		return msg;
	}

	/**
	   * Sets the msg.
	   *
	   * @param msg
	   *          the new msg
	   */
	public void setMsg(String msg) {
		this.msg = msg;
	}
	  
	  
}
