package finalproject.repositories;

import finalproject.models.entities.SenderOrRecipient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SenderOrRecipientRepository extends JpaRepository<SenderOrRecipient,String> {

}
