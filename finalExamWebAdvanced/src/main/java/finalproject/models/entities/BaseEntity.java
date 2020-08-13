package finalproject.models.entities;


import org.hibernate.annotations.GenericGenerator;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@MappedSuperclass
public class BaseEntity  {
    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String telephoneNumber;

    @Id
    @GeneratedValue(generator = "uuid-string")
    @GenericGenerator(
            name = "uuid-string",
            strategy = "org.hibernate.id.UUIDGenerator"
    )
    public String getId() {
        return id;
    }

    public BaseEntity setId(String id) {
        this.id = id;
        return this;
    }

    @Column(name = "first_name",nullable = false)
    @Length(min = 3,message = "Incorrect name")
    public String getFirstName() {
        return firstName;
    }

    public BaseEntity setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    @Column(name = "last_name",nullable = false)
    @Length(min = 3,message = "Incorrect name")
    public String getLastName() {
        return lastName;
    }

    public BaseEntity setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @Size(min = 1,message = "The email cannot be empty!")
    @Email(message = "The email is not valid!")
    @Column(name = "email",unique = true)
    public String getEmail() {
        return email;
    }

    public BaseEntity setEmail(String email) {
        this.email = email;
        return this;
    }

    @Pattern(regexp = "^[0-9\\-\\+]{10}$",message = "Enter valid telephone number")
    @NotNull
    @Column(name = "telephone_number")
    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public BaseEntity setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
        return this;
    }
}
