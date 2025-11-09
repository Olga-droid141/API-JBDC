package ru.stepchenkov.api.students;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import lombok.extern.slf4j.Slf4j;
import ru.stepchenkov.api._base._BaseApi;
import ru.stepchenkov.api.students.entity.StudentDto;
import ru.stepchenkov.env.Env;

@Slf4j
public class StudentApi extends _BaseApi {

    public StudentApi() {
        super(Env.API.API_CONFIG);
    }

    private RequestSpecification students() {
        return jsonAutoAuth()
                .baseUri("/api/students");
    }

    public Response get() {
        return students().get();
    }

    public Response get(String id) {
        return students().get("/" + id);
    }

    public Response delete(String id) {
        return students().delete("/" + id);
    }

    public Response post(StudentDto student) {
        return students().body(student).post();
    }

    public Response put(StudentDto student, String id) {
        return students().body(student).put("/" + id);
    }
}
