package Utils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;
import java.io.File;
import java.io.IOException;

public class ScreenshotUtils {

    public static String takeScreenshot(WebDriver driver, String testName) {
        TakesScreenshot ts = (TakesScreenshot) driver;
        File source = ts.getScreenshotAs(OutputType.FILE);
        String dest = System.getProperty("user.dir") + "/screenshots/" + testName + ".png";
        try {
            FileHandler.copy(source, new File(dest));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dest;
    }
}
