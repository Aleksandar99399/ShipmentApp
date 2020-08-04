package finalproject.models.entities;


import org.hibernate.annotations.LazyCollection;
import org.hibernate.annotations.LazyCollectionOption;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "users")
public class User extends BaseEntity{

    private String firstName;
    private String lastName;
    private String email;
    private String telephoneNumber;
    private String password;
    private List<Role> role =new ArrayList<>();

    public User() {
    }

    @Column(name = "first_name",nullable = false)
    @Length(min = 3,message = "Incorrect name")
    public String getFirstName() {
        return firstName;
    }

    @Column(name = "last_name",nullable = false)
    @Length(min = 3,message = "Incorrect name")
    public String getLastName() {
        return lastName;
    }

    public User setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }


    public User setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public User setEmail(String email) {
        this.email = email;
        return this;
    }

    @Pattern(regexp = "^[0-9\\-\\+]{10}$",message = "Enter valid telephone number")
    @NotNull
    @Column(name = "telephone_number")
    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public User setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
        return this;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    @Size(min = 1,message = "The email cannot be empty!")
    @Email(message = "The email is not valid!")
    @Column(name = "email",unique = true)
    public String getEmail() {
        return email;
    }

    @Length(min = 4,message = "Enter valid password")
    @NotNull
    public String getPassword() {
        return password;
    }

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id")
    public List<Role> getRoles() {
        return role;
    }

    public User setRoles(List<Role> roles) {
        this.role = roles;
        return this;
    }


//    @ManyToMany
//    @LazyCollection(value = LazyCollectionOption.FALSE)
//    public List<Shipment> getShipments() {
//        return shipments;
//    }
//
//    public User setShipments(List<Shipment> shipments) {
//        this.shipments = shipments;
//        return this;
//    }


}
