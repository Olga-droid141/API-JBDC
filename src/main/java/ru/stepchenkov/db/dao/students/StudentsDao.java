package ru.stepchenkov.db.dao.students;

import ru.stepchenkov.db.dao._base._BaseMainDao;
import ru.stepchenkov.db.dao.students.entity.StudentEntity;
import ru.stepchenkov.db.dao.tags.entity.TagEntity;

import java.util.List;

public class StudentsDao extends _BaseMainDao {

    public List<StudentEntity> findAllStudent(String name) {
        final String query = """
                SELECT * FROM STUDENTS
                """;
        return jdbi.withHandle(
                handle -> handle.createQuery(query)
                        .mapTo(StudentEntity.class)
                        .list()
        );
    }

    public List<StudentEntity> findStudentByName(String name) {
        final String query = """
                SELECT * FROM STUDENTS WHERE NAME = ?
                """;
        return jdbi.withHandle(
                handle -> handle.createQuery(query)
                        .bind(0, name)
                        .mapTo(StudentEntity.class)
                        .list()
        );
    }

    public StudentEntity findStudentById(String id) {
        final String query = """
                SELECT * FROM STUDENTS WHERE ID = ?
                """;
        return jdbi.withHandle(
                handle -> handle.createQuery(query)
                        .bind(0, id)
                        .mapTo(StudentEntity.class)
                        .one()
        );
    }

}