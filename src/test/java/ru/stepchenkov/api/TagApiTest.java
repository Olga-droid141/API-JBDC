package ru.stepchenkov.api;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import ru.stepchenkov.api.tags.entity.TagDto;
import ru.stepchenkov.utils.Fakers;

public class TagApiTest extends BaseTest {

    @Test
    @DisplayName("Получение списка тэгов")
    public void getTagsListTest() {
        Service.tagApi.get()
                .then().statusCode(200)
                .extract().as(TagDto[].class);
    }

    @Test
    @DisplayName("Корректный запрос POST /tags")
    public void addTagPositiveTest() {
        Service.tagApi.post(
                TagDto.builder()
                        .name(Fakers.randomName())
                        .build()
        ).then().statusCode(201)
                .extract().as(TagDto.class);
    }
}
