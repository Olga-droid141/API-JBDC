package ru.stepchenkov.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;
import java.util.List;

@AllArgsConstructor
@Getter
public enum Tags {

    AQA(5, "aqa"),
    BACK(4, "backend"),
    JAVA(2,"java"),
    QA(1, "qa"),
    SPRING(3, "spring"),
    STRING(6,"string");

    private int id;
    private String displayName;
}
