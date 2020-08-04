package finalproject.models.serviceModels;

import finalproject.models.entities.Office;

import java.util.ArrayList;
import java.util.List;

public class TownServiceModel extends BaseServiceModel{
    private String name;
    private List<OfficeServiceModel> offices=new ArrayList<>();

    public TownServiceModel() {
    }

    public String getName() {
        return name;
    }

    public TownServiceModel setName(String name) {
        this.name = name;
        return this;
    }

    public List<OfficeServiceModel> getOffices() {
        return offices;
    }

    public TownServiceModel setOffices(List<OfficeServiceModel> offices) {
        this.offices = offices;
        return this;
    }
}
