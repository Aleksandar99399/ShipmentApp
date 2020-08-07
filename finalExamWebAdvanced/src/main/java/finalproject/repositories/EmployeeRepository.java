package finalproject.repositories;

import finalproject.models.entities.Employee;
import finalproject.models.entities.Office;
import finalproject.models.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,String> {

    @Query("select e from Employee e join e.user u where u.email =:email")
    Optional<Employee> findEmployee(@Param("email") String email);

    Optional<Employee> findByUserAndOffice(User user, Office office);

    List<Employee> findAllByOffice(Office office);
}
