package ru.stepchenkov.db.dao.tags;

import ru.stepchenkov.db.dao._base._BaseMainDao;
import ru.stepchenkov.db.dao.tags.entity.TagEntity;

import java.util.List;

public class TagsDao extends _BaseMainDao {

    public List<TagEntity> findAllTags() {
        final String query = """
                SELECT * FROM TAGS
                """;
        return jdbi.withHandle(handle -> handle.createQuery(query)
                .mapTo(TagEntity.class)
                .list()
        );
    }

    public TagEntity findTagById(String id) {
        final String query = """
                SELECT * FROM TAGS WHERE ID = ?
                """;
        return jdbi.withHandle(handle -> handle.createQuery(query)
                .bind(0,id)
                .mapTo(TagEntity.class)
                .one()
        );
    }
}
