package com.example.springtransactionaltest2;

import jakarta.transaction.Transactional;

import java.util.List;

public class JakartaTransactionalMethodSelfInvocations {

	void test() {

		var list = List.of("", "");
		// error is shown
        for (String s : list) {
            method(s);
        }
		// error is shown
        list.forEach(s -> method(s));
		// error is not shown
		list.forEach(this::method);
	}

	@Transactional
	void method(String s) {
	}
}