package Test;


import Utils.ExcelUtils;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.lang.reflect.Method;
import java.util.List;
import java.util.Map;

public class ExcelDataTest {



    @Test(dataProvider = "excelDataProvider")
    public void testLoginCase1(String usuario, String contrasenia){
        System.out.println(usuario);
        System.out.println(contrasenia);

    }

}
