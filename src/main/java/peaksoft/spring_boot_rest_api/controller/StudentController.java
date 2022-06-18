package peaksoft.spring_boot_rest_api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import peaksoft.spring_boot_rest_api.dto.StudentRequest;
import peaksoft.spring_boot_rest_api.dto.StudentResponse;
import peaksoft.spring_boot_rest_api.dto.StudentResponseView;
import peaksoft.spring_boot_rest_api.service.StudentService;


@RestController
@RequiredArgsConstructor
@RequestMapping("api/student")
@Tag(name ="Student API",description = "User with admin role can add,update,delete or get all students")
public class StudentController {

    private final StudentService service;

    @PostMapping
    @Operation(summary = "Hello From Swagger")
    public StudentResponse create(@RequestBody StudentRequest request){
        return service.create(request);
    }

    @PutMapping("{id}")
    public StudentResponse update(@PathVariable long id, @PathVariable StudentRequest request){
        return service.update(id,request);
    }

    @DeleteMapping("{id}")

    public StudentResponse delete(@PathVariable long id){
        return service.deleteById(id);
    }

//    @GetMapping
//    public List<StudentResponse> getAllStudents(){
//        return service.getAllStudents();
//    }

    @GetMapping
    public StudentResponseView getAllStudents(@RequestParam(name = "text",required = false) String text,
                                              @RequestParam int page,
                                              @RequestParam int size){
        return service.getAllStudentsPagination(text, page, size);
    }
}
