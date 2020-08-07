package finalproject.services;

import finalproject.models.entities.Office;
import finalproject.models.entities.Town;
import finalproject.models.entities.User;
import finalproject.models.serviceModels.OfficeServiceModel;

import java.util.List;

public interface OfficeService {

    OfficeServiceModel addOffice(OfficeServiceModel osm);

    List<Office> findAllOffices();

    OfficeServiceModel findById(String id);

    void addGlavenOffice(Office glaven);

}
