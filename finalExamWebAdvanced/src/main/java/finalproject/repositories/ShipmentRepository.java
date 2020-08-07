package finalproject.repositories;

import finalproject.models.entities.Office;
import finalproject.models.entities.SenderOrRecipient;
import finalproject.models.entities.Shipment;
import finalproject.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ShipmentRepository extends JpaRepository<Shipment,String> {

   //List<Shipment> findAllByEmailAndSender(String email,boolean isSender);

   //boolean findByEmail(String email);


    @Query(value = "SELECT s FROM Shipment s join s.senderOrRecipients sr WHERE sr.email=:email and sr.sender=:sender")
    List<Shipment> findAllByShipmentsOnUser(@Param("email") String email,@Param("sender") boolean isSender);

    @Query(value = "SELECT s FROM Shipment s join s.senderOrRecipients sr WHERE sr.sender=:sender and sr.office=:office")
    List<Shipment> findAllByRecipients(@Param("sender") boolean isSender,@Param("office") Office office);
}
