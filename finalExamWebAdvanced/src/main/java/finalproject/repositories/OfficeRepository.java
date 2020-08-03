package finalproject.repositories;

import finalproject.models.entities.Office;
import finalproject.models.entities.Town;
import finalproject.models.serviceModels.OfficeServiceModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface OfficeRepository extends JpaRepository<Office,String> {

    List<Office>findAllByTown(Town town);

    Optional<Office>findByName(String name);

    Optional<Office>findById(String id);

}
