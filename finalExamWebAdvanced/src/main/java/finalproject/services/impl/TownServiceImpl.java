package finalproject.services.impl;

import finalproject.models.entities.Town;
import finalproject.repositories.TownRepository;
import finalproject.services.TownService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TownServiceImpl implements TownService {
    private final TownRepository townRepository;

    public TownServiceImpl(TownRepository townRepository) {
        this.townRepository = townRepository;
    }

    @Override
    public List<Town> findAllTowns() {
        return this.townRepository.findAll();
    }
}
