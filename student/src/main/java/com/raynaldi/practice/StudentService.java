package com.raynaldi.practice;

import com.raynaldi.practice.api.PlagiarismCheckRepository;
import com.raynaldi.practice.api.PlagiarismCheckResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import javax.transaction.Transactional;

@Service
public class StudentService {

    @Autowired
    PlagiarismCheckRepository plagiarismCheckRepository;

    @Autowired
    StudentRepository studentRepository;

    @Transactional
    public void registerStudent(StudentRegistrationRequest request) {
        Student student = Student.builder()
                .firstName(request.firstName())
                .lastName(request.lastName())
                .email(request.email())
                .build();

        studentRepository.saveAndFlush(student);

        PlagiarismCheckResponse plagiarismCheckResponse = plagiarismCheckRepository.getPlagiarismCheckByStudentId(student.getId());


        if (plagiarismCheckResponse.getIsPlagiarist()) {
            throw new IllegalStateException("Student is a plagiarist!");
        }

        System.out.println(plagiarismCheckResponse.getIsPlagiarist());
    }
}