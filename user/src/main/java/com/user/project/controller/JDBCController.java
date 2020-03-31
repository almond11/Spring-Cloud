package com.user.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.user.project.exceptions.ResourceNotFoundException;
import com.user.project.model.User;
import com.user.project.repository.*;
import java.util.List;
import java.util.NoSuchElementException;


@RestController
@RequestMapping("/api")
public class JDBCController {

    @Autowired
    JDBCRepository userRepository;


    @PostMapping("/users/{id}/{f}/{l}/{a}/{em}/")
    public ResponseEntity<?> createUser(@PathVariable Long id,@PathVariable String f,@PathVariable String l,@PathVariable String a,@PathVariable String em) {
    	  try {
  	    	User u = userRepository.findById(id);
  	    	return new ResponseEntity<>(HttpStatus.CONFLICT);
  	    	
  	    	
    	  }catch (Exception ex) {
    	  userRepository.insert(new User(id,f,l,a,em));
    	  return ResponseEntity.ok().build();
    	  }
    }
    
    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }
    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Long id) {
        
	    try {
	    	User u = userRepository.findById(id);
	        return new ResponseEntity<User>(u, HttpStatus.OK);
	    } catch (Exception e) {
	        return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	    }      
	
    }
 
    @DeleteMapping("/users/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable Long id) {
 
	    try {
	    	User u = userRepository.findById(id);
			userRepository.deleteById(id);
	        return ResponseEntity.ok().build();
	    } catch (Exception e) {
	        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	    } 

    }
}

