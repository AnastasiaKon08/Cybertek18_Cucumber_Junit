package test;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class ExcelRead {

    public static void main(String[] args) throws Exception {

        File file = new File("src/ExcelPractice.xlsx");
        // System.out.println(file.exists());

        //Load the file into java memory using file input stream
        FileInputStream fileInputStream = new FileInputStream(file);

        // Load the excel workbook into Java class
        XSSFWorkbook workbook = new XSSFWorkbook(fileInputStream);

        // workbook -> sheet -> row -> cell
        XSSFSheet sheet = workbook.getSheet("Employees");

        // How to get Sandler from the excel Sheet?
        System.out.println("sheet.getRow(2).getCell(1) = " + sheet.getRow(2).getCell(1));

        int usedRows = sheet.getPhysicalNumberOfRows();
        // will count only used cells, empty ones will not be counted
        // starts counting from one

        int lastUsedRow = sheet.getLastRowNum();
        // will count from top to buttom, does not care if cell is empty or not
        // starts from 0

        System.out.println("sheet.getRow(4).getCell(0) = " + sheet.getRow(4).getCell(0));

        for (int rowNum = 0; rowNum<usedRows; rowNum++){
            if (sheet.getRow(rowNum).getCell(0).toString().equals("Neena")){
                System.out.println("Neena's name: "  + sheet.getRow(rowNum).getCell(0));
            }
        }

        for (int rowNum =0; rowNum<usedRows; rowNum++){
            if (sheet.getRow(rowNum).getCell(0).toString().equals("Adam")){
                System.out.println("Adam's last name: " + sheet.getRow(rowNum).getCell(1));
            }
        }

        for (int rowNum = 0; rowNum< usedRows; rowNum++){
            if (sheet.getRow(rowNum).getCell(0).toString().equals("Steven")){
                System.out.println("Steven's JOB ID is: " + sheet.getRow(rowNum).getCell(2));
            }
        }


    }
}
