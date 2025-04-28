package TestingApp.repo;

import TestingApp.entities.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface EmployeeRepo extends JpaRepository<EmployeeEntity,Long> {

    List<EmployeeEntity> findByEmail(String email);
}
