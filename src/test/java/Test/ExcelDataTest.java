package Test;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import Utils.ExcelUtils;

public class ExcelDataTest {

    @DataProvider(name = "excelData")
    public Object[][] excelDataProvider() {
        String filePath = "ruta/a/tu/archivo.xlsx";
        String sheetName = "Hoja1";
        return ExcelUtils.getExcelData(filePath, sheetName);
    }

    @Test(dataProvider = "excelData")
    public void testWithExcelData(String col1, String col2, String col3) {
        // Aquí puedes usar los datos del Excel en tu prueba
        System.out.println("Datos: " + col1 + ", " + col2 + ", " + col3);
    }
}
