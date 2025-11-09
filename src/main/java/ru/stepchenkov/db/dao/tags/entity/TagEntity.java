package ru.stepchenkov.db.dao.tags.entity;

import org.jdbi.v3.core.mapper.reflect.ColumnName;

public class TagEntity {

    @ColumnName("ID")
    private Integer id;

    @ColumnName("NAME")
    private String name;
}
