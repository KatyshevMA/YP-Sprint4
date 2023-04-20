import PageObject.*;
import org.junit.After;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

@RunWith(Parameterized.class)
public class ClientWay {

    private WebDriver driver;
    private int buttonNumber;
    private String newName;
    private String newLastname;
    private String newAddress;
    private String newPhone;
    private int checkBoxNumber;
    private String newComment;

    public ClientWay(int buttonNumber, String newName, String newLastname, String newAddress, String newPhone, int checkBoxNumber, String newComment) {
        this.buttonNumber = buttonNumber;
        this.checkBoxNumber = checkBoxNumber;
        this.newName = newName;
        this.newLastname = newLastname;
        this.newAddress = newAddress;
        this.newPhone = newPhone;
        this.newComment = newComment;

    }

    @Parameterized.Parameters
    public static Object[][] getVariables() {
        //Тестовые данные
        return new Object[][]{
                {1, "Попов", "Виталий", "г. Балашиха, ул. Цветкова, д. 5, корп. 3, кв. 24", "+79053337575", 1, "Везите аккуратно"},
                {2, "Иванов", "Алексей", "г. Мурманск, пл. Победы, д. 111", "+79053337575", 2, "Везите аккуратно"},
                //{2, "Я", "Я", "1", "85557776622", 1, "Я"},
                //{1, "Константинопольский", "Константин Витальевич", "г. Москва, ул. Арбат, д. 8, корп. 3, кв. 1", "34567", 2, "Выберите самый лучший"},
                //{2, "Иванов-Каменский", "Виталий", "Красная Площадь", "+7(495)-555-66-77", 2, "Быстрее"},

        };
    }

    @Test
    public void checkClientWay() {
        //WebDriver driver = new FirefoxDriver();
        WebDriver driver = new ChromeDriver();
        driver.get("https://qa-scooter.praktikum-services.ru/");

        //Клик по кнопке Заказать
        Landing objLanding = new Landing(driver);
        objLanding.clickCloseCookie();
        objLanding.clickOrderButton(buttonNumber); //1 - для верхней, 2 - для нижней

        //Заполнить поля формы Для кого самокат
        OrderForm objOrderForm = new OrderForm(driver);
        objOrderForm.inputName(newName);
        objOrderForm.inputLastname(newLastname);
        objOrderForm.inputAddress(newAddress);
        objOrderForm.selectStation();
        objOrderForm.inputPhone(newPhone);
        objOrderForm.clickNextButton();

        //Заполнить поля формы Про аренду
        Rent objRent = new Rent(driver);
        objRent.selectDate();
        objRent.selectPeriod();
        objRent.clickCheckBox(checkBoxNumber); //1 - для черного, 2 - для серого
        objRent.inputComment(newComment);
        objRent.clickNextButton();

        //Кликнуть Да в модальном окне
        ModalWindow objModalWindow = new ModalWindow(driver);
        objModalWindow.clickYesButton();

        //Кликнуть Просмотреть статус в модальном окне
        SuccesOrder objSuccesOrder = new SuccesOrder(driver);
        objSuccesOrder.checkSeeStatusButton();

        //Проверить что появился блок со статусом заказа
        Assert.assertTrue(objSuccesOrder.checkStatus());

    }

    @After
    public void teardown() {
        driver.quit();
    }

}
