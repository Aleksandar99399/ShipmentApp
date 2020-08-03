package finalproject.services;

import finalproject.models.entities.Office;
import finalproject.models.entities.Town;
import finalproject.models.serviceModels.OfficeServiceModel;

import java.util.List;

public interface OfficeService {

    OfficeServiceModel addOffice(OfficeServiceModel osm);

    List<Office> findAllOffices();

    List<Office> findAllByTown(Town town);

    OfficeServiceModel findByName(String name);

    OfficeServiceModel findById(String id);
}
