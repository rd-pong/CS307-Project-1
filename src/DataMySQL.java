import org.junit.Test;

import java.sql.*;

public class DataMySQL {
    private Connection conn;

    // DB username and password
    static final String USERNAME = "root";
    static final String PASSWORD = "123456";

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/weibo" + "?useSSL=false&" + "useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";

    public DataMySQL() {
        try {
            Class.forName(JDBC_DRIVER);
            System.out.println("连接数据库...");
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
    }

    public WeiboPost getPostByPID(long postID) throws SQLException {
        PreparedStatement stmt = conn.prepareStatement("select * from weibo.weibo where id = ? limit 1");
        stmt.setLong(1, postID);
        ResultSet rs = stmt.executeQuery();
        if (rs.next()) {
            return toWeiboPost(rs);
        } else {
            return null;
        }
    }

    /**
     * DBResultSetToWeiboPost
     *
     * @param rs
     * @return
     * @throws SQLException
     */
    public static WeiboPost toWeiboPost(ResultSet rs) throws SQLException {
        return new WeiboPost(rs);
    }

    @Test
    public void testConstructor() throws SQLException {
        DataMySQL myDB = new DataMySQL();
        Statement stmt = conn.createStatement();
        String sql = "select * from weibo.weibo where id = 4510432600403896";
        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()) {
            WeiboPost returnPost = new WeiboPost(rs);
            System.out.println("");
            System.out.println("1 " + rs.getLong(1) + "\n" +
                    "2 " + rs.getString(2) + "\n" +
                    "3 " + rs.getInt(3) + "\n" +
                    "4 " + rs.getString(4) + "\n" +
                    "5 " + rs.getString(5) + "\n" +
                    "6 " + rs.getString(6) + "\n" +
                    "7 " + rs.getString(7) + "\n" +
                    "8 " + rs.getString(8) + "\n" +
                    "9 " + rs.getString(9) + "\n" +
                    "14 " + rs.getInt(14) + "\n");
        }
    }

}
