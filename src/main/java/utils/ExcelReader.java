package utils;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.Hashtable;

public class ExcelReader {

    public XSSFSheet sheet;
    public XSSFWorkbook workbook ;
    //public Hashtable<String,Integer> dict = new Hashtable<String, Integer>();

    public ExcelReader(String sheetName) throws IOException {
        try{
            File file = new File(System.getProperty("user.dir")+ File.separator+"TestData"+File.separator+"TestData.xlsx");
            FileInputStream inputStream = new FileInputStream(file);
            workbook = new XSSFWorkbook(inputStream);
            sheet = workbook.getSheet(sheetName);
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
        if(row.getCell(c).getCellType()== CellType.STRING) {
            return row.getCell(c).getStringCellValue();
        }else {
             //String.valueOf(row.getCell(c).getNumericCellValue());
            DecimalFormat decimalFormat = new DecimalFormat("0");
            return decimalFormat.format(row.getCell(c).getNumericCellValue());

        }
}


}
