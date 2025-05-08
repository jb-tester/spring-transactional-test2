package com.example.springtransactionaltest2;


import com.example.springtransactionaltest2.model.UserRepository;
import com.example.springtransactionaltest2.model.UsersEntity;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;

@Service
public class SpringTransactionalMethodSelfInvocations {
    List<String> list = List.of("John", "William", "Richard");
	private final UserRepository userRepository;

	public SpringTransactionalMethodSelfInvocations(UserRepository userRepository) {
		this.userRepository = userRepository;
	}

	public void addUsers1() {
		// error is shown
        for (String name : list) {
            addUser(name);
        }
	}
	public void addUsers2() {
		// error is shown
        list.forEach(name -> addUser(name));
	}
	public void addUsers3() {
		// error is not shown
		list.forEach(this::addUser);
	}

	@Transactional
	void addUser(String name) {
		userRepository.save(new UsersEntity(name, ""));
	}
}