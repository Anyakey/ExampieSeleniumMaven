import org.hamcrest.JMock1Matchers;
import org.hamcrest.MatcherAssert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.Matchers.equalTo;

public class MultiplexTests {
    By menuTextCss = By.cssSelector(".mob_container > div.menu-block >.menu-block-heading");
    @Test
    public void checkMenuBtn() {
        System.setProperty("webdriver.chrome.driver", "/tools/chromedriver.exe");
        ChromeDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.manage().window().maximize();
        driver.get("https://multiplex.ua");
        driver.findElement(By.cssSelector(".yes")).click();
        driver.findElement(By.cssSelector(".menu-btn")).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOfElementLocated(menuTextCss));
        String menuText = driver
                .findElement(menuTextCss)
                .getText();
        assertThat(menuText, equalTo("ОСОБИСТИЙ КАБІНЕТ"));
    driver.quit();
    }
}
