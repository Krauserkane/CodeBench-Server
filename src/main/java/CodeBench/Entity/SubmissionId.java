package CodeBench.Entity;

import jakarta.persistence.Embeddable;
import java.io.Serializable;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Embeddable
public class SubmissionId implements Serializable {

    private String submissionId;

    private int testCaseId;
}
