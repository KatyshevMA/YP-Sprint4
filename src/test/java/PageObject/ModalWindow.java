package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ModalWindow {
    private WebDriver driver;

    //Кнопка Да
    private By yesButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Да']");
    //Кнопка Нет
    private By noButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Нет']");

    public ModalWindow(WebDriver driver) {
        this.driver = driver;
    }

    public void clickYesButton() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(yesButton));
        driver.findElement(yesButton).click();
    }

    public void clickNoButton() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(noButton));
        driver.findElement(noButton).click();
    }

}
