package org.projectsforge.whisperer.web;

import javax.validation.Valid;

import org.projectsforge.whisperer.chatroom.ChatRoom;
import org.projectsforge.whisperer.chatroom.ChatRoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * The Class ChatRoomController.
 */
@Controller
@RequestMapping("/chatRoom")
public class ChatRoomController {

  /** The chatRoom service. */
  @Autowired
  private ChatRoomService chatRoomService;

  /**
   * ChatRoom details.
   *
   * @param id
   *          the id
   * @param model
   *          the model
   * @return the string
   */
  @RequestMapping("/show/{id}")
  public String chatRoomDetails(@PathVariable("id") Long id, Model model) {
    model.addAttribute("chatRoom", chatRoomService.findById(id));
    return "chatRooms/show";
  }

  /**
   * ChatRooms.
   *
   * @param model
   *          the model
   * @return the string
   */
  @RequestMapping("/show")
  public String chatRooms(Model model) {
    model.addAttribute("chatRooms", chatRoomService.getAllChatRooms());
    return "chatRooms/all";
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
    model.addAttribute("chatRoom", chatRoomService.newChatRoom());
    return "chatRooms/register";
  }

  /**
   * Register.
   *
   * @param chatRoom
   *          the chatRoom
   * @param errors
   *          the errors
   * @return the string
   */
  @RequestMapping(value = "/register", method = RequestMethod.POST)
  public String registerPost(@Valid ChatRoom chatRoom, Errors errors) {

    if (errors.hasErrors()) {
      return "chatRooms/register";
    }

    try {
      ChatRoom savedChatRoom = chatRoomService.save(chatRoom);
      return "redirect:show/" + savedChatRoom.getId();
    } catch (DataIntegrityViolationException ex) {
      errors.rejectValue("name", "chatRoom.name.notuniq", "Name already registered");
      return "chatRooms/register";
    }
  }

}
