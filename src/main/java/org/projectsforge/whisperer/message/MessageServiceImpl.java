package org.projectsforge.whisperer.message;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;

/**
 * The Class MessageServiceImpl.
 */
@Component
public class MessageServiceImpl implements MessageService {

	/** The repository. */
	  @Autowired
	  private MessageRepository repository;
	  
	  /*
	   * (non-Javadoc)
	   * 
	   * @see
	   * org.projectsforge.whisperer.message.MessageService#addMessage(java.lang.
	   * String, java.lang.String, java.lang.String)
	   */
	@Override
	public Message addMessage(String ipuser, String date, String msg, String chatRoomName) {
		return repository.save(new Message(ipuser, date,msg, chatRoomName));
	}

	/*
	   * (non-Javadoc)
	   * 
	   * @see
	   * org.projectsforge.whisperer.message.MessageService#findById(java.lang.Long)
	   */
	@Override
	public Message findById(Long id) {
		return repository.findOne(id);
	}

	/*
	   * (non-Javadoc)
	   * 
	   * @see
	   * org.projectsforge.whisperer.message.MessageService#findByIpuser(java.lang.
	   * String)
	   */
	@Override
	public Message findByIpuser(String ipuser) {
		return repository.findByIpuser(ipuser);
	}
	@Override
	public List<Message> findByChatRoomName(String chatRoomName) {
		return repository.findByChatRoomName(chatRoomName);
	}
	/*
	   * (non-Javadoc)
	   * 
	   * @see org.projectsforge.whisperer.message.MessageService#getAllMessages()
	   */
	@Override
	public List<Message> getAllMessages() {
		return repository.findAll();
	}

	/*
	   * (non-Javadoc)
	   * 
	   * @see org.projectsforge.whisperer.message.MessageService#newMessage()
	   */
	@Override
	public Message newMessage() {
		return new Message();
	}

	 /*
	   * (non-Javadoc)
	   * 
	   * @see
	   * org.projectsforge.whisperer.message.MessageService#save(org.projectsforge.
	   * whisperer.message.Message)
	   */
	@Override
	public Message save(Message message) {
		SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		message.setDate(df.format(new Date()));
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		
		if (auth != null) {
		   message.setIpuser(auth.getName());
		}else{
			message.setIpuser("Anonyme");
		}
		return repository.save(message);
	}

	@Override
	public List<Message> getMessagesByRoomName(String chatRoomName) {
		
		List<Message> listMasg=new ArrayList<>();
		for (Message message : repository.findAll()) {
			if(message.getChatRoomName().equals(chatRoomName))
				listMasg.add(message);
		}
		return listMasg;	}

	@Override
	public void deleteAll() {
		repository.deleteAll();
	}

}
