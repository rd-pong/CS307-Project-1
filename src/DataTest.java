import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;

public class DataTest {
    @Test
    public void testGetPostByPID() throws SQLException {
        DataMySQL myDB = new DataMySQL();
        WeiboPost postByPID = myDB.getPostByPID(4510432600403896L);
    }

    @Test
    public void testXlsxCount() throws IOException {
        FileInputStream fis = new FileInputStream(new File("data/db_85164_to_xlsx.xlsx"));
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet spreadsheet = workbook.getSheetAt(0);
        // System.out.println(spreadsheet.getLastRowNum());
        System.out.println(spreadsheet.getPhysicalNumberOfRows());
    }

    @Test
    public void testXlsxToWeiboPost() throws IOException, SQLException {
        DataXlsx myFile = new DataXlsx("data/db_38971_to_xlsx.xlsx");
        XSSFRow myRow = myFile.getSpreadsheet().getRow(0);
        WeiboPost mypost = DataXlsx.toWeiboPost(myRow);
    }

}