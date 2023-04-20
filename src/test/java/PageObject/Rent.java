package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Rent {
    private WebDriver driver;

    //Дата аренды
    private By date = By.xpath(".//input[@placeholder = '* Когда привезти самокат']");
    //Значение даты из календаря (последнее число на последней неделе)
    private By dateValue = By.xpath(".//div[@class = 'react-datepicker__month']/div[last()]/div[last()]");
    //Срок аренды
    private By period = By.className("Dropdown-control");
    //Значение в селект-листе срока аренды
    private By periodValue = By.xpath(".//div[@class='Dropdown-menu']/div[3]");
    //Чекбокс черного самоката
    private By checkBoxBlack = By.xpath(".//input[@id='black']");
    //Чекбокс серого самоката
    private By checkBoxGray = By.xpath(".//input[@id='grey']");
    //Комментарий для курьера
    private By comment = By.xpath(".//input[@placeholder='Комментарий для курьера']");
    //Кнопка Далее
    private By nextButton = By.xpath(".//div[@class='Order_Buttons__1xGrp']/button[text()='Заказать']");
    //Кнопка Назад
    private By backButton = By.xpath(".//button[text()='Назад']");



    public Rent(WebDriver driver) {
        this.driver = driver;
    }

    public void selectDate() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(date));
        driver.findElement(date).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(dateValue));
        driver.findElement(dateValue).click();
    }

    public void selectPeriod() {
        driver.findElement(period).click();
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(periodValue));
        driver.findElement(periodValue).click();
    }

    public void clickCheckBoxBlack() {
        driver.findElement(checkBoxBlack).click();
    }
    public void clickCheckBoxGray() {
        driver.findElement(checkBoxGray).click();
    }

    public void clickCheckBox(int boxNumber) {
        if (boxNumber == 1) {
            driver.findElement(checkBoxBlack).click();
        } else {
            driver.findElement(checkBoxGray).click();
        }
    }

    public void inputComment(String newComment) {
        driver.findElement(comment).click();
        driver.findElement(comment).sendKeys(newComment);
    }

    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }

    public void clickBackButton() {
        driver.findElement(backButton).click();
    }

}
