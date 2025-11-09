package ru.stepchenkov.api;

import lombok.experimental.UtilityClass;
import ru.stepchenkov.api.students.StudentApi;
import ru.stepchenkov.api.tags.TagApi;

@UtilityClass
public class Service {

    StudentApi studentApi = new StudentApi();

    TagApi tagApi = new TagApi();
}
