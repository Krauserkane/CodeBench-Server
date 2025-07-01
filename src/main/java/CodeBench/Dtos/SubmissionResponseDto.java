package CodeBench.Dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SubmissionResponseDto {

    @JsonProperty("submissionId")
    private String submissionId;

    public SubmissionResponseDto(String submissionId) {
        this.submissionId=submissionId;
    }
}
