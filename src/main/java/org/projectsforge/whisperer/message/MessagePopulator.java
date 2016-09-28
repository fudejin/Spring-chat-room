package org.projectsforge.whisperer.message;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * The Class MessagePopulator.
 */
@Component
public class MessagePopulator {

	  /** The message service. */
	  @Autowired
	  private MessageService messageService;

	  /**
	   * Inits the.
	   */
	  @PostConstruct
	  void init() {
	    messageService.addMessage("Server", "2016-03-02 00:00:00", "Hello, world !","world");
	  }
}
