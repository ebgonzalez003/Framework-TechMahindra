package Test;
import com.aventstack.extentreports.ExtentTest;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import Utils.ExtentReportManager;

import java.lang.reflect.Method;

public class ExcelDataTest {

    ExtentTest test;

    @BeforeClass
    public void setUp() {
        ExtentReportManager.getInstance(); // Inicia Extent Reports
    }

    @BeforeMethod
    public void beforeTest(Method method) {
        test = ExtentReportManager.createTest(method.getName()); // Crea un test para cada método
    }

    @Test(dataProvider = "excelData", dataProviderClass = ExcelDataTest.class)
    public void testWithExcelData(String col1, String col2, String col3) {
        try {
            test.info("Prueba iniciada con datos: " + col1 + ", " + col2 + ", " + col3);
            Assert.assertNotNull(col1);  // Solo un ejemplo de aserción
            test.pass("Prueba pasada exitosamente.");
        } catch (Exception e) {
            test.fail("La prueba falló: " + e.getMessage());
            throw e;
        }
    }

    @AfterMethod
    public void tearDown() {
        ExtentReportManager.closeReport();  // Genera y cierra el reporte al final del método
    }
}
