package CodeBench;

import com.github.dockerjava.api.DockerClient;
import com.github.dockerjava.api.command.CreateContainerResponse;
import com.github.dockerjava.core.DockerClientBuilder;
import com.github.dockerjava.core.command.ExecStartResultCallback;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.ByteArrayOutputStream;

@SpringBootApplication
public class CodeBenchApplication {

	public static void main(String[] args) {

		SpringApplication.run(CodeBenchApplication.class, args);

	}

}