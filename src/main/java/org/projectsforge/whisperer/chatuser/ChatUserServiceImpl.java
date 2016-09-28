 package org.projectsforge.whisperer.chatuser;

import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.neo4j.cypher.internal.compiler.v2_2.perty.recipe.Pretty.listAppender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * The ChatUserService implementation.
 */
@Component
@Transactional
public class ChatUserServiceImpl implements ChatUserService {

	/** The repository. */
	  private ChatUserRepository repository;

	  /**
	   * Instantiates a new chatUser service implementation.
	   *
	   * @param repository
	   *          the repository
	   */
	  @Autowired
	  public ChatUserServiceImpl(ChatUserRepository repository) {
	    this.repository = repository;
	  }

	  /*
	   * (non-Javadoc)
	   * 
	   * @see
	   * org.projectsforge.whisper.chatuser.ChatUserService#addChatUser(java.lang.
	   * String, java.lang.String, boolean)
	   */
	@Override
	public ChatUser addChatUser(String name, String password, boolean admin) {
		return repository.save(new ChatUser(name, password, admin));
	}

	/*
	   * (non-Javadoc)
	   * 
	   * @see
	   * org.projectsforge.whisper.chatuser.ChatUserService#findById(java.lang.
	   * Long)
	   */
	@Override
	public ChatUser findById(Long id) {
		return repository.findOne(id);
	}

	/*
	   * (non-Javadoc)
	   * 
	   * @see
	   * org.projectsforge.whisper.chatuser.ChatUserService#findByName(java.lang.
	   * String)
	   */
	@Override
	public ChatUser findByName(String name) {
		return repository.findByName(name);
	}

	/*
	   * (non-Javadoc)
	   * 
	   * @see org.projectsforge.whisper.chatuser.ChatUserService#getAllChatUsers()
	   */
	@Override
	public List<ChatUser> getAllChatUsers() {
		return repository.findAll();
	}

	/*
	   * (non-Javadoc)
	   * 
	   * @see org.projectsforge.whisper.chatuser.ChatUserService#newChatUser()
	   */
	@Override
	public ChatUser newChatUser() {
		return new ChatUser();
	}

	/*
	   * (non-Javadoc)
	   * 
	   * @see
	   * org.projectsforge.whisper.chatuser.ChatUserService#removeChatUser(java.
	   * lang.Long)
	   */
	@Override
	public void removeChatUser(Long id) {
		   repository.delete(id);

	}

	 /*
	   * (non-Javadoc)
	   * 
	   * @see
	   * org.projectsforge.whisper.chatuser.ChatUserService#save(org.projectsforge.
	   * whisper.chatuser.ChatUser)
	   */
	@Override
	public ChatUser save(ChatUser chatUser) {
		return repository.save(chatUser);
	}

	@Override
	public List<String> getUsersByRoom(String RoomName) {
		List<String> listName=new ArrayList<>();
		for (ChatUser cu: repository.findAll()) {
			if(cu.getChatRoomName()!=null)
				if(cu.getChatRoomName().equals(RoomName))
					listName.add(cu.getName());
		}
		return listName;
	}

}
