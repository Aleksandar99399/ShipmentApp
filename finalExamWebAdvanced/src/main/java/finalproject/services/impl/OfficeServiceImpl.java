package finalproject.services.impl;

import finalproject.errors.OfficeIsExist;
import finalproject.models.entities.Office;
import finalproject.models.entities.Town;
import finalproject.models.serviceModels.OfficeServiceModel;
import finalproject.repositories.OfficeRepository;
import finalproject.services.OfficeService;
import finalproject.services.TownService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

        Town byName = this.townService.findByName(osm.getTown());
        Optional<Office> byName1 = this.officeRepository.findByName(osm.getName());
        if (byName == null && byName1.isEmpty()) {

            Town town = new Town().setName(osm.getTown());
            Office office = new Office().setTown(town).setName(osm.getName());
            town.setOffices(List.of(office));

            this.townService.addTownAndOffice(town);

        } else if (byName != null && byName1.isEmpty()) {
            Office office = new Office().setName(osm.getName()).setTown(byName);
            byName.setOffices(List.of(office));

            this.townService.addTownAndOffice(byName);

        } else if (byName != null && byName1.isPresent()) {
            throw new OfficeIsExist();
        }
        return this.modelMapper.map(osm, OfficeServiceModel.class);
    }

    @Override
    public List<Office> findAllOffices() {

        return this.officeRepository.findAll();
    }


    @Override
    public OfficeServiceModel findById(String id) {

        return this.officeRepository.findById(id)
                .map(o -> this.modelMapper.map(o, OfficeServiceModel.class))
                .orElse(null);
    }

}
