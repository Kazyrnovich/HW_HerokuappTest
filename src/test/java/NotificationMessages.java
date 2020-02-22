import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class NotificationMessages {
    @Test
    public void categoryNotMes() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.get("http://the-internet.herokuapp.com/notification_message_rendered");
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement element1 = browser.findElement(By.xpath("//*[@id=\"content\"]/div/p/a"));
        element1.click();
        browser.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement element2 = browser.findElement(By.id("flash"));
        String value = element2.getAttribute("innerText"); //взять весь текст
        assertEquals(value, "Action unsuccesful, please try again\n" + "×", "Неверное сообщение");
        /* ошибка на сайте в локаторе

            Action unsuccesful, please try again
            написано с одним "s"
         */
        browser.quit();

    }
}
