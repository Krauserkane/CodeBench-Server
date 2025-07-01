package CodeBench.Repository;

import CodeBench.Entity.Submission;
import CodeBench.Entity.SubmissionId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SubmissionRepository extends JpaRepository<Submission, SubmissionId> {

    @Query(name = "Submission.findBySubmissionId")
    List<Submission> findAllBySubmissionId(@Param("submissionId") String submissionId);

}
