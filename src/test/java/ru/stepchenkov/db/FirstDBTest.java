package ru.stepchenkov.db;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import ru.stepchenkov.api.BaseTest;
import ru.stepchenkov.db.dao.students.entity.StudentEntity;
import ru.stepchenkov.db.dao.stugent_tags.entity.StudentTagsEntity;
import ru.stepchenkov.db.dao.tags.entity.TagEntity;

import java.util.Collections;
import java.util.List;

public class FirstDBTest extends BaseDBTest {


    @Test
    public void findAliceTagsTest() {
        List<StudentEntity> students = DaoRepository.studentsDao.findStudentByName("Алиса");
        Assertions.assertEquals(1, students.size());

        List<TagEntity> tags = DaoRepository.studentTagsDao.findAllTagsOfStudent(students.get(0).getId());
        TagEntity expectedTag = new TagEntity();
        expectedTag.setId(5);
        expectedTag.setName("aqa");
        Assertions.assertEquals(Collections.singletonList(expectedTag), tags);
    }

    @Test
    public void checkAllNames() {
        List<StudentEntity> students = DaoRepository.studentsDao.findAllStudent();
        students.stream().filter(se ->
            se.getName().startsWith("[а-яa-z]")
        ).peek(se -> {
            String firstLetter = se.getName().substring(0,1);
            DaoRepository.studentsDao.updateStudentName(String.valueOf(se.getId()),
                    firstLetter.replaceFirst(firstLetter,firstLetter.toUpperCase()));
        }).close();
    }

    @Test
    public void printStudentCount() {
        List<StudentTagsEntity> studentTagsEntities = DaoRepository.studentTagsDao.findAllStudentsHasTag("backend");

        System.out.println("backend: " + studentTagsEntities.size());
    }
}
