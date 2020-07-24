package finalproject.models.bindings;

import finalproject.models.entities.Town;
import org.hibernate.validator.constraints.Length;

public class OfficeAddBindingModel {

    private String officeName;
    private Town town;

    @Length(min = 4,message = "Office name must be more than 3 characters")
    public String getOfficeName() {
        return officeName;
    }

    public OfficeAddBindingModel setOfficeName(String officeName) {
        this.officeName = officeName;
        return this;
    }

    public Town getTown() {
        return town;
    }

    public OfficeAddBindingModel setTown(Town town) {
        this.town = town;
        return this;
    }
}
