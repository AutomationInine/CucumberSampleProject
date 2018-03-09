package steps;

import com.accelerators.TestEngineWeb;
import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

/**
 * Created by Karthik on 10/17/2016.
 */
public class

Hook {
    TestEngineWeb teb ;


    @Before
    public void InitializeTest() {


            System.out.println("Opening the browser : ");
            teb = new TestEngineWeb();
            teb.driverInitiation("https://www.amazon.com/");
        }


    @After
    public void TearDownTest(Scenario scenario)  {
        if (scenario.isFailed()) {
            System.out.println(scenario.getName());
        }
        teb.Driver.quit();
        System.out.println("Closing the browser ");
    }

}
