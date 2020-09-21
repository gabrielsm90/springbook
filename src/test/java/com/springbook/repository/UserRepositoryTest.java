package com.springbook.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.springbook.model.User;


@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
public class UserRepositoryTest {
	
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private UserRepository userRepository;
	
	@Test
	public void whenFindByName_ThenReturnUser() {
		
		User user = new User();
		user.setName("Gabriel");
		user.setSurname("Menezes");
		entityManager.persist(user);
		
		List<User> foundUsers = userRepository.findByName("Gabriel");
		assertEquals(foundUsers.size(), 1);
		
		User foundUser = foundUsers.get(0);
		assertEquals(foundUser.getName(), user.getName());
	}

}
