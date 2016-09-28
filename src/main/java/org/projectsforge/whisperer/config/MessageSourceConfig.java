package org.projectsforge.whisperer.config;

import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ResourceBundleMessageSource;

/**
 * Configure the message source.
 */
// declare the class as a configuration class
@Configuration
public class MessageSourceConfig {

  /**
   * Message source.
   *
   * @return the message source
   */
  @Bean
  public MessageSource messageSource() {
    ResourceBundleMessageSource messageSource = new ResourceBundleMessageSource();
    messageSource.setBasename("messages");
    return messageSource;
  }

}
