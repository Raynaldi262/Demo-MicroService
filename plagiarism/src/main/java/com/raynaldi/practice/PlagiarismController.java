package com.raynaldi.practice;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
@RequestMapping("api/v1/plagiarism-check")
@AllArgsConstructor
public class PlagiarismController {
    private final PlagiarismCheckHistoryRepository plagiarismCheckHistoryRepository;

    private final PlagiarismCheckService plagiarismCheckService;

    @GetMapping(path = "{studentId}")
    public PlagiarismCheckHistory isPlagiarist(@PathVariable("studentId") Long studentId) {
        PlagiarismCheckHistory isPlagiaristStudent = plagiarismCheckService.isPlagiaristStudent(studentId);
        log.info("Plagiarism check request for student {}", studentId);
        return isPlagiaristStudent;
    }

    @GetMapping("/")
    public List<PlagiarismCheckHistory> listPlagiarist () {
        List<PlagiarismCheckHistory> plagiarismCheckHistoryList = plagiarismCheckHistoryRepository.findAll();
        return plagiarismCheckHistoryList;
    }
}