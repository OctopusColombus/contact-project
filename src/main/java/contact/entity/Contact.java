package contact.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "list")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", length = 20, nullable = false)
    private Long id;

    @Column(name = "NAME", length = 100, nullable = false)
    private String name;

    @Column(name = "PHONE_NUMBER", length = 20, nullable = false)
    private String phoneNumber;

    @Column(name = "ADDRESS", length = 200)
    private String address;

    @Column(name = "EMAIL", length = 100)
    private String email;

    @Column(name = "DOB", length = 20)
    @Temporal(TemporalType.DATE)
    private Date dob;
}
