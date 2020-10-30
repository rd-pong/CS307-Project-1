import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;

public class DataXlsx {
    private String path;
    private XSSFSheet spreadsheet;


    public DataXlsx(String path) throws IOException {
        this.path = path;
        FileInputStream fis = new FileInputStream(new File(path));
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        // get the first sheet, and ignore the rest
        spreadsheet = workbook.getSheetAt(0);
    }

//    public WeiboPost getPostByPID(long postID) {
//
//    }

    /**
     * xlsxToWeiboPost
     *
     * @param xlsxRow
     * @return
     */
    public static WeiboPost toWeiboPost(XSSFRow xlsxRow) throws SQLException {
        return new WeiboPost(xlsxRow);
    }

    public XSSFSheet getSpreadsheet() {
        return spreadsheet;
    }



    public static void main(String[] args) throws IOException {
        FileInputStream fis = new FileInputStream(new File("data/db_38971_to_xlsx.xlsx"));
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet spreadsheet = workbook.getSheetAt(0);
        System.out.println(spreadsheet.getRow(1).getCell(0));
        System.out.println(spreadsheet.getRow(1).getCell(1));
        System.out.println(spreadsheet.getRow(1).getCell(2));
        System.out.println(spreadsheet.getRow(1).getCell(3));

    }
}
