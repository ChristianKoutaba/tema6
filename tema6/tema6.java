import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;

public class tema6 {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\path\\to\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        try {
            driver.get("https://testpages.herokuapp.com/styled/index.html");
            driver.findElement(By.id("alerts")).click();
            try {
                driver.findElement(By.id("nonexistent-element"));
            } catch (NoSuchElementException e) {
                File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                Files.copy(screenshot.toPath(), new File("alert_page_error.png").toPath(), StandardCopyOption.REPLACE_EXISTING);
            }
            driver.navigate().back();
            driver.findElement(By.id("htmlformexample")).click();
            try {
                driver.findElement(By.id("nonexistent-element"));
            } catch (NoSuchElementException e) {
                File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                Files.copy(screenshot.toPath(), new File("html_form_example_error.png").toPath(), StandardCopyOption.REPLACE_EXISTING);
            }
            driver.navigate().back();
            driver.get("https://demoqa.com/browser-windows");
            try {
                driver.findElement(By.id("nonexistent-element"));
            } catch (NoSuchElementException e) {
                File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
                Files.copy(screenshot.toPath(), new File("browser_windows_page_error.png").toPath(), StandardCopyOption.REPLACE_EXISTING);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            driver.quit();
        }
    }
}
