package ru.stepchenkov.utils;

import com.github.javafaker.Faker;
import net.bytebuddy.utility.RandomString;
import ru.stepchenkov.api.tags.Tag;
import ru.stepchenkov.model.Tags;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Fakers {

    private static final String[] tags = new String[]{"qa", "java", "spring", "backend", "aqa", "string"};

    public static String randomMail() {
        return Faker.instance().internet().emailAddress();
    }

    public static String randomName() {
        return Faker.instance().funnyName().name();
    }

    public static String randomTag() {
        int ransomInt = Faker.instance().random().nextInt(1, 6);
        return tags[ransomInt - 1];
    }

    public static List<String> randomTags(int num) {
        List<String> tags = new ArrayList<>();
        for (int i = 0; i < num; i++) {
            tags.add(randomTag());
        }
        return tags;
    }

    public static String randomString() {
        return RandomString.make();
    }
}
