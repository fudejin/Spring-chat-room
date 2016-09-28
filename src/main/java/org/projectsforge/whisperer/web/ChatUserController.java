package org.projectsforge.whisperer.web;

import javax.validation.Valid;

import org.projectsforge.whisperer.chatuser.ChatUser;
import org.projectsforge.whisperer.chatuser.ChatUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//TODO: Auto-generated Javadoc
/**
* The Class ChatUserController.
*/
@Controller
@RequestMapping("/chatUser")
public class ChatUserController {

	 /** The chatUser service. */
	  @Autowired
	  private ChatUserService chatUserService;

	  /**
	   * ChatUser details.
	   *
	   * @param id
	   *          the id
	   * @param model
	   *          the model
	   * @return the string
	   */
	  @RequestMapping("/show/{id}")
	  public String chatUserDetails(@PathVariable("id") Long id, Model model) {
	    model.addAttribute("chatUser", chatUserService.findById(id));
	    return "chatUsers/show";
	  }

	  /**
	   * ChatUsers.
	   *
	   * @param model
	   *          the model
	   * @return the string
	   */
	  @RequestMapping("/show")
	  public String chatUsers(Model model) {
	    model.addAttribute("chatUsers", chatUserService.getAllChatUsers());
	    return "chatUsers/all";
	  }
  
	  /**
	   * Register.
	   *
	   * @param model
	   *          the model
	   * @return the string
	   */
	  // The GET method add an empty ChatUser in the model
	  @RequestMapping(value = "/register", method = RequestMethod.GET)
	  public String registerGet(Model model) {
	    model.addAttribute("chatUser", chatUserService.newChatUser());
	    return "chatUsers/register";
	  }

	  /**
	   * Register.
	   *
	   * @param chatUser
	   *          the chatUser
	   * @param errors
	   *          the errors
	   * @return the string
	   */
	  @RequestMapping(value = "/register", method = RequestMethod.POST)
	  // ChatUser has been populated with form field, Errors allows access to
	  // validation errors
	  public String registerPost(@Valid ChatUser chatUser, Errors errors) {

	    if (errors.hasErrors()) {
	      return "chatUsers/register";
	    }

	    try {
	      ChatUser savedChatUser = chatUserService.save(chatUser);
	      return "redirect:show/" + savedChatUser.getId();
	    } catch (DataIntegrityViolationException ex) {
	      errors.rejectValue("name", "chatUser.name.notuniq", "Name already registered");
	      return "chatUsers/register";
	    }
	  }
}
