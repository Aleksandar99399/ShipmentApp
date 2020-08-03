package finalproject.models.serviceModels;

import finalproject.models.entities.Office;

import java.util.ArrayList;
import java.util.List;

public class TownServiceModel {
    private String name;
    private List<Office> offices=new ArrayList<>();

    public TownServiceModel() {
    }

    public String getName() {
        return name;
    }

    public TownServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public List<Office> getOffices() {
        return offices;
    }

    public TownServiceModel setOffices(List<Office> offices) {
        this.offices = offices;
        return this;
    }
}
