package com.example.springtransactionaltest2;

import com.example.springtransactionaltest2.model.*;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class IncorrectTransactionsService {

    private final MessageService messageService;
    private final ContactRepository contactRepository;
    private final UserRepository userRepository;
    private final IncorrectTransactionsService self;

    public IncorrectTransactionsService(MessageService messageService, ContactRepository contactRepository, UserRepository userRepository
                                        ,@Lazy IncorrectTransactionsService self // self-injection to avoid error
    ) {
        this.messageService = messageService;
        this.contactRepository = contactRepository;
        this.userRepository = userRepository;
        this.self = self;  // self-injection to avoid error
    }

    public void callContactCreator(ContactEntity contact) {
        self.createContactAndUser(contact); // self-injection to avoid error
       //  createContactAndUser(contact);   // causes error: the method will be not transactional

        messageService.displayMessage("created: "+contact.toString());
    }

    @Transactional()
    public void createContactAndUser(ContactEntity contact) {
        messageService.displayMessage("i'm preparing to create contact!");
        userRepository.save(new UsersEntity(contact.getFirstname(),"default_password"));
        contactRepository.save(contact);
    }
}
