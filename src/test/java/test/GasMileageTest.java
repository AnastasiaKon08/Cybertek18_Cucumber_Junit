package test;

import com.cybertek.pages.GasMileageCalculatorPage;
import com.cybertek.utilities.Driver;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.DecimalFormat;
import java.time.LocalDateTime;

public class GasMileageTest {
    XSSFWorkbook workbook;
    XSSFSheet sheet;
    XSSFRow currentRow;
    FileInputStream fileInputStream;
    FileOutputStream fileOutputStream;
    GasMileageCalculatorPage gasMileageCalculatorPage = new GasMileageCalculatorPage();

    @Test
    public void gasMileageCalculatorTest() throws Exception{
        Driver.getDriver().get("https://www.calculator.net/gas-mileage-calculator.html");

        String path = "src/test/resources/testdata/GasMileageTestData.xlsx";
        FileInputStream fileInputStream = new FileInputStream(path);
        // loading the workbook to class
        workbook = new XSSFWorkbook(fileInputStream);
        sheet = workbook.getSheet("Sheet1");

        for (int rowNum =1; rowNum<=sheet.getLastRowNum(); rowNum++) {
            XSSFRow currentRow = sheet.getRow(rowNum);

            if (!currentRow.getCell(0).toString().equals("Y")){
                if (currentRow.getCell(6) == null) {
                    currentRow.createCell(6);
                }
                currentRow.getCell(6).setCellValue("Skip Requested");
                continue;
            }
            double current = currentRow.getCell(1).getNumericCellValue();
            //double current = 123000;
            gasMileageCalculatorPage.currentOdometer.clear();
            gasMileageCalculatorPage.currentOdometer.sendKeys(String.valueOf(current));

            double previous = currentRow.getCell(2).getNumericCellValue();
            gasMileageCalculatorPage.previousOdometer.clear();
            gasMileageCalculatorPage.previousOdometer.sendKeys(String.valueOf(previous));

            double gas = currentRow.getCell(3).getNumericCellValue();
            gasMileageCalculatorPage.gallons.clear();
            gasMileageCalculatorPage.gallons.sendKeys(String.valueOf(gas));

            gasMileageCalculatorPage.calculate.click();

            String[] actualResult = gasMileageCalculatorPage.gasMileage.getText().split(" ");
            System.out.println("Actual Result: " + actualResult[0]);

            DecimalFormat df = new DecimalFormat("0.00");

            String expectedResult = df.format((current - previous) / gas);
            System.out.println("Expected result = " + expectedResult);

            if (currentRow.getCell(4) == null) {
                currentRow.createCell(4);
            }

            currentRow.getCell(4).setCellValue(expectedResult);

            if (currentRow.getCell(5) == null) {
                currentRow.createCell(5);
            }

            currentRow.getCell(5).setCellValue(actualResult[0]);

            if (currentRow.getCell(6) == null) {
                currentRow.createCell(6);
            }
            if (expectedResult.equals(actualResult[0])) {
                currentRow.getCell(6).setCellValue("Pass!");
            } else {
                currentRow.getCell(6).setCellValue("Fail!");
            }

            if (currentRow.getCell(7) == null) {
                currentRow.createCell(7);
            }

            currentRow.getCell(7).setCellValue(LocalDateTime.now().toString());
        }

        fileOutputStream = new FileOutputStream(path);
        workbook.write(fileOutputStream);

        workbook.close();
        fileInputStream.close();
        fileOutputStream.close();




        Driver.getDriver().close();


    }
}
