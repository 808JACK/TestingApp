package TestingApp.repo;

import TestingApp.TestContainerConfig;
import TestingApp.entities.EmployeeEntity;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import java.util.*;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

@Import(TestContainerConfig.class)//to import the test container
//@SpringBootTest
@DataJpaTest
//@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.ANY)when using h2 oor  smt like
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)//when we are using docker or smt
class EmployeeRepoTest {

    @Autowired
    private EmployeeRepo employeeRepo;

    private EmployeeEntity employee;
    @BeforeEach
    void setUp(){
        employee = EmployeeEntity
                .builder()
                .name("Sarthak")
                .email("Sarthak@gmail.com")
                .salary(100L)
                .build();
    }
    @Test
    void testFindByEmail_whenEmailIsPresent_thenReturnEmployee() {

//        There are 3 things when writing a testcase
//        Arrange(given)
        employeeRepo.save(employee);

//        Act(then)
        List<EmployeeEntity> employeeEntityList = employeeRepo.findByEmail(employee.getEmail());
//        Assert(when)
        assertThat(employeeEntityList).isNotNull();
        assertThat(employeeEntityList.get(0).getEmail()).isEqualTo(employee.getEmail());

    }

    @Test
    void testFindByEmail_whenEmailIsNotFound_thenReturnEmptyEmployeeList(){

//        given
        String email = "notPresent12@gmai.com";
//        when

        List<EmployeeEntity> employeeEntityList = employeeRepo.findByEmail(email);
//        then
        assertThat(employeeEntityList).isNotNull();
        assertThat(employeeEntityList.size()).isEqualTo(0 );
    }


}