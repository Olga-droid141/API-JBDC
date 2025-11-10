package ru.stepchenkov.env;

import org.aeonbits.owner.ConfigFactory;
import ru.stepchenkov.env.config.APIConfig;
import ru.stepchenkov.env.config.DBConfig;

public class Env {

    public static class API {
        public static final APIConfig API_CONFIG = ConfigFactory.create(APIConfig.class);

    }

    public static class DB {
        public static final DBConfig DB_CONFIG = ConfigFactory.create(DBConfig.class);

    }
}
