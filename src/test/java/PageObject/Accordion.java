package PageObject;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Accordion {
    private WebDriver driver;

    //Панели аккордеона
    private By button1 = By.xpath(".//div[@aria-controls = 'accordion__panel-0']");
    private By button2 = By.xpath(".//div[@aria-controls = 'accordion__panel-1']");
    private By button3 = By.xpath(".//div[@aria-controls = 'accordion__panel-2']");
    private By button4 = By.xpath(".//div[@aria-controls = 'accordion__panel-3']");
    private By button5 = By.xpath(".//div[@aria-controls = 'accordion__panel-4']");
    private By button6 = By.xpath(".//div[@aria-controls = 'accordion__panel-5']");
    private By button7 = By.xpath(".//div[@aria-controls = 'accordion__panel-6']");
    private By button8 = By.xpath(".//div[@aria-controls = 'accordion__panel-7']");

    //Ответы аккордиона
    private By answer1 = By.xpath(".//div[@aria-labelledby = 'accordion__heading-0']/p");
    private By answer2 = By.xpath(".//div[@aria-labelledby = 'accordion__heading-1']/p");
    private By answer3 = By.xpath(".//div[@aria-labelledby = 'accordion__heading-2']/p");
    private By answer4 = By.xpath(".//div[@aria-labelledby = 'accordion__heading-3']/p");
    private By answer5 = By.xpath(".//div[@aria-labelledby = 'accordion__heading-4']/p");
    private By answer6 = By.xpath(".//div[@aria-labelledby = 'accordion__heading-5']/p");
    private By answer7 = By.xpath(".//div[@aria-labelledby = 'accordion__heading-6']/p");
    private By answer8 = By.xpath(".//div[@aria-labelledby = 'accordion__heading-7']/p");

    public Accordion(WebDriver driver) {
        this.driver = driver;
    }

    public void clickButton(int buttonNumber) {
        if (buttonNumber == 1) {
            driver.findElement(button1).click();
        } else if (buttonNumber == 2) {
            driver.findElement(button2).click();
        } else if (buttonNumber == 3) {
            driver.findElement(button3).click();
        } else if (buttonNumber == 4) {
            driver.findElement(button4).click();
        } else if (buttonNumber == 5) {
            driver.findElement(button5).click();
        } else if (buttonNumber == 6) {
            driver.findElement(button6).click();
        } else if (buttonNumber == 7) {
            driver.findElement(button7).click();
        } else if (buttonNumber == 8) {
            driver.findElement(button8).click();
        }
    }

    public String givAnswer(int buttonNumber) {
        if (buttonNumber == 1) {
            new WebDriverWait(driver, 3)
                    .until(ExpectedConditions.visibilityOfElementLocated(answer1));
            return driver.findElement(answer1).getText();
        } else if (buttonNumber == 2) {
            new WebDriverWait(driver, 3)
                    .until(ExpectedConditions.visibilityOfElementLocated(answer2));
            return driver.findElement(answer2).getText();
        } else if (buttonNumber == 3) {
            new WebDriverWait(driver, 3)
                    .until(ExpectedConditions.visibilityOfElementLocated(answer3));
            return driver.findElement(answer3).getText();
        } else if (buttonNumber == 4) {
            new WebDriverWait(driver, 3)
                    .until(ExpectedConditions.visibilityOfElementLocated(answer4));
            return driver.findElement(answer4).getText();
        } else if (buttonNumber == 5) {
            new WebDriverWait(driver, 3)
                    .until(ExpectedConditions.visibilityOfElementLocated(answer5));
            return driver.findElement(answer5).getText();
        } else if (buttonNumber == 6) {
            new WebDriverWait(driver, 3)
                    .until(ExpectedConditions.visibilityOfElementLocated(answer6));
            return driver.findElement(answer6).getText();
        } else if (buttonNumber == 7) {
            new WebDriverWait(driver, 3)
                    .until(ExpectedConditions.visibilityOfElementLocated(answer7));
            return driver.findElement(answer7).getText();
        } else {
            new WebDriverWait(driver, 3)
                    .until(ExpectedConditions.visibilityOfElementLocated(answer8));
            return driver.findElement(answer8).getText();
        }
    }

    public void scrollToAccordion() {
        WebElement element = driver.findElement(button8);
        ((JavascriptExecutor)driver).executeScript("arguments[0].scrollIntoView();", element);
    }



}
