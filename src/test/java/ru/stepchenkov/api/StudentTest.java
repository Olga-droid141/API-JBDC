package ru.stepchenkov.api;

import org.junit.jupiter.api.*;
import ru.stepchenkov.api.students.entity.StudentDto;
import ru.stepchenkov.utils.DateTime;
import ru.stepchenkov.utils.Fakers;

import java.util.Collections;


public class StudentTest extends BaseTest {

    private static StudentDto correctStudent;
    private static int studentId;

    @BeforeEach
    public void beforeEach() {
        correctStudent = StudentDto.builder()
                .email(Fakers.randomMail())
                .name(Fakers.randomName())
                .createdAt(DateTime.currentDateTime(DateTime.yyyy_MM_dd_T_HH_mm_ssSSS_Z))
                .tags(Fakers.randomTags(3))
                .build();
    }


    @Test
    @Order(0)
    @DisplayName("Отправка корректного запроса POST /student")
    public void studentPositiveTest() {
        StudentDto studentDto = Service.student.post(
                correctStudent
        ).then().statusCode(201).extract().as(StudentDto.class);
        studentId = studentDto.getId();
    }

    @Test
    @Order(1)
    @DisplayName("Отправка некорректного запроса POST /student, попытка создать дубль")
    public void studentDubleTest() {
        Service.student.post(
                correctStudent
        ).then().statusCode(400);
    }

    @Test
    @Order(2)
    @DisplayName("Отправка некорректного запроса POST /student, неверный формат email")
    public void studentWrongEmailTest() {
        Service.student.post(
                correctStudent.toBuilder().email(Fakers.randomString()).build()
        ).then().statusCode(400);
    }

    @Test
    @Order(3)
    @DisplayName("Отправка некорректного запроса POST /student, добавить tag не из списка")
    public void studentWrongTagTest() {
        Service.student.post(
                correctStudent.toBuilder().tags(Collections.singletonList("piton")).build()
        ).then().statusCode(400);
    }

    @Test
    @Order(4)
    @DisplayName("Получить список всех студентов")
    public void getAllStudentsTest() {
        Service.student.get()
                .then().statusCode(200)
                .extract().as(StudentDto[].class);
    }

    @Test
    @Order(5)
    @DisplayName("Получить существующего студента по id")
    public void getStudentTest() {
        StudentDto studentDto = Service.student.get(String.valueOf(studentId))
                .then().statusCode(200)
                .extract().as(StudentDto.class);
        Assertions.assertEquals(correctStudent.toBuilder().id(studentId).build(), studentDto);
    }

    @Test
    @Order(6)
    @DisplayName("Получить несуществующего студента по id")
    public void getAbsentStudentTest() {
        Service.student.get("-1")
                .then().statusCode(404);
    }

    @Test
    @Order(7)
    @DisplayName("Удалить существующего студента")
    public void deleteStudentTest() {
        Service.student.get(String.valueOf(studentId))
                .then().statusCode(204);
    }

    @Test
    @Order(8)
    @DisplayName("Удалить несуществующего студента")
    public void deleteAbsentStudentTest() {
        Service.student.get("-2")
                .then().statusCode(404);
    }
}
