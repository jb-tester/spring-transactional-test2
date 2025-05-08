package com.example.springtransactionaltest2;


import com.example.springtransactionaltest2.model.UserRepository;
import com.example.springtransactionaltest2.model.UsersEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class SpringTransactionalMethodSelfInvocations {

	private final UserRepository userRepository;

	public SpringTransactionalMethodSelfInvocations(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public void addUsers() {

		var list = List.of("John", "William", "Richard");

		// error is shown
        for (String name : list) {
            addUser(name);
        }
		// error is shown
        list.forEach(name -> addUser(name));
		// error is not shown
		list.forEach(this::addUser);
	}

	@Transactional
	void addUser(String name) {
		userRepository.save(new UsersEntity(name, ""));
	}
}