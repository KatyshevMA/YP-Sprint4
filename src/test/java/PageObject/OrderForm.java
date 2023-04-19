package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class OrderForm {
    private WebDriver driver;

    //Заголовок
    private  By header = By.className("Order_Header__BZXOb");
    //Инпут Имя
    private By name = By.xpath(".//input[@placeholder='* Имя']");
    //Инпут Фамилия
    private By lastname = By.xpath(".//input[@placeholder='* Фамилия']");
    //Инпут Адрес
    private By address = By.xpath(".//input[@placeholder='* Адрес: куда привезти заказ']");
    //Инпут Станция метро
    private By station = By.xpath(".//input[@placeholder='* Станция метро']");

    private By nameStation = By.xpath(".//div[@class='select-search__select']/ul/li/button[@value='4']");
    //Инпут Номер телефона
    private By phone = By.xpath(".//input[@placeholder='* Телефон: на него позвонит курьер']");
    //Кнопка Далее
    private By nextButton = By.xpath(".//button[@class = 'Button_Button__ra12g Button_Middle__1CSJM']");



    public OrderForm(WebDriver driver) {
        this.driver = driver;
    }

    public String checkHeader() {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(header));
        return driver.findElement(header).getText();
    }

    public void inputName(String newName) {
        new WebDriverWait(driver, 3)
                .until(ExpectedConditions.visibilityOfElementLocated(name));
        driver.findElement(name).click();
        driver.findElement(name).sendKeys(newName);
    }

    public void inputLastname(String newLastname) {
        driver.findElement(lastname).click();
        driver.findElement(lastname).sendKeys(newLastname);
    }

    public void inputAddress(String newAddress) {
        driver.findElement(address).click();
        driver.findElement(address).sendKeys(newAddress);
    }

    public void selectStation() {
        driver.findElement(station).click();
        driver.findElement(nameStation).click();
    }

    public void inputPhone(String newPhone) {
        driver.findElement(phone).click();
        driver.findElement(phone).sendKeys(newPhone);
    }

    public void clickNextButton() {
        driver.findElement(nextButton).click();
    }

}
