package com.accelerators;

import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import report.ReporterConstants;


public class TestEngineWeb {

	public static final Logger LOG = Logger.getLogger(TestEngineWeb.class);
	protected WebDriver WebDriver = null;
	public static EventFiringWebDriver Driver = null;
	public DesiredCapabilities capabilitiesForAppium = new DesiredCapabilities();
	public static String browser = ReporterConstants.BROWSER_NAME;
	public static String platform = ReporterConstants.PLATFORM_TYPE;




	public  void driverInitiation(String url)  {
		try {


					LOG.info("iam in case Chrome");
					System.setProperty("webdriver.chrome.driver", ".//resources//ChromeForWindows//chromedriver.exe");
					DesiredCapabilities capabilities = DesiredCapabilities.chrome();
					ChromeOptions options = new ChromeOptions();
					options.addArguments("test-type");
					capabilities.setCapability(ChromeOptions.CAPABILITY, options);
					this.WebDriver = new ChromeDriver(capabilities);


				Driver = new EventFiringWebDriver(this.WebDriver);
				Driver.get(url);
				Driver.manage().window().maximize();
				Driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
				LOG.info(" driver in test engine .." + Driver);


		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	

}
