package ru.stepchenkov.db.dao.stugent_tags.entity;

import org.jdbi.v3.core.mapper.reflect.ColumnName;

public class StudentTagsEntity {

    @ColumnName("STUDENT_ID")
    private String studentId;

    @ColumnName("TAG_ID")
    private String tagId;
}
