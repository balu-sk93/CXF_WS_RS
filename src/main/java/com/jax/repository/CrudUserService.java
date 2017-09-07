package com.jax.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.jax.model.Details;

/**
 * @author Balu S
 * @version 1.0.0.0
 * @since Sep 7, 2017
**/
@Repository
public interface CrudUserService extends CrudRepository<Details, Long> {
  
  List<Details> findByUserid(String userid);
  
  List<Details> findByUsernameAndPassword(String username, String password);

}
