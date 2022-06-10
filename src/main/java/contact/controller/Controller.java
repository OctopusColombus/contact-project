package contact.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import contact.entity.Contact;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import contact.repository.ContactList;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class Controller {

    @Autowired
    private ContactList contactList;

    @GetMapping("/getContact")
    public List<Contact> getContact(String name, String phoneNumber) {
        List<Contact> responses = new ArrayList<>();
        log.info("{}", name);
        log.info("{}", phoneNumber);
        try {
            if (name == null && phoneNumber == null) {
                log.info("Start Find All Contact");
                responses = contactList.findAll();
            } else if (name != null && phoneNumber == null) {
                log.info("Start Find Contact By Name");
                responses = contactList.findByName(name);
            } else {
                log.info("Start Find Contact By Phone Number");
                responses = contactList.findByPhoneNumber(phoneNumber);
            }
        } catch (Exception ex) {
            throw ex;
        }

        return  responses;
    }

    @PostMapping("/saveContact")
    public Contact saveContact(@RequestBody Contact contactRequest) throws JsonProcessingException {
        try {
            contactList.save(contactRequest);
        } catch (Exception ex) {
            throw ex;
        }

        return contactRequest;
    }

    @DeleteMapping("/deleteContact")
    public void deleteContact(Long id) {
        List<Contact> responses = new ArrayList<>();
        try {
            contactList.deleteById(id);
        } catch (Exception ex) {
            throw ex;
        }
    }

    @PostMapping("/updateContact")
    public Contact updateContact(@RequestBody Contact contactResponse) {
        try {
            contactList.save(contactResponse);
        } catch (Exception ex) {
            throw ex;
        }
        return contactResponse;
    }
}
