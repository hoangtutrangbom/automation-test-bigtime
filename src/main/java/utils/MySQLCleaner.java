package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * Lớp tiện ích để xóa dữ liệu test trong database
 */
public class MySQLCleaner {
    private static final Logger logger = LogManager.getLogger(MySQLCleaner.class);


    //Xóa dữ liệu test từ bảng leave_applications

    public static void clearLeaveApplication() {
        try {
            Connection conn = DriverManager.getConnection(
                    Config.db_url,
                    Config.db_username,
                    Config.db_password);

            Statement stmt = conn.createStatement();

            // Xóa dữ liệu test
            String sql = "DELETE FROM leave_applications WHERE user_id = 'jzGUjZ1i0Z'";
            int rowsAffected = stmt.executeUpdate(sql);

            stmt.close();
            conn.close();

            logger.info("Đã xóa {} dòng dữ liệu test từ bảng leave_applications", rowsAffected);
        } catch (Exception e) {
            logger.error("Lỗi khi xóa dữ liệu test: {}", e.getMessage());
        }
    }

    /**
     * Xóa dữ liệu test cho một user_id cụ thể
     *
     * @param userId ID của user cần xóa dữ liệu
     */
    public static void clearTestDataForUser(String userId) {
        try {
            Connection conn = DriverManager.getConnection(
                    Config.db_url,
                    Config.db_username,
                    Config.db_password);

            Statement stmt = conn.createStatement();

            // Xóa dữ liệu test
            String sql = "DELETE FROM leave_applications WHERE user_id = '" + userId + "'";
            int rowsAffected = stmt.executeUpdate(sql);

            stmt.close();
            conn.close();

            logger.info("Đã xóa {} dòng dữ liệu test cho user_id {} từ bảng leave_applications", rowsAffected, userId);
        } catch (Exception e) {
            logger.error("Lỗi khi xóa dữ liệu test cho user_id {}: {}", userId, e.getMessage());
        }
    }
}
