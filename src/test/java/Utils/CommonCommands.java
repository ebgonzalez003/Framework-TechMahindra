package Utils;
import com.aventstack.extentreports.ExtentTest;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.time.Duration;
import java.util.List;


public class CommonCommands {
    public WebDriver driver;
    WebDriverWait wait;
    Actions actions;
    public ExtentTest test;

    // Constructor
    public CommonCommands(WebDriver driver, ExtentTest test) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        this.actions = new Actions(driver);
        this.test = test;
    }

    // Method to click an element with explicit wait
    public void clickElement(By locator) {
        try{
            WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
            element.click();
            test.pass("Successfully click on element " + locator );
        }catch (Exception e){
            test.fail("Not able to click on element" + locator) ;
        }
    }

    // Method to send text to an input field with explicit wait
    public void sendKeysToElement(By locator, String text) {
       try {
           WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
           element.clear();
           element.sendKeys(text);
           test.pass("Successfully Keys sent correctly  " + locator );
       }catch (Exception e){
           test.fail("The keys were not sent correctly " + locator) ;
       }
    }

    // Method to handle a list of elements
    public List<WebElement> getElements(By locator) {
        return driver.findElements(locator);
    }

    // Method to click a specific item within a list
    public void clickElementFromList(By locator, int index) {
        List<WebElement> elements = wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
        elements.get(index).click();
    }

    // Method to select an option by visible text in a dropdown (Select element)
    public void selectOptionByText(By locator, String visibleText) {
        WebElement dropdownElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByVisibleText(visibleText);
    }

    // Method to select an option by value in a dropdown (Select element)
    public void selectOptionByValue(By locator, String value) {
        WebElement dropdownElement = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        Select dropdown = new Select(dropdownElement);
        dropdown.selectByValue(value);
    }

    // Method to get the text of an element
    public String getTextFromElement(By locator) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        return element.getText();
    }

    // Method to check if an element is present
    public boolean isElementPresent(By locator) {
        try {
            wait.until(ExpectedConditions.presenceOfElementLocated(locator));
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    public boolean waitForElementToDisappear(By by) {
        try {

            return wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
        } catch (Exception e) {
            return false;
        }
    }
    // Método para esperar hasta que un elemento sea visible por un máximo de 10 segundos
    public void waitForElementToBeVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    // Método para esperar hasta que un elemento sea clickeable por un máximo de 10 segundos
    public void waitForElementToBeClickable(By element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    public void scrollToElement(By locator) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        actions.moveToElement(element).perform();
    }


    public void scrollToElementAndClick(By locator) {
        WebElement element = wait.until(ExpectedConditions.elementToBeClickable(locator));
        actions.moveToElement(element).click().perform();
    }
    // Method to check if an element is visible
    public boolean isElementVisible(By locator) {
        try {
            WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            return element.isDisplayed();
        } catch (Exception e) {
            return false;
        }

    }
    // Método para hacer clic y mantener presionado (click and hold)
    public void clickAndHoldActions(By locator) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        actions.clickAndHold(element).perform();
    }
    // Método para hacer doble clic en un elemento
    public void doubleClickActions(By locator) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        actions.doubleClick(element).perform();
    }
    // Método para arrastrar y soltar (drag and drop) de un elemento a otro
    public void dragAndDropActions(By sourceLocator, By targetLocator) {
        WebElement sourceElement = wait.until(ExpectedConditions.visibilityOfElementLocated(sourceLocator));
        WebElement targetElement = wait.until(ExpectedConditions.visibilityOfElementLocated(targetLocator));
        actions.dragAndDrop(sourceElement, targetElement).perform();
    }
    // Método para mover el mouse sobre un elemento (hover)
    public void hoverOverElementActions(By locator) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        actions.moveToElement(element).perform();
    }
    // Método para arrastrar un elemento por ciertos offsets (drag and drop by offset)
    public void dragAndDropByOffsetActions(By locator, int xOffset, int yOffset) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        actions.dragAndDropBy(element, xOffset, yOffset).perform();
    }
    // Método para hacer clic derecho (context click)
    public void rightClickActions(By locator) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        actions.contextClick(element).perform();
    }
    // Método para enviar teclas de teclado a un elemento (teclas como ENTER, TAB, etc.)
    public void sendKeysToElementActions(By locator, CharSequence... keys) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        actions.sendKeys(element, keys).perform();
    }
    // Método para hacer clic en un elemento en un lugar específico (por coordenadas relativas al elemento)
    public void clickAtPositionActions(By locator, int xOffset, int yOffset) {
        WebElement element = wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
        actions.moveToElement(element, xOffset, yOffset).click().perform();
    }

}
