package PageObject;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.JavascriptExecutor;

public class Landing {
    private WebDriver driver;

    //Верхняя кнопка Заказать
    private By orderButtonUp = By.className("Button_Button__ra12g");

    //Нижняя кнопка Заказать
    private By orderButtonDown = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM']");

    private By closeCookie = By.id("rcc-confirm-button");

    //Кнопк

    public Landing (WebDriver driver) {
        this.driver = driver;
    }

    public void clickCloseCookie() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(closeCookie));
        driver.findElement(closeCookie).click();
    }

    public void clickOrderButtonUp() {
        driver.findElement(orderButtonUp).click();
    }

    public void clickOrderButtonDown() {
        WebElement element = driver.findElement(orderButtonDown);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
        driver.findElement(orderButtonDown).click();
    }

    public void clickOrderButton(int buttonNumber) {
        if (buttonNumber == 1) {
            driver.findElement(orderButtonUp).click();
        } else {
            WebElement element = driver.findElement(orderButtonDown);
            ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView();", element);
            driver.findElement(orderButtonDown).click();
        }
    }
}
