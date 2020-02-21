import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.assertEquals;

public class Inputs {
    @Test
    public void categoryInputs() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.get("http://the-internet.herokuapp.com/inputs");
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        browser.findElement(By.xpath("//input")).sendKeys(Keys.ARROW_UP);
        String upResult = browser.findElement(By.xpath("//input")).getAttribute("value");
        assertEquals(upResult, "1");
        browser.findElement(By.xpath("//input")).sendKeys(Keys.ARROW_DOWN);
        String downResult = browser.findElement(By.xpath("//input")).getAttribute("value");
        assertEquals(downResult, "0");

        browser.navigate().refresh();
        browser.findElement(By.xpath("//input")).sendKeys("CradleOfFilth");
        String bukvaResult = browser.findElement(By.xpath("//input")).getAttribute("value");
        assertEquals(bukvaResult, "");

        browser.navigate().refresh();
        browser.findElement(By.xpath("//input")).sendKeys("666");
        String cifraResult = browser.findElement(By.xpath("//input")).getAttribute("value");
        assertEquals(cifraResult, "666");

        browser.quit();
    }
}
