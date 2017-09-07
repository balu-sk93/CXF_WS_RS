package com.jax.service.implementation;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.google.common.collect.Lists;
import com.jax.model.Details;
import com.jax.repository.CrudUserService;
import com.jax.response.UserResponse;
import com.jax.service.serviceInterface.UserService;

/**
 * @author Balu S
 * @version 1.0.0.0
 * @since Sep 7, 2017
**/
public class UserServiceImpl implements UserService {
  
  private static Logger logger = Logger.getLogger(UserServiceImpl.class);
  
  @Autowired
  CrudUserService crudService;
  
  public UserResponse createUser(Details userDetails) {
    UserResponse response = new UserResponse();
    try {
      
      logger.info("Create User Service");
      Details user = new Details();
      user.setUsername(userDetails.getUsername());
      user.setPassword(userDetails.getPassword());
      crudService.save(user);
      logger.info("User Created Successfully");
      response.setStatus("SUCCESS");
      
    } catch (Exception e) {
      e.printStackTrace();
      response.setStatus("FAILED");
    }
    return response;
  }

  public UserResponse updateUser(Details userDetails) {
    UserResponse response = new UserResponse();
    try {
      
      logger.info("Update User Service");
      Details user = new Details();
      user.setUserid(userDetails.getUserid());
      user.setUsername(userDetails.getUsername());
      user.setPassword(userDetails.getPassword());
      crudService.save(user);
      logger.info("User Updated Successfully");
      response.setStatus("SUCCESS");
      
    } catch (Exception e) {
      e.printStackTrace();
      response.setStatus("FAILED");
    }
    return response;
  }

  public UserResponse deleteUser(String userid) {
    UserResponse response = new UserResponse();
    try {
      logger.info("Delete User Service, User Id : "+userid);
      if (userid.trim().equalsIgnoreCase(null) || userid.trim().equalsIgnoreCase("")) {
        response.setStatus("FAILURE");
        return response;
      }
      Details user = new Details();
      user.setUserid(userid);
      crudService.delete(user);
      logger.info("User "+userid+" Deleted Successfully");
      response.setStatus("SUCCESS");
      
    } catch (Exception e) {
      e.printStackTrace();
      response.setStatus("FAILED");
    }
    return response;
  }

  public UserResponse getUser(String  userid) {
    UserResponse response = new UserResponse();
    try {
      
      if (userid.trim().equalsIgnoreCase(null) || userid.trim().equalsIgnoreCase("")) {
        response.setStatus("FAILURE");
        return response;
      }
      
      logger.info("Get User Service ,User Id : "+userid);
      response.setUserDetails(Lists.newArrayList(crudService.findByUserid(userid)));
      logger.info("User "+userid+" Found Successfully");
      response.setStatus("SUCCESS");
      
    } catch (Exception e) {
      e.printStackTrace();
      response.setStatus("FAILED");
    }
    return response;
  }

  public UserResponse getUsers() {
    UserResponse response = new UserResponse();
    try {
      
      logger.info("Get Users Service");
      response.setUserDetails(Lists.newArrayList(crudService.findAll()));
      logger.info("All User Found Successfully");
      response.setStatus("SUCCESS");
      
    } catch (Exception e) {
      e.printStackTrace();
      response.setStatus("FAILED");
    }
    return response;
  }

  @Override
  public UserResponse getUserLogin(Details userDetails) {
    UserResponse response = new UserResponse();
    try {
      
      logger.info("Get User Login -> Username : "+userDetails.getUsername()+" Password : "+userDetails.getPassword());
      response.setUserDetails(crudService.findByUsernameAndPassword(userDetails.getUsername(), userDetails.getPassword()));
      if (response.getUserDetails().size() > 0) {
        logger.info("User Login Found Successfully");
        response.setStatus("SUCCESS");
      } else {
        logger.info("User Login Not Found");
        response.setStatus("FAILED");
      }
      
    } catch (Exception e) {
      e.printStackTrace();
      response.setStatus("FAILED");
    }
    return response;
  }

}
