package com.jax.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import org.springframework.stereotype.Service;

/**
 * @author Balu S
 * @version 1.0.0.0
 * @since Sep 7, 2017
**/
@Entity
@Service
@XmlRootElement(name = "Details")
@XmlAccessorType(XmlAccessType.FIELD)
public class Details implements Serializable {

  private static final long serialVersionUID = 1L;

  @Id
  @GeneratedValue(strategy=GenerationType.AUTO)
  @XmlElement(name="userid")
  private String userid;

  @XmlElement(name="username")
  private String username;

  @XmlElement(name="password")
  private String password;

  public String getUserid() {
    return userid;
  }

  public void setUserid(String userid) {
    this.userid = userid;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public String toString() {
    return "Details [userid=" + userid + ", username=" + username
        + ", password=" + password + "]";
  }
  
}
