package com.springbook.controller.form;

import java.time.LocalDate;

import javax.transaction.Transactional;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.springbook.model.User;
import com.springbook.repository.UserRepository;

public class UserForm {

	@NotBlank(message = "Document is mandatory")
	private String documentId;

	@NotBlank(message = "Name is mandatory")
	private String name;

	@NotBlank(message = "Surname is mandatory")
	private String surname;

	@NotBlank(message = "Email is mandatory")
	private String email;

	@NotNull(message = "Date of birthday is mandatory")
	private LocalDate birthday;

	@NotBlank(message = "Login must be provided")
	private String login;

	public String getDocumentId() {
		return documentId;
	}

	public void setDocumentId(String documentId) {
		this.documentId = documentId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public void setBirthday(LocalDate birthday) {
		this.birthday = birthday;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	private User fillUserObject(User user) {
		user.setBirthday(birthday);
		user.setDocumentId(documentId);
		user.setEmail(email);
		user.setName(name);
		user.setSurname(surname);
		user.setLogin(login);
		return user;
	}

	public User convertToUser() {
		User user = new User();
		return fillUserObject(user);
	}

	public User update(Long id, UserRepository userRepository) {
		User user = userRepository.getOne(id);
		return fillUserObject(user);
	}

}
