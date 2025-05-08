package com.example.springtransactionaltest2;

import com.example.springtransactionaltest2.model.ContactEntity;
import org.springframework.stereotype.Service;

@Service
public class CallerService {

    private final IncorrectTransactionsService incorrectTransactionsService;

    public CallerService(IncorrectTransactionsService incorrectTransactionsService) {
        this.incorrectTransactionsService = incorrectTransactionsService;
    }

    // this method should fail due to the contactEntity validation rules; the corresponding userEntity creation should be rolled back.
    public void createInvalidContact(){

        incorrectTransactionsService.callContactCreator(new ContactEntity("foo","","",""));
    }
}
