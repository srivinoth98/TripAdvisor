package testbase;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.safari.SafariDriver;
import utils.GenericUtils;

import java.io.FileInputStream;
import java.time.Duration;
import java.util.Properties;

public class DriverSetUp {
    public static WebDriver driver;
    public static Properties prop;

    public DriverSetUp() {
        try {
            prop = new Properties();
            FileInputStream fileInputStream = new FileInputStream(System.getProperty("user.dir") + "/src/main/resources/config.properties");
            prop.load(fileInputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void initialization() {
        String browserName = prop.getProperty("browserName");

        if (browserName.equalsIgnoreCase("chrome")) {

            ChromeOptions options = new ChromeOptions();
            options.addArguments("--remote-allow-origins=*");
            System.setProperty("webdriver.chrome.driver", "C:/Users/User/Downloads/chromedriver_win32/chromedriver.exe");
            driver = new ChromeDriver(options);
        } else if (browserName.equalsIgnoreCase("firefox")) {
            System.setProperty("webdriver.gecko.driver", System.getProperty("user.dir") + "/src/main/resources/driver/chromedriver.exe");
            driver = new FirefoxDriver();
        } else if (browserName.equalsIgnoreCase("edge")) {
            System.setProperty("webdriver.edge.driver", System.getProperty("user.dir") + "/src/main/resources/driver/chromedriver.exe");
            driver = new EdgeDriver();
        } else if (browserName.equalsIgnoreCase("ie")) {
            System.setProperty("webdriver.ie.driver", System.getProperty("user.dir") + "/src/main/resources/driver/chromedriver.exe");
            driver = new InternetExplorerDriver();
        } else if (browserName.equalsIgnoreCase("safari")) {
            System.setProperty("webdriver.safari.driver", System.getProperty("user.dir") + "/src/main/resources/driver/chromedriver.exe");
            driver = new SafariDriver();

        } else {
            try {
                throw new Exception("Please enter the valid browser name");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        driver.get(prop.getProperty("url"));
        driver.manage().window().maximize();
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(GenericUtils.PAGE_LOAD_WAIT));
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(GenericUtils.IMPLICIT_WAIT));
        driver.manage().deleteAllCookies();
    }
}