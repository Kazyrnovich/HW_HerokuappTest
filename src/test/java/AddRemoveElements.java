import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertEquals;

public class AddRemoveElements {
    @Test
    public void categoryAddRemove() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.get("http://the-internet.herokuapp.com/add_remove_elements/");
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        WebElement element1 = browser.findElement(By.xpath("//*[@onclick='addElement()']"));
        element1.click();
        element1.click();
        WebElement element2 = browser.findElement(By.xpath("//button[text()='Delete']"));
        element2.click();

        ArrayList deleteButtons = (ArrayList) browser.findElements(By.xpath("//*[@onclick='deleteElement()']"));
        assertEquals(deleteButtons.size(), 1, "Количество кнопок не равно 1");

        browser.quit();
    }
}


