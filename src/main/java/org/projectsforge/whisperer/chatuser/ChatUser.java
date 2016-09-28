package org.projectsforge.whisperer.chatuser;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 * The ChatUser entity.
 */
@Entity
public class ChatUser {

	/** The id. */
	@Id
	@GeneratedValue
	private Long id;

	/** The name. */
	// database constraint
	@Column(unique = true)
	// validation constraint (see @Valid in controller)
	@NotNull
	@Size(min = 1, max = 30, message = "{name.size}")
	private String name;

	/** The password. */
	// validation constraint (see @Valid in controller)
	@NotNull
	@Size(min = 5, max = 16, message = "{password.size}")
	private String password;
	
	private String chatRoomName;

	public String getChatRoomName() {
		return chatRoomName;
	}

	public void setChatRoomName(String chatRoomName) {
		this.chatRoomName = chatRoomName;
	}

	/** The admin. */
	private boolean admin;

	ChatUser() {
		// nothing to do
	}

	/**
	 * Instantiates a new chatUser.
	 *
	 * @param name
	 *            the name
	 * @param password
	 *            the password
	 * @param admin
	 *            the admin
	 */
	ChatUser(String name, String password, boolean admin) {
		this.name = name;
		this.password = password;
		this.admin = admin;
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
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Checks if is admin.
	 *
	 * @return true, if is admin
	 */
	public boolean isAdmin() {
		return admin;
	}

	/**
	 * Sets the admin.
	 *
	 * @param admin
	 *            the new admin
	 */
	public void setAdmin(boolean admin) {
		this.admin = admin;
	}

	/**
	 * Sets the id.
	 *
	 * @param id
	 *            the new id
	 */
	public void setId(Long id) {
		this.id = id;
	}

	/**
	 * Sets the name.
	 *
	 * @param name
	 *            the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Sets the password.
	 *
	 * @param password
	 *            the new password
	 */
	public void setPassword(String password) {
		this.password = password;
	}
}
