package utils;

import io.github.cdimascio.dotenv.Dotenv;

public class Config {
    private static final Dotenv dotenv = Dotenv.load();

    public static final String url = dotenv.get("urlBigtimeStg");
    public static final String username = dotenv.get("username_bigtime_stg");
    public static final String password = dotenv.get("password_bigtime_stg");
}
