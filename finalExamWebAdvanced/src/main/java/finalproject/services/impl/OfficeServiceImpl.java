package finalproject.services.impl;

import finalproject.models.entities.Office;
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
}
