package finalproject.services;

import finalproject.models.entities.Office;
import finalproject.models.serviceModels.OfficeServiceModel;

import java.util.List;

public interface OfficeService {

    OfficeServiceModel addOffice(OfficeServiceModel osm);

    List<Office> findAllOffices();
}
