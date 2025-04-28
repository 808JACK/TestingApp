package TestingApp.dto;


import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class EmployeeDTO {

    private Long id;
    private String email;
    private String name;;
    private String salary;
}
