package ru.stepchenkov.api.tags;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import ru.stepchenkov.api._base._BaseApi;
import ru.stepchenkov.api.tags.entity.TagDto;
import ru.stepchenkov.env.Env;

public class TagApi extends _BaseApi {
    public TagApi() {
        super(Env.API.API_CONFIG);
    }

    private RequestSpecification tags() {
        return jsonAutoAuth().baseUri("/api/tags");
    }

    public Response get() {
        return tags().get();
    }

    public Response post(TagDto tag) {
        return tags().body(tag).post();
    }
}
