package peaksoft.spring_boot_rest_api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter@Setter
public class StudentRequest {

    private String name;
    private String surname;
    private String email;
    private int age;
}
