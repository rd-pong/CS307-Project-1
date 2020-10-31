import org.apache.poi.xssf.usermodel.XSSFRow;

import java.sql.ResultSet;
import java.sql.SQLException;

public class WeiboPost {
    private long id;
    private String bid;
    private String user_id;
    private String screen_name;
    private String text;
    private String article_url;
    private String topics;
    private String at_users;
    private String pics;
    private String video_url;
    private String location;
    private String created_at;
    private String source;
    private int attitudes_count;
    private int comments_count;
    private int reposts_count;

    /*
     * full constructor
     */
    public WeiboPost(long id, String bid, String user_id, String screen_name, String text, String article_url, String topics, String at_users, String pics, String video_url, String location, String created_at, String source, int attitudes_count, int comments_count, int reposts_count) {
        this.id = id;
        this.bid = bid;
        this.user_id = user_id;
        this.screen_name = screen_name;
        this.text = text;
        this.article_url = article_url;
        this.topics = topics;
        this.at_users = at_users;
        this.pics = pics;
        this.video_url = video_url;
        this.location = location;
        this.created_at = created_at;
        this.source = source;
        this.attitudes_count = attitudes_count;
        this.comments_count = comments_count;
        this.reposts_count = reposts_count;
    }

    /*
     * constructor for DB query
     */
    public WeiboPost(ResultSet rs) throws SQLException {
        this.id = rs.getLong(1);
        this.bid = rs.getString(2);
        this.user_id = rs.getString(3);
        this.screen_name = rs.getString(4);
        this.text = rs.getString(5);
        this.article_url = rs.getString(6);
        this.topics = rs.getString(7);
        this.at_users = rs.getString(8);
        this.pics = rs.getString(9);
        this.video_url = rs.getString(10);
        this.location = rs.getString(11);
        this.created_at = rs.getString(12);
        this.source = rs.getString(13);
        this.attitudes_count = rs.getInt(14);
        this.comments_count = rs.getInt(15);
        this.reposts_count = rs.getInt(16);
    }

    /*
     * constructor for xlsx query TODO
     */
    public WeiboPost(XSSFRow xlsxRow) {
        this.id = Long.parseLong(xlsxRow.getCell(0).getStringCellValue());
        this.bid = xlsxRow.getCell(1).getStringCellValue();
        this.user_id = String.valueOf(xlsxRow.getCell(2).getNumericCellValue());
        this.screen_name = xlsxRow.getCell(3).getStringCellValue();
        this.text = xlsxRow.getCell(4).getStringCellValue();
        this.article_url = xlsxRow.getCell(5).getStringCellValue();
        this.topics = xlsxRow.getCell(6).getStringCellValue();
        this.at_users = xlsxRow.getCell(7).getStringCellValue();
        this.pics = xlsxRow.getCell(8).getStringCellValue();
        this.video_url = xlsxRow.getCell(9).getStringCellValue();
        this.location = xlsxRow.getCell(10).getStringCellValue();
        this.created_at = xlsxRow.getCell(11).getStringCellValue();
        this.source = xlsxRow.getCell(12).getStringCellValue();
        this.attitudes_count = (int) xlsxRow.getCell(13).getNumericCellValue();
        this.comments_count = (int) xlsxRow.getCell(14).getNumericCellValue();
        this.reposts_count = (int) xlsxRow.getCell(15).getNumericCellValue();
    }
}
