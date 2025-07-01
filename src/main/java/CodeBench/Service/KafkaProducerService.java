package CodeBench.Service;

import org.apache.kafka.clients.producer.ProducerRecord;
import org.apache.kafka.common.header.internals.RecordHeader;
import org.jvnet.hk2.annotations.Service;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.concurrent.ExecutionException;

@Component
public class KafkaProducerService {

    private final KafkaTemplate<String,String>kafkaTemplate;

    public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage(String topic, String message,String submissionId) throws ExecutionException, InterruptedException {
        ProducerRecord<String,String> record= new ProducerRecord<>(topic,message);

            record.headers().add(new RecordHeader("submissionId",submissionId.getBytes()));
        


        kafkaTemplate.send(record)
                .thenAccept(sendResult -> {
                    int partition = sendResult.getRecordMetadata().partition();
                    long offset = sendResult.getRecordMetadata().offset();
                    System.out.println("Message sent to partition " + partition + " at offset " + offset);
                })
                .exceptionally(ex -> {
                    System.err.println("Message failed: " + ex.getMessage());
                    return null;
                }).get();

    }


}
