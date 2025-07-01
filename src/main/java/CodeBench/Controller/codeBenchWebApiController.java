package CodeBench.Controller;

import CodeBench.Dtos.SubmissionRequestDto;
import CodeBench.Dtos.SubmissionResponseDto;
import CodeBench.Entity.Submission;
import CodeBench.Repository.SubmissionRepository;
import CodeBench.Service.KafkaProducerService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutionException;

@RestController
public class codeBenchWebApiController {

    @Autowired
    private KafkaProducerService kafkaProducerService;

    @Autowired
    SubmissionRepository submissionRepository;

    ObjectMapper objectMapper=new ObjectMapper();

    @PostMapping(value = "/submit")
    public ResponseEntity<SubmissionResponseDto> submitCode(@RequestBody SubmissionRequestDto submissionRequestDto) throws ExecutionException, InterruptedException, JsonProcessingException {

        //Generate a submission Id
        UUID uuid= UUID.randomUUID();

        String jsonPayload=objectMapper.writeValueAsString(submissionRequestDto);
        //Send the message to Kafka
        kafkaProducerService.sendMessage("thing1",jsonPayload,uuid.toString());

        //Make an entry in the db for this
        return ResponseEntity.accepted().body(new SubmissionResponseDto(uuid.toString()));
    }

    @GetMapping(value="/getStatus")
    public List<Submission>getStatus(@RequestParam String submissionId){
        return submissionRepository.findAllBySubmissionId(submissionId);
    }
}
