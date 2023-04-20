import PageObject.Accordion;
import PageObject.Landing;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import static org.junit.Assert.assertEquals;

@RunWith(Parameterized.class)
public class CheckAccordion {
    private static final String ANSWER1 = "Сутки — 400 рублей. Оплата курьеру — наличными или картой.";
    private static final String ANSWER2 = "Пока что у нас так: один заказ — один самокат. Если хотите покататься с друзьями, можете просто сделать несколько заказов — один за другим.";
    private static final String ANSWER3 = "Допустим, вы оформляете заказ на 8 мая. Мы привозим самокат 8 мая в течение дня. Отсчёт времени аренды начинается с момента, когда вы оплатите заказ курьеру. Если мы привезли самокат 8 мая в 20:30, суточная аренда закончится 9 мая в 20:30.";
    private static final String ANSWER4 = "Только начиная с завтрашнего дня. Но скоро станем расторопнее.";
    private static final String ANSWER5 = "Пока что нет! Но если что-то срочное — всегда можно позвонить в поддержку по красивому номеру 1010.";
    private static final String ANSWER6 = "Самокат приезжает к вам с полной зарядкой. Этого хватает на восемь суток — даже если будете кататься без передышек и во сне. Зарядка не понадобится.";
    private static final String ANSWER7 = "Да, пока самокат не привезли. Штрафа не будет, объяснительной записки тоже не попросим. Все же свои.";
    private static final String ANSWER8 = "Да, обязательно. Всем самокатов! И Москве, и Московской области.";

    private WebDriver driver;
    private int panelNumber;
    private String answer;


    public CheckAccordion(int panelNumber, String answer) {
        this.panelNumber = panelNumber;
        this.answer = answer;
    }

    @Parameterized.Parameters
    public static Object[][] getVariables() {
        //Тестовые данные
        return new Object[][]{
                {1, ANSWER1},
                {2, ANSWER2},
                {3, ANSWER3},
                {4, ANSWER4},
                {5, ANSWER5},
                {6, ANSWER6},
                {7, ANSWER7},
                {8, ANSWER8},
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

        Accordion objAccordion = new Accordion(driver);
        objAccordion.scrollToAccordion();
        objAccordion.clickButton(panelNumber);
        String actual = objAccordion.givAnswer(panelNumber);
        assertEquals("Ответ в аккордионе не соответствует ожидаемому на кнопке №" + panelNumber, answer, actual);
    }

    @After
    public void teardown() {
        // Закрой браузер
        driver.quit();
    }
}
