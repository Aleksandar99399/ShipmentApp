package finalproject.models.entities;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "offices")
public class Office extends BaseEntity{

    private String name;
    private Town town;

    @ManyToOne
    @JoinColumn(name="town_id", nullable=false)
    public Town getTown() {
        return town;
    }

    public Office setTown(Town town) {
        this.town = town;
        return this;
    }

    @Length(min = 4,message = "Office name should be more 3 characters")
    @Column(name = "name",unique = true)
    public String getName() {
        return name;
    }

    public Office setName(String name) {
        this.name = name;
        return this;
    }

}
