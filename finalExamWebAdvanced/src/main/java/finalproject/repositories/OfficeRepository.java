package finalproject.repositories;

import finalproject.models.entities.Office;
import finalproject.models.entities.Town;
import finalproject.models.serviceModels.OfficeServiceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OfficeRepository extends JpaRepository<Office,String> {

    List<Office>findAllByTown(Town town);
}
