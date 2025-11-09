package ru.stepchenkov.db;

import lombok.experimental.UtilityClass;
import ru.stepchenkov.db.dao.students.StudentsDao;
import ru.stepchenkov.db.dao.stugent_tags.StudentTagsDao;
import ru.stepchenkov.db.dao.tags.TagsDao;

@UtilityClass
public class DaoRepository {

    public StudentsDao studentsDao = new StudentsDao();

    public StudentTagsDao studentTagsDao = new StudentTagsDao();

    public TagsDao tagsDao = new TagsDao();
}
