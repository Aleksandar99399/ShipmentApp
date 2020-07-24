package finalproject.models.map;

public class UserMapClass {
    private String firstName;
    private String lastName;
    private String email;
    private String telephoneNumber;

    public String getFirstName() {
        return firstName;
    }

    public UserMapClass setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public UserMapClass setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public UserMapClass setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public UserMapClass setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
        return this;
    }
}
