package CodeBench.Dtos;

import com.fasterxml.jackson.annotation.JsonProperty;

public class TestCasesDto {

    @JsonProperty(value = "input")
    private String input;

    @JsonProperty(value = "output")
    private String output;

    @JsonProperty(value = "testCaseId")
    private String testCaseId;
}
