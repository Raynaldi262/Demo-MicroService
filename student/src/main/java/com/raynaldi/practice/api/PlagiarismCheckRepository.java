package com.raynaldi.practice.api;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@FeignClient(name = "PLAGIARISM/api/v1/plagiarism-check/")
public interface PlagiarismCheckRepository {

    @RequestMapping(method = RequestMethod.GET, value = "/")
    List<PlagiarismCheckResponse> getAllPlagiarismCheck();

    @RequestMapping(method = RequestMethod.GET, value = "/{studentId}")
    PlagiarismCheckResponse getPlagiarismCheckByStudentId (@PathVariable("studentId") Long studentId);
}
