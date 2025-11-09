package ru.stepchenkov.db.dao.stugent_tags.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.jdbi.v3.core.mapper.reflect.ColumnName;

@Getter
@Setter
@EqualsAndHashCode
public class StudentTagsEntity {

    @ColumnName("STUDENT_ID")
    private String studentId;

    @ColumnName("TAG_ID")
    private String tagId;
}
