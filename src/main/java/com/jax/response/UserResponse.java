package com.jax.response;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.jax.model.Details;

/**
 * @author Balu S
 * @version 1.0.0.0
 * @since Sep 7, 2017
**/
@XmlRootElement(name = "UserResponse")
@XmlAccessorType(XmlAccessType.FIELD)
public class UserResponse {
  
  @XmlElement(name="httpStatus")
  private String httpStatus;
  
  @XmlElement(name="userDetails")
  private List<Details> userDetails;
  
  @XmlElement(name="status")
  private String status;
  
  public String getHttpStatus() {
    return httpStatus;
  }
  public void setHttpStatus(String httpStatus) {
    this.httpStatus = httpStatus;
  }
  public List<Details> getUserDetails() {
    return userDetails;
  }
  public void setUserDetails(List<Details> userDetails) {
    this.userDetails = userDetails;
  }
  public String getStatus() {
    return status;
  }
  public void setStatus(String status) {
    this.status = status;
  }
  
  
  
  

}
