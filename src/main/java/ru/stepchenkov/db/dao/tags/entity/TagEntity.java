package ru.stepchenkov.db.dao.tags.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import org.jdbi.v3.core.mapper.reflect.ColumnName;

@Getter
@Setter
@EqualsAndHashCode
public class TagEntity {

    @ColumnName("ID")
    private Integer id;

    @ColumnName("NAME")
    private String name;
}
