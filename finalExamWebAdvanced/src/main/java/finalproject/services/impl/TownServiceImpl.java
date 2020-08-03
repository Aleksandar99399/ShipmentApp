package finalproject.services.impl;

import finalproject.models.entities.Town;
import finalproject.models.serviceModels.TownServiceModel;
import finalproject.repositories.TownRepository;
import finalproject.services.TownService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TownServiceImpl implements TownService {
    private final TownRepository townRepository;
    private final ModelMapper modelMapper;

    public TownServiceImpl(TownRepository townRepository, ModelMapper modelMapper) {
        this.townRepository = townRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public List<Town> findAllTowns() {
        return this.townRepository.findAll();
    }

    @Override
    public TownServiceModel findById(String id) {
        return this.townRepository.findById(id)
                .map(t->this.modelMapper.map(t,TownServiceModel.class))
                .orElse(null);
    }
}
