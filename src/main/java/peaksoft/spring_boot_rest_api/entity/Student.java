package peaksoft.spring_boot_rest_api.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Getter@Setter
public class Student {
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "student_gen",sequenceName = "student_seq",allocationSize = 1)
    @Id
    private Long id;
    private String name;
    private String surname;
    private String email;
    private int age;
    @CreatedDate
    private LocalDate created;
    private boolean enabled;

    public Student(){}


}
