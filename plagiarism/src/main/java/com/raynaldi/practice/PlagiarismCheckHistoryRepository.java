package com.raynaldi.practice;

import org.springframework.data.jpa.repository.JpaRepository;

public interface PlagiarismCheckHistoryRepository extends JpaRepository<PlagiarismCheckHistory, Long> {
    PlagiarismCheckHistory findByStudentId(Long id);
}
