package org.projectsforge.whisperer.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * The Class HomeController.
 */
@Controller
public class HomeController {

	/**
	 * Home.
	 *
	 * @return the string
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		return "home";

	}
	  @RequestMapping(value="/logout",method = RequestMethod.GET)
	  public String chatUsersLogout() {
	    return "redirect:/login";
	  }
}
