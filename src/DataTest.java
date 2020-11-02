import org.junit.Test;

import java.io.IOException;
import java.sql.SQLException;

public class DataTest {
//    @Test
//    public void XlsxCount() throws IOException {
//        FileInputStream fis = new FileInputStream(new File("data/db_85164_to_xlsx.xlsx"));
//        XSSFWorkbook workbook = new XSSFWorkbook(fis);
//        XSSFSheet spreadsheet = workbook.getSheetAt(0);
//        System.out.println(spreadsheet.getLastRowNum());
//        System.out.println(spreadsheet.getPhysicalNumberOfRows());
//    }
//
//    @Test
//    public void DBCount() throws SQLException {
//        DataMySQL myDB = new DataMySQL();
//        myDB.countRow();
//    }
//
//    @Test
//    public void testXlsxToWeiboPost() throws IOException {
//        DataXlsx myFile = new DataXlsx("data/db_85164_to_xlsx.xlsx");
//        // zero row is label, getRow(1) is the first row
//        XSSFRow myRow = myFile.getSpreadsheet().getRow(1);
//        WeiboPost mypost = DataXlsx.toWeiboPost(myRow);
//    }

    //-------COMPARISON--------------
    @Test
    public void xlsxTest() throws IOException {
        DataXlsx myFile = new DataXlsx("data/db_85164_to_xlsx.xlsx");
        long startTime = System.nanoTime();
        WeiboPost postByPID_xlsx = myFile.getPostByPID(4451487973180932L);
        long stopTime = System.nanoTime();
        System.out.println("time in nanosecond: " + (stopTime - startTime));
    }

    @Test
    public void DBTest() throws SQLException {
        DataMySQL myDB = new DataMySQL();
        WeiboPost postByPID_DB = myDB.getPostByPID(4451487973180932L);
    }

}