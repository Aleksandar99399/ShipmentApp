package finalproject.models.bindings;

import org.hibernate.validator.constraints.Length;

import javax.persistence.Column;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

public class UserRegisterBindingModel {

    private String firstName;
    private String lastName;
    private String email;
    private String telephoneNumber;
    private String password;
    private String confirmPassword;

    public UserRegisterBindingModel() {
    }

    @Column(name = "first_name",nullable = false)
    @Length(min = 3,message = "Name should be more than 2 characters")
    public String getFirstName() {
        return firstName;
    }

    public UserRegisterBindingModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    @Column(name = "last_name",nullable = false)
    @Length(min = 3,message = "Name should be more than 2 characters")
    public String getLastName() {
        return lastName;
    }

    public UserRegisterBindingModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    @Size(min = 1,message = "The email cannot be empty!")
    @Email(message = "The email is not valid!")
    public String getEmail() {
        return email;
    }

    public UserRegisterBindingModel setEmail(String email) {
        this.email = email;
        return this;
    }

    @Pattern(regexp = "^[0-9\\-\\+]{10}$",message = "Enter valid telephone number")
    @NotNull
    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public UserRegisterBindingModel setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
        return this;
    }

    @Length(min = 4,message = "Enter valid password")
    @NotNull
    public String getPassword() {
        return password;
    }

    public UserRegisterBindingModel setPassword(String password) {
        this.password = password;
        return this;
    }

    @Length(min = 4,message = "Enter valid password")
    @NotNull
    public String getConfirmPassword() {
        return confirmPassword;
    }

    public UserRegisterBindingModel setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
        return this;
    }
}
