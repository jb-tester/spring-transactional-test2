package com.example.springtransactionaltest2.model;

import org.springframework.data.repository.CrudRepository;


public interface UserRepository extends CrudRepository<UsersEntity,Integer> {
}
