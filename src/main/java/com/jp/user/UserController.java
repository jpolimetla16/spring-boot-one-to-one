package com.jp.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@PostMapping
	public ResponseEntity<?> createUser(@RequestBody UserEntity userEntity){
		UserEntity savedEntity = userRepository.save(userEntity);
		return ResponseEntity.status(HttpStatus.CREATED).body(savedEntity);
	}
	
	@GetMapping("/{id}")
	public UserEntity getUser(@PathVariable Integer id) {
		return userRepository.findById(id).orElse(null);
	}

}
