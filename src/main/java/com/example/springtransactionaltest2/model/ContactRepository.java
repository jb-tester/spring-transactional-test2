package com.example.springtransactionaltest2.model;

import org.springframework.data.repository.CrudRepository;


public interface ContactRepository extends CrudRepository<ContactEntity,Integer> {
}
