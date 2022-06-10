package contact.repository;

import contact.entity.Contact;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ContactList extends JpaRepository<Contact, Long> {
    List<Contact> findByName(String name);
    List<Contact> findByPhoneNumber(String phoneNumber);
}
