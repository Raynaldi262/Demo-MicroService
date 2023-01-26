package com.raynaldi.practice;

import com.raynaldi.practice.api.PlagiarismCheckResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/")
    public void registerStudent(@RequestBody StudentRegistrationRequest studentRegistrationRequest) {
        log.info("New Student Registration {}", studentRegistrationRequest);
        studentService.registerStudent(studentRegistrationRequest);
    }

    @RequestMapping( 
            method = RequestMethod.GET)
    public List<PlagiarismCheckResponse> allStudent() {
        List<PlagiarismCheckResponse> plagiarisms = studentService.getAllPlagiarismCheck();
        log.info("Succes get all = " + plagiarisms.size());
        return plagiarisms;
    }
}