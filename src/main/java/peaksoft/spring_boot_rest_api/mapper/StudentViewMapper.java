package peaksoft.spring_boot_rest_api.mapper;

import org.springframework.stereotype.Component;
import peaksoft.spring_boot_rest_api.dto.StudentResponse;
import peaksoft.spring_boot_rest_api.entity.Student;

import java.util.ArrayList;
import java.util.List;

@Component
public class StudentViewMapper {

    public StudentResponse viewStudent(Student student){
        if(student == null){
            return null;
        }
        StudentResponse response = new StudentResponse();
        response.setId(student.getId());
        response.setEmail(student.getEmail());
        response.setName(student.getName());
        response.setAge(student.getAge());
        response.setEnabled(student.isEnabled());
        response.setCreated(student.getCreated());

        return response;
    }

    public List<StudentResponse> view(List<Student> students){
        List<StudentResponse> responses = new ArrayList<>();
        for(Student student: students){
            responses.add(viewStudent(student));
        }
        return responses;

    }

}
