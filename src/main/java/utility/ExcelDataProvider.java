package utility;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class ExcelDataProvider {

    XSSFWorkbook wb;

    public ExcelDataProvider(){
        File src = new File("./TestData/Data.xlsx");
        try {
            FileInputStream fis = new FileInputStream(src);
            wb = new XSSFWorkbook(fis);
        }
        catch(Exception e){
            System.out.println("Unable to give excel file "+e.getMessage());
        }
    }

    //Reading the data from excel

    public String getStringData(int sheetIndex, int row, int column){
        return wb.getSheetAt(sheetIndex).getRow(row).getCell(0).getStringCellValue();
    }
    public String getStringData(String sheetName, int row, int column){
       return wb.getSheet(sheetName).getRow(row).getCell(0).getStringCellValue();
    }

    public double getNumericData(String sheetName, int row, int column){
        return wb.getSheet(sheetName).getRow(row).getCell(0).getNumericCellValue();
    }

}
