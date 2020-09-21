package com.springbook.controller.dto;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

import com.springbook.model.User;

public class UserDTO {

	private String documentId;
	private String name;
	private String surname;
	private String email;
	private LocalDate birthday;
	private String login;

	public UserDTO(User user) {
		this.documentId = user.getDocumentId();
		this.name = user.getName();
		this.surname = user.getSurname();
		this.email = user.getEmail();
		this.birthday = user.getBirthday();
		this.login = user.getLogin();
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public String getDocumentId() {
		return documentId;
	}

	public String getEmail() {
		return email;
	}

	public LocalDate getBirthday() {
		return birthday;
	}

	public String getLogin() {
		return login;
	}

	public static List<UserDTO> convert(List<User> users) {
		return users.stream().map(UserDTO::new).collect(Collectors.toList());
	}

}
