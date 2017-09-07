package com.jax.configurations;

import org.apache.cxf.Bus;
import org.apache.cxf.common.jaxb.JAXBContextCache;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxws.JaxWsServerFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.jax.service.implementation.UserServiceImpl;

/**
 * @author Balu S
 * @version 1.0.0.0
 * @since Sep 7, 2017
**/
@Configuration
public class SoapConfigurations {
  
  @Autowired
  private Bus bus;
  
  @Bean
  public UserServiceImpl getUserServiceImpl() {
    return new UserServiceImpl();
  }
  
  @Bean
  public String registerServices() {
    
    try {

      JAXBContextCache.clearCaches();
      
      register();
    } catch (Exception e) {
      e.printStackTrace();
    }
    
    return "SUCCESS";
  }
  
  public void register() throws Exception {

    JaxWsServerFactoryBean endpoint = null;
    try {
      
      LoggingInInterceptor loggingInInterceptor = new LoggingInInterceptor();
      loggingInInterceptor.setPrettyLogging(true);
      LoggingOutInterceptor loggingOutInterceptor = new LoggingOutInterceptor();
      loggingOutInterceptor.setPrettyLogging(true);

      endpoint = new JaxWsServerFactoryBean();
      endpoint.setBus(bus);
      endpoint.setServiceBean(getUserServiceImpl());
      endpoint.getInInterceptors().add(loggingInInterceptor);
      endpoint.getOutInterceptors().add(loggingOutInterceptor);
      endpoint.setAddress("/userService");
      endpoint.create();
      
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  
  
}
