package Test;;
import org.testng.annotations.Test;

public class ExcelDataTest {



    @Test(dataProvider = "excelDataProvider")
    public void testLoginCase1(String usuario, String contrasenia){
        System.out.println(usuario);
        System.out.println(contrasenia);

    }

}
