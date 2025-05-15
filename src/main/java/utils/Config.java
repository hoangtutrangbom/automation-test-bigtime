package utils;

import io.github.cdimascio.dotenv.Dotenv;

public class Config {
    private static final Dotenv dotenv = Dotenv.load();

    // URL và thông tin đăng nhập chính
    public static final String url = dotenv.get("urlBigtimeStg");
    public static final String username = dotenv.get("username_bigtime_stg");
    public static final String password = dotenv.get("password_bigtime_stg");

    // Thông tin đăng nhập cho các vai trò khác nhau
    public static final String employee_username = dotenv.get("employee_username");
    public static final String employee_password = dotenv.get("employee_password");

    public static final String manager_username = dotenv.get("manager_username");
    public static final String manager_password = dotenv.get("manager_password");

    public static final String admin_username = dotenv.get("admin_username");
    public static final String admin_password = dotenv.get("admin_password");

    // Connect database
    public static final String db_url = dotenv.get("db_url");
    public static final String db_username = dotenv.get("db_username");
    public static final String db_password = dotenv.get("db_password");
}
