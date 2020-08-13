package finalproject.models.serviceModels;

public class BaseServiceModel {

    private String id;
    private String firstName;
    private String lastName;
    private String email;
    private String telephoneNumber;

    public BaseServiceModel() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public BaseServiceModel setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public BaseServiceModel setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public BaseServiceModel setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public BaseServiceModel setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
        return this;
    }
}
