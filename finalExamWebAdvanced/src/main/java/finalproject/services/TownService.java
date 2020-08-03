package finalproject.services;

import finalproject.models.entities.Town;
import finalproject.models.serviceModels.TownServiceModel;

import java.util.List;

public interface TownService {

    List<Town> findAllTowns();

    TownServiceModel findById(String id);
}
