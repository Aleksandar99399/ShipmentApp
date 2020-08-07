package finalproject.services;

import finalproject.models.entities.Office;
import finalproject.models.entities.Town;

import java.util.List;

public interface TownService {

    List<Town> findAllTowns();

    Town findByName(String name);

    void addTownAndOffice(Town office);

    Office saveAdminInOfficeAndEmployee();
}
