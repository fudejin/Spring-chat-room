package org.projectsforge.whisperer.web;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.neo4j.cypher.internal.compiler.v2_2.ast.rewriters.nameAllPatternElements;
import org.projectsforge.whisperer.chatroom.ChatRoom;
import org.projectsforge.whisperer.chatroom.ChatRoomService;
import org.projectsforge.whisperer.chatuser.ChatUser;
import org.projectsforge.whisperer.chatuser.ChatUserService;
import org.projectsforge.whisperer.message.Message;
import org.projectsforge.whisperer.message.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import scala.collection.generic.BitOperations.Int;

/**
 * The Class MessageController.
 */
@Controller
@RequestMapping("/message")
public class MessageController {

	 /** The message service. */
	  @Autowired
	  private MessageService messageService;
	  @Autowired
	  private ChatRoomService chatRoomService;
	  @Autowired
	  private ChatUserService chatUserService;
	  /**
	   * Message details.
	   *
	   * @param id
	   *          the id
	   * @param model
	   *          the model
	   * @return the string
	   */
	  @RequestMapping("/show/{RoomId}")
	  public String productDetails(@PathVariable("RoomId") Long RoomId,@Valid Message message, Model model,HttpServletRequest request) {
		  
		  String  currentName;	  
		  try{
			    currentName=chatRoomService.findById(RoomId).getName();
		  }catch(Exception ex){
				 currentName="world";
		  }  	
			 if(currentName==null )
				 currentName="world";
			  List<Message> listMsg=new ArrayList<>();
		  String IsCommand=request.getAttribute("COMMAND").toString();
		  if(IsCommand=="NULL")
		  {
			 
				  if(message.getMsg()!=null&&!message.getMsg().equals("")){
					 message.setChatRoomName(currentName);
					  messageService.save(message);
				 }

		  }
		  else if(IsCommand=="CREATEUSER"){
			  String nameUser=request.getAttribute("name").toString();
			  String passWord=request.getAttribute("password").toString();
			  Authentication auth = SecurityContextHolder.getContext().getAuthentication();				
				if (auth == null||auth.getName().equals("anonymousUser")) {
					model.addAttribute("SysMsg", "Only admin can regist new user .");
				}else{
					try{
					String ssString=auth.getName();
					if(chatUserService.findByName(auth.getName()).isAdmin()){
						chatUserService.addChatUser(nameUser, passWord, false);
						model.addAttribute("SysMsg", "Successed in creating user .");
					}
					else
						model.addAttribute("SysMsg", "Only admin can regist new user .");
					}catch(Exception ex){
						model.addAttribute("SysMsg", "Password must be between 5 and 16 characters long.");
					}
				}

		  }
		  else if(IsCommand=="CURRENTTIME"){
			  //String currentTime=
				SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
				model.addAttribute("SysMsg", df.format(new Date()));
		  }
		  else if(IsCommand=="WHOAMI"){
			  Authentication auth = SecurityContextHolder.getContext().getAuthentication();				
				if (auth == null||auth.getName().equals("anonymousUser")) {
					model.addAttribute("SysMsg", "anonymousUser");
				}else{
				model.addAttribute("SysMsg", auth.getName());
				}
		  }
		  else if(IsCommand=="ROOMLIST"){
			  String listRoom="ChatRoom:";
			  for (ChatRoom cr : chatRoomService.getAllChatRooms()) {
				listRoom+=cr.getName()+"; ";
			}
				model.addAttribute("SysMsg", listRoom);			  
		  }	
		  else if(IsCommand=="HISTORY"){
			  int MaxNum= Integer.parseInt( request.getAttribute("n").toString());
			  if(messageService.getMessagesByRoomName(currentName).size()>MaxNum)
			  for(int i=messageService.getMessagesByRoomName(currentName).size();i>messageService.getMessagesByRoomName(currentName).size()-MaxNum;i--){
				  listMsg.add(messageService.getMessagesByRoomName(currentName).get(i-1));
			  }
				Collections.reverse(listMsg);
		  }	
		  else if(IsCommand=="HISTORYCLEAR"){
			  messageService.deleteAll();
		  }			
		  else if(IsCommand=="CREATEROOM"){
			  try{
					 Long swithroomid =chatRoomService.findByName(request.getAttribute("ROOMNAME").toString()).getId();
					model.addAttribute("SysMsg", "Room is exist.");				  	
			  }catch(Exception ex){
				  chatRoomService.addChatRoom(request.getAttribute("ROOMNAME").toString());
					 Long swithroomid =chatRoomService.findByName(request.getAttribute("ROOMNAME").toString()).getId();
					  String ur="redirect:"+swithroomid;
					  Authentication auth = SecurityContextHolder.getContext().getAuthentication();				
						if (auth == null||auth.getName().equals("anonymousUser")) {
						}else{
							chatUserService.findByName(auth.getName()).setChatRoomName(request.getAttribute("ROOMNAME").toString());
						}
					  return ur;
			  }
		  }		
		  else if(IsCommand=="SWITCHROOM"){
			  try{
					 Long swithroomid =chatRoomService.findByName(request.getAttribute("ROOMNAME").toString()).getId();
					  String ur="redirect:"+swithroomid;
					  Authentication auth = SecurityContextHolder.getContext().getAuthentication();				
						if (auth == null||auth.getName().equals("anonymousUser")) {
						}else{
							chatUserService.findByName(auth.getName()).setChatRoomName(request.getAttribute("ROOMNAME").toString());
						}
					  return ur;
			  }catch(Exception ex){
					model.addAttribute("SysMsg", "Room not exist.");
			  }
		  }		
		  else if(IsCommand=="LASTSEEN"){
			  if(messageService.getAllMessages().size()>=1){
				  List<Message> lMessages=messageService.getAllMessages();
				  Collections.reverse(lMessages);
				  for (Message message2 : lMessages) {
					  Boolean isE=false;
					if(message2.getIpuser().equals(request.getAttribute("NAME"))){
						isE=true;
						model.addAttribute("SysMsg", message2.getIpuser()+":"+message2.getDate()+"("+message2.getDate()+")");
						break;
						}
					if(!isE)
						model.addAttribute("SysMsg", "No result.");
					}				
			  }		 
			  else{
					model.addAttribute("SysMsg", "No result.");}
			  }

		  	model.addAttribute("room",currentName );
		  	model.addAttribute("userRoomList",chatUserService.getUsersByRoom(currentName));
		  	if(listMsg.size()!=0)
		    model.addAttribute("messages", listMsg);
		  	else
			 model.addAttribute("messages", messageService.getMessagesByRoomName(currentName));
		    model.addAttribute("message", messageService.newMessage());
	    return "messages/all";
	  }

	  /**
	   * Messages.
	   *
	   * @param model
	   *          the model
	   * @return the string
	   */
	  @RequestMapping("/show")
	  public String messages(@Valid Message message,Model model) {
			 if(message.getMsg()!=null)
				  messageService.save(message);
			  Authentication auth = SecurityContextHolder.getContext().getAuthentication();				
				if (auth == null||auth.getName().equals("anonymousUser")) {
				}else{
					chatUserService.findByName(auth.getName()).setChatRoomName("world");
				}
		    model.addAttribute("messages", messageService.getAllMessages());
		    model.addAttribute("message", messageService.newMessage());
	    return "redirect:/message/show/1";
	  }

	  /**
	   * Register.
	   *
	   * @param model
	   *          the model
	   * @return the string
	   */
	  @RequestMapping(value = "/register", method = RequestMethod.GET)
	  public String registerGet(Model model) {
	    model.addAttribute("message", messageService.newMessage());
	    return "messages/register";
	  }

	  /**
	   * Register.
	   *
	   * @param message
	   *          the message
	   * @param errors
	   *          the errors
	   * @return the string
	   */
	  @RequestMapping(value = "/register", method = RequestMethod.POST)
	  public String registerPost(@Valid Message message, Errors errors) {

	    if (errors.hasErrors()) {
	      return "messages/register";
	    }
	      Message savedMessage = messageService.save(message);
	      return "messages/all";
	    
	  }
}
