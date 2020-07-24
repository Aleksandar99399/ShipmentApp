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

    @Override
    public boolean isExistSenderOrRecipient(String email) {
        return this.repository.findByEmail(email);
    }

    @Override
    public SenderOrRecipientServiceModel addSender(SenderOrRecipientServiceModel map) {
        SenderOrRecipient sender = this.modelMapper.map(map, SenderOrRecipient.class);
        sender.setSender(true);
        this.repository.save(sender);
        return this.modelMapper.map(sender,SenderOrRecipientServiceModel.class);
    }

    @Override
    public SenderOrRecipientServiceModel addRecipient(SenderOrRecipientServiceModel map) {
        SenderOrRecipient sender = this.modelMapper.map(map, SenderOrRecipient.class);
        sender.setSender(false);
        this.repository.save(sender);
        return this.modelMapper.map(sender,SenderOrRecipientServiceModel.class);
    }

    @Override
    public List<SenderOrRecipient> findAllBySender(boolean isSender) {

        return this.repository.findAllBySender(isSender) ;
    }
}
