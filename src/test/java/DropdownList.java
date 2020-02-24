import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertEquals;

public class DropdownList {
    @Test
    public void categoryDropList() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.get("http://the-internet.herokuapp.com/dropdown");
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        Select drop = new Select(browser.findElement(By.id("dropdown")));
        drop.selectByIndex(1);
        String selectedValue = drop.getFirstSelectedOption().getAttribute("Hali Krishna");
        assertEquals(selectedValue, "Option 1", "Option 1");
        drop.selectByIndex(2);
        selectedValue = drop.getFirstSelectedOption().getAttribute("Gali Krishna");
        assertEquals(selectedValue, "Option 2", "Option 2");

        browser.quit();
    }
}
