package TestingApp.controller;


import TestingApp.dto.EmployeeDTO;
import TestingApp.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "/employee")
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;
    @PostMapping()
    public ResponseEntity<EmployeeDTO> createNewEmp(@RequestBody EmployeeDTO employeeDTO){
        EmployeeDTO employeeDTO1 = employeeService.createNewEmp(employeeDTO);
        return new ResponseEntity<>(employeeDTO1, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDTO> getEmpById(@PathVariable Long id){
        EmployeeDTO employeeDTO = employeeService.getEmpById(id);
        return ResponseEntity.ok(employeeDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDTO> updateEmployee(@PathVariable Long id,@RequestBody EmployeeDTO employeeDTO){
        EmployeeDTO employeeDTO1 = employeeService.updateEmployee(id,employeeDTO);
        return ResponseEntity.ok(employeeDTO1);
    }
}
