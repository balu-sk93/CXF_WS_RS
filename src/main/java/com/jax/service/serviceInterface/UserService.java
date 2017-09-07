package com.jax.service.serviceInterface;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;

import com.jax.model.Details;
import com.jax.response.UserResponse;

import io.swagger.annotations.Api;

/**
 * @author Balu S
 * @version 1.0.0.0
 * @since Sep 7, 2017
**/

@Component
@Path("/userService")
@Api(value="User Services")
@WebService(targetNamespace = "http://service.jax.ws/")
public interface UserService {
  
  @POST
  @Path("/addUser")
  @Produces({"application/json"})
  @Consumes({"application/json"})
  @WebResult(name = "UserResponse", partName = "UserResponse")
  @WebMethod(action = "urn:UserService")
  public UserResponse createUser(@WebParam(name = "Details", partName = "Details")
                                 @RequestBody  Details vo);
  @POST
  @Path("/updateUser")
  @Produces({"application/json"})
  @WebResult(name = "UserResponse", partName = "UserResponse")
  @WebMethod(action = "urn:UserService")
  public UserResponse updateUser(@WebParam(name = "Details", partName = "Details")
                                 @RequestBody  Details vo);
  
  @GET
  @Path("/deleteUser/{userid}")
  @Produces({"application/json"})
  @WebResult(name = "UserResponse", partName = "UserResponse")
  @WebMethod(action = "urn:UserService")
  public UserResponse deleteUser(@WebParam(name = "userid", partName = "userid")
                                 @PathParam("userid") String  userid);
  
  @GET
  @Path("/getUser/{userid}")
  @Produces({"application/json"})
  @WebResult(name = "UserResponse", partName = "UserResponse")
  @WebMethod(action = "urn:UserService")
  public UserResponse getUser(@WebParam(name = "userid", partName = "userid")
                              @PathParam("userid") String  userid);
  
  
  @GET
  @Path("/getUsers")
  @Produces({"application/json"})
  @WebResult(name = "UserResponse", partName = "UserResponse")
  @WebMethod(action = "urn:UserService")
  public UserResponse getUsers();
  
  @POST
  @Path("/getUserLogin")
  @Produces({"application/json"})
  @WebResult(name = "UserResponse", partName = "UserResponse")
  @WebMethod(action = "urn:UserService")
  public UserResponse getUserLogin(@WebParam(name = "Details", partName = "Details")
                                   @RequestBody  Details vo);

}
