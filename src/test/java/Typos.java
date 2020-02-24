import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class Typos {
    @Test
    public void categoryTypos() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.get("http://the-internet.herokuapp.com/typos");
        browser.manage().window().maximize();

        for (int a = 0; a < 10; a++) {
            browser.navigate().refresh();
            String mistake = browser.findElement(By.xpath("//*[@id=\"content\"]/div/p[2]")).getText();
            assertEquals(mistake, "Sometimes you'll see a typo, other times you won't.", "Error: 'won,t'");
        }

        browser.quit();
    }
}
