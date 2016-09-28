package org.projectsforge.whisperer.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
@EnableWebMvc
public class FilterConfig extends WebMvcConfigurerAdapter 
{
  @Override
  public void addInterceptors(InterceptorRegistry registry) 
  {
    registry.addInterceptor(new FilterInterceptor());
  }
}
