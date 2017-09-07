package com.jax.configurations;

import java.util.Arrays;

import org.apache.cxf.Bus;
import org.apache.cxf.endpoint.Server;
import org.apache.cxf.interceptor.LoggingInInterceptor;
import org.apache.cxf.interceptor.LoggingOutInterceptor;
import org.apache.cxf.jaxrs.JAXRSServerFactoryBean;
import org.apache.cxf.jaxrs.provider.JAXBElementProvider;
import org.apache.cxf.jaxrs.swagger.Swagger2Feature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import com.jax.service.implementation.UserServiceImpl;

/**
 * @author Balu S
 * @version 1.0.0.0
 * @since Sep 7, 2017
**/
@Configuration
public class RestConfiguration {

  @Autowired
  private Bus bus;
  
  @Bean
  public JacksonJaxbJsonProvider jacksonJaxbJsonProvider() {
      return new JacksonJaxbJsonProvider();
  }

  @SuppressWarnings("rawtypes")
  @Bean
  public JAXBElementProvider jaxbElementProvider() {
      return new JAXBElementProvider();
  }
  
  @Bean
  public UserServiceImpl getUserServiceImpl() {
    return new UserServiceImpl();
  }
  
  @Bean
  public Swagger2Feature getSwagger2Feature() {
    Swagger2Feature swagger2Feature = null;
    try {
      
      swagger2Feature = new Swagger2Feature();
      swagger2Feature.setTitle("CXF Rest Services");
      swagger2Feature.setDescription("Rest Services");
      swagger2Feature.setPrettyPrint(true);
      swagger2Feature.setVersion("v1.0.0");
      swagger2Feature.setContact("Contact");
      
    } catch (Exception e) {
      e.printStackTrace();
    }
    return swagger2Feature;
  }
  
  @Bean
  public Server rsServer() {

    JAXRSServerFactoryBean endpoint = null;
    try {
      endpoint = new JAXRSServerFactoryBean();
      endpoint.setBus(bus);
      endpoint.setAddress("/rest");
      endpoint.setServiceBeans(Arrays.<Object> asList(getUserServiceImpl()));
      endpoint.setProviders(Arrays.asList(jacksonJaxbJsonProvider(), jaxbElementProvider()));
      endpoint.setFeatures(Arrays.asList(getSwagger2Feature()));
      endpoint.getInInterceptors().add(new LoggingInInterceptor());
      endpoint.getOutInterceptors().add(new LoggingOutInterceptor());
    } catch (Exception e) {
      e.printStackTrace();
    }
    return endpoint.create();
  }
  
}
