package application;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.io.FileHandler;

public class UI_TestingOnFirefox_TC1 {

	public static void main(String[] args) throws Exception {
		WebDriver driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        String[] urls = {
            "https://www.getcalley.com/",
            "https://www.getcalley.com/calley-lifetime-offer/",
            "https://www.getcalley.com/see-a-demo/",
            "https://www.getcalley.com/calley-teams-features/",
            "https://www.getcalley.com/calley-pro-features/"
        };

        String[] img = {
            "URL_Screenshot1.jpeg",
            "URL_Screenshot2.jpeg",
            "URL_Screenshot3.jpeg",
            "URL_Screenshot4.jpeg",
            "URL_Screenshot5.jpeg"
        };
        
        

        for (int i = 0; i < urls.length; i++) {
            driver.get("https://www.getcalley.com/page-sitemap.xml");
            driver.findElement(By.linkText(urls[i])).click();

            TakesScreenshot screenshot = (TakesScreenshot) driver;
            File temp = screenshot.getScreenshotAs(OutputType.FILE);
            File parmt = new File("./FirefoxWpScreenShot/" + img[i]);
            FileHandler.copy(temp, parmt);

            Thread.sleep(2000);
            driver.navigate().back();
        }

        driver.quit();

	}


	}


