import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import static org.testng.Assert.assertFalse;
import static org.testng.Assert.assertTrue;

public class Checkboxes {
    @Test
    public void categoryCheckboxes() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.get("http://the-internet.herokuapp.com/checkboxes");
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebElement element1 = browser.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]"));
        Boolean isSelect = element1.isSelected();
        assertFalse(isSelect, "Ошибка, элемент выбран");
        element1.click();
        isSelect = element1.isSelected();
        assertTrue(isSelect, "Ошибка, элемент не выбран");

        ArrayList<WebElement> checkboxes = new ArrayList<WebElement>();
        checkboxes.addAll(0, browser.findElements(By.xpath("//*[@id=\"checkboxes\"]/input[1]")));

        WebElement element2 = checkboxes.get(0);
        isSelect = element2.isSelected();
        assertTrue(isSelect, "Ошибка, элемент не выбран");
        element2.click();
        isSelect = element2.isSelected();
        assertFalse(isSelect, "Ошибка, элемент выбран");

        browser.quit();
    }
}

