package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SuccesOrder {
    private WebDriver driver;

    //Кнопка Посмотреть статус
    private By seeStatusButton = By.xpath(".//button[text()='Посмотреть статус']");
    //Блок со статусом заказа
    private By status = By.className("Order_ModalHeader__3FDaJ");

    public SuccesOrder(WebDriver driver) {
        this.driver = driver;
    }

    public void checkSeeStatusButton() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.elementToBeClickable(seeStatusButton));
    }

    public boolean checkStatus() {
        new WebDriverWait(driver, 3)
                .until(driver -> (driver.findElement(status).getText() != null));
        return true;
    }

}
