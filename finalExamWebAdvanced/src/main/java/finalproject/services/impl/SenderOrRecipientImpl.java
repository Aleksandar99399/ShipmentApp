package finalproject.services.impl;

import finalproject.models.entities.SenderOrRecipient;
import finalproject.models.serviceModels.SenderOrRecipientServiceModel;
import finalproject.repositories.SenderOrRecipientRepository;
import finalproject.services.SenderOrRecipientService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SenderOrRecipientImpl implements SenderOrRecipientService {

    private final SenderOrRecipientRepository repository;
    private final ModelMapper modelMapper;

    public SenderOrRecipientImpl(SenderOrRecipientRepository repository, ModelMapper modelMapper) {
        this.repository = repository;
        this.modelMapper = modelMapper;
    }

}
