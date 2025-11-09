package ru.stepchenkov.db.dao.students.entity;

import org.jdbi.v3.core.mapper.reflect.ColumnName;

public class StudentEntity {

    @ColumnName("ID")
    private Integer id;

    @ColumnName("NAME")
    private String name;

    @ColumnName("EMAIL")
    private String email;

    @ColumnName("CREATED_AT")
    private String createdAt;
}
