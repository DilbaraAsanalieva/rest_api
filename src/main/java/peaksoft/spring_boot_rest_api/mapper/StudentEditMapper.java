package peaksoft.spring_boot_rest_api.mapper;

import org.springframework.stereotype.Component;
import peaksoft.spring_boot_rest_api.dto.StudentRequest;
import peaksoft.spring_boot_rest_api.entity.Student;

import java.time.LocalDate;

@Component
public class StudentEditMapper {

    public Student create(StudentRequest request){
        if(request == null){
            return null;
        }
        Student student = new Student();
        student.setName(request.getName());
        student.setAge(request.getAge());
        student.setEmail(request.getEmail());
        student.setSurname(request.getSurname());
        student.setCreated(LocalDate.now());
        student.setEnabled(true);

        return student;
    }

    public void update(Student student,StudentRequest request){
        student.setName(request.getName());
        student.setAge(request.getAge());
        student.setEmail(request.getEmail());
        student.setSurname(request.getSurname());

    }

}
