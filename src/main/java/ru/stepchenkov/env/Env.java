package ru.stepchenkov.env;

import org.aeonbits.owner.ConfigFactory;
import ru.stepchenkov.env.config.APIConfig;

public class Env {

    public static class API {
        public static final APIConfig API_CONFIG = ConfigFactory.create(APIConfig.class);
    }
}
