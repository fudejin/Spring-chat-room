package org.projectsforge.whisperer;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.projectsforge.whisperer.WhispererApplication;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = WhispererApplication.class)
@WebAppConfiguration
public class WhispererApplicationTests {

  /** Test if the spring context can be loaded without issue. */
  @Test
  public void contextLoads() {
  }

}
