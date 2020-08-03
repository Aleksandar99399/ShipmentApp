package finalproject.services.impl;

import finalproject.models.entities.Office;
import finalproject.models.entities.Town;
import finalproject.models.serviceModels.OfficeServiceModel;
import finalproject.repositories.OfficeRepository;
import finalproject.services.OfficeService;
import finalproject.services.TownService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OfficeServiceImpl implements OfficeService {
    private final TownService townService;
    private final OfficeRepository officeRepository;
    private final ModelMapper modelMapper;

    public OfficeServiceImpl(TownService townService, OfficeRepository officeRepository, ModelMapper modelMapper) {
        this.townService = townService;
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

    @Override
    public Office getOfficeFromDb(Office office) {
        Office office1 = this.officeRepository.findByName(office.getName()).orElse(null);
        Town town=this.townService.findByName(office.getTown().getName());
        assert office1 != null;
        office1.setTown(town);
        return this.officeRepository.save(office1);
    }
}
