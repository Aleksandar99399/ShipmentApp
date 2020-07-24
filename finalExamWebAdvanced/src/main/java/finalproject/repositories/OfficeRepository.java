package finalproject.repositories;

import finalproject.models.entities.Office;
import finalproject.models.serviceModels.OfficeServiceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OfficeRepository extends JpaRepository<Office,String> {

}
