package finalproject.services.impl;

import finalproject.models.entities.Office;
import finalproject.models.entities.Town;
import finalproject.models.serviceModels.OfficeServiceModel;
import finalproject.repositories.OfficeRepository;
import finalproject.services.OfficeService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfficeServiceImpl implements OfficeService {
    private final OfficeRepository officeRepository;
    private final ModelMapper modelMapper;

    public OfficeServiceImpl(OfficeRepository officeRepository, ModelMapper modelMapper) {
        this.officeRepository = officeRepository;
        this.modelMapper = modelMapper;
    }

    @Override
    public OfficeServiceModel addOffice(OfficeServiceModel osm) {

        Office save = this.officeRepository.save(this.modelMapper.map(osm, Office.class));

        return this.modelMapper.map(save,OfficeServiceModel.class);
    }

    @Override
    public List<Office> findAllOffices() {

        return this.officeRepository.findAll();
    }

    @Override
    public List<Office> findAllByTown(Town town) {

        return this.officeRepository.findAllByTown(town);
    }

    @Override
    public OfficeServiceModel findByName(String name) {

        return this.officeRepository.findByName(name).
                map(o->this.modelMapper.map(o,OfficeServiceModel.class))
                .orElse(null);

    }

    @Override
    public OfficeServiceModel findById(String id) {
        return this.officeRepository.findById(id)
                .map(o->this.modelMapper.map(o,OfficeServiceModel.class))
                .orElse(null);
    }
}
