import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Hovers {
    @Test
    public void categoryHovers() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver.exe");
        WebDriver browser = new ChromeDriver();
        browser.get("http://the-internet.herokuapp.com/hovers");
        browser.manage().window().maximize();
        browser.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);

        WebElement user1 = browser.findElement(By.xpath("//div[@id='content']//descendant::div[@class='figure'][1]"));
        WebElement user2 = browser.findElement(By.xpath("//div[@id='content']//descendant::div[@class='figure'][2]"));
        WebElement user3 = browser.findElement(By.xpath("//div[@id='content']//descendant::div[@class='figure'][3]"));

        Actions hoverAction = new Actions(browser);
        hoverAction.moveToElement(user1).build().perform();
        WebElement user1Name = browser.findElement(By.xpath("//h5[text()='name: user1']"));
        WebElement patton1 = browser.findElement(By.xpath("//*[@id=\"content\"]/div/div[1]/div/a"));
        Assert.assertTrue(user1Name.isDisplayed());
        patton1.click();
        WebElement ver1 = browser.findElement(By.xpath("//h1[text()='Not Found']"));
        Assert.assertTrue(ver1.isDisplayed());
        browser.navigate().back();

        user2 = browser.findElement(By.xpath("//div[@id='content']//descendant::div[@class='figure'][2]"));
        hoverAction.moveToElement(user2).build().perform();
        WebElement user2Name = browser.findElement(By.xpath("//h5[text()='name: user2']"));
        WebElement patton2 = browser.findElement(By.xpath("//*[@id=\"content\"]/div/div[2]/div/h5"));
        Assert.assertTrue(user2Name.isDisplayed());
        patton2.click();
        WebElement ver2 = browser.findElement(By.xpath("//h1[text()='Not Found']"));
        Assert.assertTrue(ver2.isDisplayed());
        browser.navigate().back();

        user3 = browser.findElement(By.xpath("//div[@id='content']//descendant::div[@class='figure'][3]"));
        hoverAction.moveToElement(user3).build().perform();
        WebElement user3Name = browser.findElement(By.xpath("//h5[text()='name: user3']"));
        WebElement patton3 = browser.findElement(By.xpath("//*[@id=\"content\"]/div/div[3]/div/h5"));
        Assert.assertTrue(user3Name.isDisplayed());
        patton3.click();
        WebElement ver3 = browser.findElement(By.xpath("//h1[text()='Not Found']"));
        Assert.assertTrue(ver3.isDisplayed());
        browser.navigate().back();

        browser.quit();
    }
}
