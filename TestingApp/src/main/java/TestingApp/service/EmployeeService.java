package TestingApp.service;


import TestingApp.dto.EmployeeDTO;
import TestingApp.entities.EmployeeEntity;
import TestingApp.repo.EmployeeRepo;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class EmployeeService {
    private final EmployeeRepo employeeRepo;
    private final ModelMapper modelMapper;
    public EmployeeDTO createNewEmp(EmployeeDTO employeeDTO) {

        EmployeeEntity employee = modelMapper.map(employeeDTO, EmployeeEntity.class);
        employeeRepo.save(employee);
        return modelMapper.map(employee, EmployeeDTO.class);
    }

    public EmployeeDTO getEmpById(Long id) {

        log.info("Fetching employee by id :" +id);
        Optional<EmployeeEntity> employee = employeeRepo.findById(id);

        log.info("Successfully fetched the employee"+employee);
        return modelMapper.map(employee, EmployeeDTO.class);

    }

    public void deleteEmployee(Long id) {

        employeeRepo.deleteById(id);
        return;
    }

    public EmployeeDTO updateEmployee(Long id, EmployeeDTO employeeDTO) {

        Optional<EmployeeEntity> employee = employeeRepo.findById(id);
        if(employee.isPresent()){

            EmployeeEntity employee1 = employee.get();
            // Update the fields manually from employeeDTO
            employee1.setName(employeeDTO.getName());
            employee1.setEmail(employeeDTO.getEmail());
            employee1.setSalary(Long.valueOf(employeeDTO.getSalary()));

            // Save the updated entity
            EmployeeEntity updated = employeeRepo.save(employee1);

            // Map back to DTO and return
            return modelMapper.map(updated, EmployeeDTO.class);
        } else {
            throw new RuntimeException("Employee not found with id: " + id);
        }

    }
}
