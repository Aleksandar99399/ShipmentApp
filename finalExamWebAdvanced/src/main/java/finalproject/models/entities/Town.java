package finalproject.models.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "towns")
public class Town extends BaseEntity{


    private String name;
    private List<Office> offices=new ArrayList<>();

    @Column(nullable = false)
    public String getName() {
        return name;
    }

    public Town setName(String name) {
        this.name = name;
        return this;
    }

    @JsonIgnore
    @OneToMany(mappedBy = "town",
            cascade = CascadeType.ALL,
            fetch = FetchType.EAGER)
    public List<Office> getOffices() {
        return offices;
    }

    public Town setOffices(List<Office> offices) {
        this.offices = offices;
        return this;
    }


}
