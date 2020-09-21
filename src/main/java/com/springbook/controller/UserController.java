package com.springbook.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.springbook.controller.dto.UserDTO;
import com.springbook.controller.form.UserForm;
import com.springbook.model.User;
import com.springbook.repository.UserRepository;

@RestController
@RequestMapping("/users")
public class UserController {

	@Autowired
	private UserRepository userRepository;

	@GetMapping
	public List<UserDTO> get(String name) {
		List<User> users;

		if (name == null) {
			users = userRepository.findAll();
		} else {
			users = userRepository.findByName(name);
		}

		return UserDTO.convert(users);
	}

	@GetMapping("/{id}")
	public ResponseEntity<UserDTO> getOne(@PathVariable Long id) {
		Optional<User> foundUser = userRepository.findById(id);
		if (foundUser.isPresent()) {
			User user = foundUser.get();
			return ResponseEntity.ok(new UserDTO(user));
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping
	@Transactional
	public ResponseEntity<UserDTO> add(@RequestBody @Valid UserForm userForm, UriComponentsBuilder uriBuilder) {
		User user = userForm.convertToUser();
		userRepository.save(user);
		URI uri = uriBuilder.path("/topicos/{id}").buildAndExpand(user.getId()).toUri();
		return ResponseEntity.created(uri).body(new UserDTO(user));
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<UserDTO> update(@PathVariable Long id, @RequestBody @Valid UserForm userForm,
			UriComponentsBuilder uriBuilder) {
		Optional<User> foundUser = userRepository.findById(id);
		if (foundUser.isPresent()) {
			User user = userForm.update(id, userRepository);
			return ResponseEntity.ok(new UserDTO(user));
		}
		return ResponseEntity.notFound().build();		
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> delete(@PathVariable Long id) {
		Optional<User> foundUser = userRepository.findById(id);
		if (foundUser.isPresent()) {
			userRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}
		return ResponseEntity.notFound().build();	
	}

}
