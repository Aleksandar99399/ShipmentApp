package finalproject.models.entities;

import javax.persistence.*;

@Entity
@Table(name = "sender_recipient")
public class SenderOrRecipient extends BaseEntity {


    private boolean isSender;
    private Office office;


    public boolean isSender() {
        return isSender;
    }

    public SenderOrRecipient setSender(boolean sender) {
        isSender = sender;
        return this;
    }

    @OneToOne
    @JoinColumn(name = "office_id")
    public Office getOffice() {
        return office;
    }

    public SenderOrRecipient setOffice(Office office) {
        this.office = office;
        return this;
    }
}
