package CodeBench.Entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@NamedQuery(
        name="Submission.findBySubmissionId",
        query="SELECT s from Submission s WHERE s.submissionId.submissionId = :submissionId"
)
public class Submission {

    @EmbeddedId
    private SubmissionId submissionId;

    @Column(columnDefinition = "TEXT")
    private String input;

    @Column(columnDefinition = "TEXT")
    private String output;

    @Column(columnDefinition = "TEXT")
    private String stdout;

    @Column(columnDefinition = "TEXT")
    private String stderr;

    @Column
    private Double timeTaken;

    @Column
    private int memoryTaken;
}
