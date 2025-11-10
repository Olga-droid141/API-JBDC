package ru.stepchenkov.db.dao.students.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.jdbi.v3.core.mapper.reflect.ColumnName;

@Getter
@Setter
@EqualsAndHashCode
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
