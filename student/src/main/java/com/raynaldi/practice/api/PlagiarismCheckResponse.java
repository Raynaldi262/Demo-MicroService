package com.raynaldi.practice.api;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PlagiarismCheckResponse {
    @JsonProperty("id")
    private Long id;

    @JsonProperty("studentId")
    private Long studentId;

    @JsonProperty("isPlagiarist")
    private Boolean isPlagiarist;

    @JsonProperty("createdAt")
    private LocalDateTime createdAt;
}
