package com.raynaldi.practice;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("api/v1/plagiarism-check")
@AllArgsConstructor
public class PlagiarismController {

    private final PlagiarismCheckService plagiarismCheckService;

    @GetMapping(path = "{studentId}")
    public PlagiarismCheckResponse isPlagiarist(@PathVariable("studentId") Long studentId) {
        boolean isPlagiaristStudent = plagiarismCheckService.isPlagiaristStudent(studentId);
        log.info("Plagiarism check request for student {}", studentId);
        return new PlagiarismCheckResponse(isPlagiaristStudent);
    }

}