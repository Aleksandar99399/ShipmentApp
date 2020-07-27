package finalproject.models.entities;

import javax.persistence.Entity;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "sender_recipient")
public class SenderOrRecipient extends BaseEntity {

    private String firstName;
    private String lastName;
    private String email;
    private String telephoneNumber;
    private boolean isSender;
    private Office office;

    public String getFirstName() {
        return firstName;
    }

    public SenderOrRecipient setFirstName(String firstName) {
        this.firstName = firstName;
        return this;
    }

    public String getLastName() {
        return lastName;
    }

    public SenderOrRecipient setLastName(String lastName) {
        this.lastName = lastName;
        return this;
    }

    public String getEmail() {
        return email;
    }

    public SenderOrRecipient setEmail(String email) {
        this.email = email;
        return this;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public SenderOrRecipient setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
        return this;
    }

    public boolean isSender() {
        return isSender;
    }

    public SenderOrRecipient setSender(boolean sender) {
        isSender = sender;
        return this;
    }

    @OneToOne
    public Office getOffice() {
        return office;
    }

    public SenderOrRecipient setOffice(Office office) {
        this.office = office;
        return this;
    }
}
