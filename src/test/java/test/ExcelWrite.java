package test;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ExcelWrite {

    public static void main(String[] args) throws Exception {

        XSSFWorkbook workbook;
        XSSFSheet sheet;
        XSSFRow row;
        XSSFCell cell;

        String path = "src/ExcelPractice.xlsx";
        FileInputStream fileInputStream = new FileInputStream(path);

        workbook = new XSSFWorkbook(fileInputStream);
        // loading excel workbook into the class

        sheet = workbook.getSheet("Employees");

        // king's row
        row = sheet.getRow(1);

        // king's cell
        cell = row.getCell(1);

        // storing adam's name cell if you're frequently using it

        XSSFCell adamsCell = sheet.getRow(2).getCell(0);

        System.out.println("Before: " + adamsCell);
        adamsCell.setCellValue("Madam");
        System.out.println("After: " + adamsCell);

        //TODO:  Change Steven's name to Tom
        XSSFCell stevensCell = sheet.getRow(1).getCell(0);

        System.out.println("Before: " + stevensCell);
        stevensCell.setCellValue("Tom");
        System.out.println("After: " + stevensCell);

        // TODO: Change Neena's job to Developer

        for (int rowNum = 0; rowNum< sheet.getPhysicalNumberOfRows(); rowNum++){
            if (sheet.getRow(rowNum).getCell(0).toString().equals("Neena")){
                sheet.getRow(rowNum).getCell(2).setCellValue("Developer");
                System.out.println(sheet.getRow(rowNum).getCell(2).toString());
            }
        }





        // create a fileoutstream to specify which file we are writing to
        FileOutputStream fileOutputStream = new FileOutputStream(path);
        workbook.write(fileOutputStream);

        // Close these at the end of the class so the file is not corrupt
        fileInputStream.close();
        fileOutputStream.close();
        workbook.close();







    }
}
