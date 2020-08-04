package finalproject.repositories;

import finalproject.models.entities.Role;
import finalproject.models.entities.Shipment;
import finalproject.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Repository

public interface UserRepository extends JpaRepository<User,String> {

    Optional<User> findByEmail(String email);

    Optional<User> findByTelephoneNumber(String number);

    @Query("SELECT s from User as s join s.roles role where s.email =:email and role.name = :name")
    User findByRole(@Param("email")String email,@Param("name")String name);

}
