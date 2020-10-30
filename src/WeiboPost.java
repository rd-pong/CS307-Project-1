import org.apache.poi.xssf.usermodel.XSSFRow;

import java.sql.ResultSet;
import java.sql.SQLException;

public class WeiboPost {
    private long id;
    private String bid;
    private int user_id;
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
    private int retweet_id;

    /**
     * full constructor
     *
     * @param id
     * @param bid
     * @param user_id
     * @param screen_name
     * @param text
     * @param article_url
     * @param topics
     * @param at_users
     * @param pics
     * @param video_url
     * @param location
     * @param created_at
     * @param source
     * @param attitudes_count
     * @param comments_count
     * @param reposts_count
     * @param retweet_id
     */
    public WeiboPost(long id, String bid, int user_id, String screen_name, String text, String article_url, String topics, String at_users, String pics, String video_url, String location, String created_at, String source, int attitudes_count, int comments_count, int reposts_count, int retweet_id) {
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
        this.retweet_id = retweet_id;
    }

    public WeiboPost(ResultSet rs) throws SQLException {
        this.id = rs.getLong(1);
        this.bid = rs.getString(2);
        this.user_id = rs.getInt(3);
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
        this.retweet_id = rs.getInt(17);
    }

    public WeiboPost(XSSFRow xlsxRow) throws SQLException {
        this.id = (long) xlsxRow.getCell(0).getNumericCellValue();
        this.bid = xlsxRow.getCell(1).getStringCellValue();
//        this.user_id = rs.getInt(3);
        this.screen_name = xlsxRow.getCell(3).getStringCellValue();
//        this.text = rs.getString(5);
        this.article_url = xlsxRow.getCell(5).getStringCellValue();
        this.topics = xlsxRow.getCell(6).getStringCellValue();
        this.at_users = xlsxRow.getCell(7).getStringCellValue();
        this.pics = xlsxRow.getCell(8).getStringCellValue();
        this.video_url = xlsxRow.getCell(9).getStringCellValue();
        this.location = xlsxRow.getCell(10).getStringCellValue();
        this.created_at = xlsxRow.getCell(11).getStringCellValue();
        this.source = xlsxRow.getCell(12).getStringCellValue();
//        this.attitudes_count = rs.getInt(14);
//        this.comments_count = rs.getInt(15);
//        this.reposts_count = rs.getInt(16);
//        this.retweet_id = rs.getInt(17);
    }


    // Getters and Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getBid() {
        return bid;
    }

    public void setBid(String bid) {
        this.bid = bid;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getScreen_name() {
        return screen_name;
    }

    public void setScreen_name(String screen_name) {
        this.screen_name = screen_name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getArticle_url() {
        return article_url;
    }

    public void setArticle_url(String article_url) {
        this.article_url = article_url;
    }

    public String getTopics() {
        return topics;
    }

    public void setTopics(String topics) {
        this.topics = topics;
    }

    public String getAt_users() {
        return at_users;
    }

    public void setAt_users(String at_users) {
        this.at_users = at_users;
    }

    public String getPics() {
        return pics;
    }

    public void setPics(String pics) {
        this.pics = pics;
    }

    public String getVideo_url() {
        return video_url;
    }

    public void setVideo_url(String video_url) {
        this.video_url = video_url;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public int getAttitudes_count() {
        return attitudes_count;
    }

    public void setAttitudes_count(int attitudes_count) {
        this.attitudes_count = attitudes_count;
    }

    public int getComments_count() {
        return comments_count;
    }

    public void setComments_count(int comments_count) {
        this.comments_count = comments_count;
    }

    public int getReposts_count() {
        return reposts_count;
    }

    public void setReposts_count(int reposts_count) {
        this.reposts_count = reposts_count;
    }

    public int getRetweet_id() {
        return retweet_id;
    }

    public void setRetweet_id(int retweet_id) {
        this.retweet_id = retweet_id;
    }
}
