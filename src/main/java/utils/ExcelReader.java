package utils;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Hashtable;

public class ExcelReader {

    public Sheet sheet;
    public Workbook workbook = null;
    public Hashtable<String,Integer> dict = new Hashtable<String, Integer>();

    public ExcelReader(String sheetName) throws IOException {
        try{
            File file = new File(System.getProperty("user.dir")+ File.separator+"TestData"+File.separator+"TestData.xlsx");
            FileInputStream inputStream = new FileInputStream(file);
            Workbook testData = new XSSFWorkbook(inputStream);
            sheet = testData.getSheet(sheetName);
        }
        catch (IOException e){
            throw new IOException();
        }
    }

    public int RowCount(){
        return sheet.getLastRowNum() + 1;
    }
    public int ColumnCount(int r){
        return sheet.getRow(r).getLastCellNum();
    }

    public String ReadCell(int r, int c){
        Row row = sheet.getRow(r);
        return row.getCell(c).getStringCellValue();
    }

}
