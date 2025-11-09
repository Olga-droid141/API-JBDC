package ru.stepchenkov.db.dao.stugent_tags;

import ru.stepchenkov.db.dao._base._BaseMainDao;
import ru.stepchenkov.db.dao.stugent_tags.entity.StudentTagsEntity;
import ru.stepchenkov.db.dao.tags.entity.TagEntity;

import java.util.List;

public class StudentTagsDao extends _BaseMainDao {

    public List<StudentTagsEntity> findChainsOfStudent(String studentId) {
        final String query = """
                SELECT * FROM STUDENT_TAGS
                """;
        return jdbi.withHandle(handle -> handle.createQuery(query)
                .mapTo(StudentTagsEntity.class)
                .list()
        );
    }

    public List<TagEntity> findAllTagsOfStudent(String studentId) {
        final String query = """
                SELECT * FROM TAGS WHERE ID = (SELECT TAG_ID FROM STUDENT_TAGS WHERE STUDENT_ID = ?)
                """;
        return jdbi.withHandle(handle -> handle.createQuery(query)
                .bind(0, studentId)
                .mapTo(TagEntity.class)
                .list()
        );
    }
}
