package ru.stepchenkov.api.payload.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Value;

import java.util.ArrayList;
import java.util.List;

@Value
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class StudentDto {

    @JsonProperty("id")
    Integer id;

    @JsonProperty("name")
    String name;

    @JsonProperty("email")
    String email;

    @JsonProperty("tags")
    List<String> tags = new ArrayList<>();

    @JsonProperty("createdAt")
    String createdAt;
}
