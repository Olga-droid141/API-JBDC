package ru.stepchenkov.db;

import lombok.experimental.UtilityClass;
import ru.stepchenkov.db.dao.students.StudentsDao;
import ru.stepchenkov.db.dao.stugent_tags.StudentTagsDao;
import ru.stepchenkov.db.dao.tags.TagsDao;

@UtilityClass
public class DaoRepository {

    StudentsDao studentsDao = new StudentsDao();

    StudentTagsDao studentTagsDao = new StudentTagsDao();

    TagsDao tagsDao = new TagsDao();
}
