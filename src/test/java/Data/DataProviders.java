package Data;

import Utils.ExcelUtils;
import org.testng.annotations.DataProvider;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

public class DataProviders {

    @DataProvider(name = "excelDataProvider")
    public static Object[][] getDataFromExcel(Method method) {
        String excelPath = "src/test/resources/DataProviders/ShopingTestData/loginDataProvider.xlsx";
        String sheetName = "Hoja 1";
        String testCaseName = method.getName();
        List<Map<String, String>> allData = ExcelUtils.getExcelDataByHeaders(excelPath, sheetName);
        return allData.stream()
                .filter(data -> data.get("TestCase").equals(testCaseName))
                .map(data -> new Object[] {data.get("Username"), data.get("Password")})
                .toArray(Object[][]::new);
    }

    @DataProvider(name = "excelPaymentData")
    public static Object[][] getPaymentData(Method method) {
        String excelPath = "src/test/resources/DataProviders/ShopingTestData/loginDataProvider.xlsx";
        String sheetName = "Hoja 2";
        String testCaseName = method.getName();
        List<Map<String, String>> allData = ExcelUtils.getExcelDataByHeaders(excelPath, sheetName);
        return allData.stream()
                .filter(data -> data.get("TestCase").equals(testCaseName))
                .map(data -> new Object[] {data.get("Username"), data.get("Password")})
                .toArray(Object[][]::new);
    }

}
