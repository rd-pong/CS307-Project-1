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

    public WeiboPost getPostByPID(long postID) {
        // count data row, excluding first row of labels
        int rowCount = spreadsheet.getLastRowNum();
        int rowIndex = binarySearch(spreadsheet, 1, rowCount, postID);
        return toWeiboPost(spreadsheet.getRow(rowIndex));
    }

    /*
     * Returns index of x if it is present in arr[l..r],else return-1
     */
    private static int binarySearch(XSSFSheet spreadsheet, int l, int r, long x) {
        if (r >= 1) {
            int mid = l + (r - l) / 2;
            long midPostID = getRowPostID(spreadsheet, mid);
            // If the element is present at the middle itself
            if (midPostID == x)
                return mid;
            // If element is smaller than mid, then  it can only be present in left subarray
            if (midPostID > x)
                return binarySearch(spreadsheet, l, mid - 1, x);
            // Else the element can only be present in right subarray
            return binarySearch(spreadsheet, mid + 1, r, x);
        }
        // We reach here when element is not present in array
        return -1;
    }

    private static long getRowPostID(XSSFSheet spreadsheet, int rowNum) {
        return Long.parseLong(spreadsheet.getRow(rowNum).getCell(0).getStringCellValue());
    }

    /**
     * xlsxToWeiboPost
     */
    public static WeiboPost toWeiboPost(XSSFRow xlsxRow) {
        return new WeiboPost(xlsxRow);
    }

    public XSSFSheet getSpreadsheet() {
        return spreadsheet;
    }

    public static void main(String[] args) throws IOException, SQLException {
        FileInputStream fis = new FileInputStream(new File("data/db_38971_to_xlsx.xlsx"));
        XSSFWorkbook workbook = new XSSFWorkbook(fis);
        XSSFSheet spreadsheet = workbook.getSheetAt(0);

        System.out.println(spreadsheet.getRow(1).getCell(0).getNumericCellValue());
        System.out.println(spreadsheet.getRow(1).getCell(1));
        System.out.println(spreadsheet.getRow(1).getCell(2));
        System.out.println(spreadsheet.getRow(1).getCell(3));

        System.out.println(binarySearch(spreadsheet, 1, 38971, 4451485259371300L));
    }
}
