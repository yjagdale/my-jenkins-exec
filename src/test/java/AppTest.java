import io.github.bonigarcia.wdm.ChromeDriverManager;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.net.MalformedURLException;
import java.net.URL;

public class AppTest {

    WebDriver driver;
    String baseURL, nodeURL;


    private void openBrowser() throws MalformedURLException {
        baseURL = "http://demo.guru99.com/test/guru99home/";
        nodeURL = System.getProperty("HUB") == null ?
                "http://jenkins-lets-learn.westus2.cloudapp.azure.com:443/wd/hub"
                : System.getProperty("HUB");
        DesiredCapabilities capability = DesiredCapabilities.chrome();
        capability.setBrowserName("chrome");
        driver = new RemoteWebDriver(new URL(nodeURL), capability);
    }


    @Test
    public void testThis() throws MalformedURLException {
        if (driver == null) {
            openBrowser();
        }
        driver.get(baseURL);
    }

    @Test
    public void testThisToo() throws InterruptedException, MalformedURLException {
        if (driver == null) {
            openBrowser();
        }
        Thread.sleep(5000);
        driver.quit();
    }

}
