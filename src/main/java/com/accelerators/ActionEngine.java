package com.accelerators;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;


public class ActionEngine extends TestEngineWeb {
	private final Logger LOG = Logger.getLogger(ActionEngine.class);

	private final String msgClickSuccess = "Successfully Clicked On ";

	/**
	 * 
	 * @param locator
	 * @param locatorName
	 * @return
	 * @throws Throwable
	 */
	public boolean selectByIndex(By locator, int index, String locatorName)
			throws Throwable {
		boolean flag = true;
		try {
			Select s = new Select(Driver.findElement(locator));
			s.selectByIndex(index);
			LOG.info("Select by Index for " + locatorName);
		} catch (Exception e) {
			flag = false;
			LOG.info(e.getMessage());
			e.printStackTrace();
			takeScreenshot(locatorName);

		}
		return flag;
	}

	public boolean assertTrue(boolean conditon, String message)
			throws Throwable {
		boolean flag = false;
		try {
			if (conditon) {
				flag = true;
			} else
				throw new Exception();
		} catch (Exception e) {
			flag = false;
			LOG.info(e.getMessage());
			e.printStackTrace();
			takeScreenshot(message);
		}
		return flag;
	}

	public boolean assertElementPresent(By by, String locatorName)
			throws Throwable {

		boolean flag = false;
		try {
			if (isElementPresent(by, locatorName, true))
				flag = true;
			else
				throw new Exception();
		} catch (Exception e) {
			flag = false;
			LOG.info(e.getMessage());
			e.printStackTrace();
			takeScreenshot(locatorName);
		}
		return flag;
	}

	public boolean mouseHoverByJavaScript(By locator, String locatorName)
			throws Throwable {
		boolean flag = false;
		try {
			WebElement mo = Driver.findElement(locator);
			String javaScript = "var evObj = document.createEvent('MouseEvents');"
					+ "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);"
					+ "arguments[0].dispatchEvent(evObj);";
			JavascriptExecutor js = (JavascriptExecutor) Driver;
			js.executeScript(javaScript, mo);
			flag = true;
			return true;
		} catch (Exception e) {
			flag = false;
			LOG.info(e.getMessage());
			e.printStackTrace();
			takeScreenshot(locatorName);
		}
		return flag;
	}

	public boolean waitForVisibilityOfElement(By by, String locator)
			throws Throwable {
		boolean flag = false;
		WebDriverWait wait = new WebDriverWait(Driver, 500);
		try {
			wait.until(ExpectedConditions.visibilityOfElementLocated(by));
			flag = true;
			LOG.info("Wait for Visibility of Element : " + locator);
		} catch (Exception e) {
			flag = false;
			LOG.info(e.getMessage());
			e.printStackTrace();
			takeScreenshot(locator);
		}

		return flag;
	}

	public boolean waitForInVisibilityOfElement(By by, String locator)
			throws Throwable {
		boolean flag = false;
		WebDriverWait wait = new WebDriverWait(Driver, 500);
		try {
			wait.until(ExpectedConditions.invisibilityOfElementLocated(by));
			flag = true;
			LOG.info("Wait for Invisibility of Element : " + locator);
		} catch (Exception e) {
			flag = false;
			LOG.info(e.getMessage());
			e.printStackTrace();
			takeScreenshot(locator);
		}
		return flag;
	}

	public boolean waitForPresenceOfAllElements(By by, String locator)
			throws Throwable {
		boolean flag = false;
		WebDriverWait wait = new WebDriverWait(Driver, 500);
		try {
			wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(by));
			flag = true;
			LOG.info("Wait for Presence of All Elements : " + locator);
		} catch (Exception e) {
			flag = false;
			LOG.info(e.getMessage());
			e.printStackTrace();
			takeScreenshot(locator);
		}

		return flag;
	}
	
	public boolean clickUsingJavascriptExecutor(By locator, String locatorName)
			throws Throwable {
		boolean flag = false;
		try {
			WebElement element = Driver.findElement(locator);
			JavascriptExecutor executor = (JavascriptExecutor) Driver;
			executor.executeScript("arguments[0].click();", element);			
			flag = true;
			LOG.info("JS clicked on " + locatorName);
		} catch (Exception e) {
			flag = false;
			LOG.info(e.getMessage());
			e.printStackTrace();
			takeScreenshot(locatorName);
		}
		return flag;
	}

	public boolean selectByValue(By locator, String value, String locatorName)
			throws Throwable {
		boolean flag = false;
		try {
			Select s = new Select(Driver.findElement(locator));
			s.selectByValue(value);
			flag = true;
			LOG.info("Select by Value for : "+ locatorName);
		} catch (Exception e) {
			flag = false;
			LOG.info(e.getMessage());
			e.printStackTrace();
			takeScreenshot(locatorName);
		}
		return flag;
	}

	public boolean isVisible(By locator, String locatorName) throws Throwable {
		Boolean flag = false;
		try {
			flag = Driver.findElement(locator).isDisplayed();
			flag = true;
			LOG.info("Is Visible for : "+ locatorName);
		} catch (Exception e) {
			flag = false;
			LOG.info(e.getMessage());
			e.printStackTrace();
			takeScreenshot(locatorName);

		}
		return flag;
	}

	public int getRowCount(By locator) throws Exception {

		WebElement table = Driver.findElement(locator);
		List<WebElement> rows = table.findElements(By.tagName("tr"));
		int a = rows.size() - 1;
		return a;
	}

	public boolean assertTextMatching(By by, String text, String locatorName)
			throws Throwable {
		boolean flag = false;
		try {
			String ActualText = getText(by, text).trim();
			LOG.info("ActualText is " + ActualText);
			LOG.info("Expected Text is " + text);
			if (ActualText.contains(text.trim())) {
				flag = true;
				return true;
			} else {
				throw new Exception();
			}

		} catch (Exception e) {
			flag = false;
			LOG.info(e.getMessage());
			e.printStackTrace();
			takeScreenshot(locatorName);
		}
		return flag;
	}

	public boolean assertTextMatchingWithAttribute(By by, String text,
			String locatorName) throws Throwable {
		boolean flag = false;
		try {
			String ActualText = getAttributeByValue(by, text).trim();
			LOG.info("ActualText is" + ActualText);
			if (ActualText.contains(text.trim())) {
				flag = true;
				return true;
			} else {
				throw new Exception();
			}
		} catch (Exception e) {
			flag = false;
			LOG.info(e.getMessage());
			e.printStackTrace();
			takeScreenshot(locatorName);
		}
		return flag;
	}

	public boolean assertTextStringMatching(String acttext, String expText)
			throws Throwable {
		boolean flag = false;
		try {
			String ActualText = acttext.trim();

			LOG.info("act - " + ActualText);
			LOG.info("exp - " + expText);
			if (ActualText.equalsIgnoreCase(expText.trim())) {
				LOG.info("in if loop");
				flag = true;
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			flag = false;
			LOG.info(e.getMessage());
			e.printStackTrace();
			takeScreenshot("assert_" + expText);
		}
		return flag;
	}

	public boolean click(By locator, String locatorName) throws Throwable {
		boolean status = false;
		try {
			waitForElementByFluentWait(locator);
			Driver.findElement(locator).click();
			status = true;
			LOG.info(msgClickSuccess + locatorName);
			LOG.info("click on locator - " + locatorName);
		} catch (Exception e) {
			status = false;
			LOG.info(e.getMessage());
			e.printStackTrace();
			takeScreenshot(locatorName);
		}
		return status;
	}

	public void takeScreenshot(String locator) throws IOException {
		LOG.info("in screenshot method ...");
		// Dimension d = new Dimension(1200,650);//Added for screenshot size
		// shrinking
		// Driver.manage().window().setSize(d);
		File screenshot = ((TakesScreenshot) Driver)
				.getScreenshotAs(OutputType.FILE);
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		String time = sdf.format(cal.getTime()).toString();
		time = time.replaceAll(":", "_");

		FileUtils.copyFile(screenshot, new File(locator
				+ ".jpg"));

	}

	public boolean isElementPresent(By by, String locatorName, boolean expected)
			throws Throwable {
		boolean flag = false;
		try {
			Driver.findElement(by);
			flag = true;
			LOG.info("Element Present : "+ locatorName);
		} catch (Exception e) {
			flag = false;
			LOG.info(e.getMessage());
			e.printStackTrace();
			takeScreenshot(locatorName);
		}
		return flag;
	}

	public boolean isElementPresent(By by, String locatorName) throws Throwable {
		boolean status = false;
		try {
			Driver.findElement(by);
			status = true;
			LOG.info("Element Present : "+ locatorName);
		} catch (Exception e) {
			status = false;
			LOG.info(e.getMessage());
			e.printStackTrace();
			takeScreenshot(locatorName);
		}
		return status;
	}

	public boolean scroll(By by, String locatorName) throws Throwable {
		boolean status = false;
		try {
			WebElement element = Driver.findElement(by);
			Actions actions = new Actions(Driver);
			actions.moveToElement(element);
			actions.build().perform();
			status = true;
		} catch (Exception e) {
			status = false;
			LOG.info(e.getMessage());
			e.printStackTrace();
			takeScreenshot(locatorName);
		}
		return status;
	}

	public boolean VerifyElementPresent(By by, String locatorName,
			boolean expected) throws Throwable {
		boolean status = false;
		try {
			if (Driver.findElement(by).isDisplayed()) {
				status = true;
			}
			LOG.info("Verify Element Present : "+ locatorName);
		} catch (Exception e) {
			status = false;
			LOG.info(e.getMessage());
			e.printStackTrace();
			takeScreenshot(locatorName);
		}
		return status;
	}

	public boolean type(By locator, String testdata, String locatorName)
			throws Throwable {
		boolean flag = true;
		try {
			waitForElementByFluentWait(locator);
			Driver.findElement(locator).click();
			Driver.findElement(locator).sendKeys(testdata);

			LOG.info("type " + testdata + " in locator - " + locatorName);
		} catch (Exception e) {
			flag = false;
			LOG.info(e.getMessage());
			e.printStackTrace();
			takeScreenshot(locatorName);
		}
		return flag;
	}

	public boolean typeSecure(By locator, String testdata, String locatorName)
			throws Throwable {
		boolean flag = true;
		try {
			waitForElementByFluentWait(locator);
			Driver.findElement(locator).click();
			Driver.findElement(locator).clear();
			Driver.findElement(locator).clear();
			Driver.findElement(locator).sendKeys(testdata);
		} catch (Exception e) {
			flag = false;
			LOG.info(e.getMessage());
			e.printStackTrace();
			takeScreenshot(locatorName);
		}
		return flag;
	}

	public boolean typeUsingJavaScriptExecutor(By locator, String testdata,
			String locatorName) throws Throwable {

		boolean status = false;
		try {
			WebElement searchbox = Driver.findElement(locator);
			JavascriptExecutor myExecutor = ((JavascriptExecutor) Driver);
			myExecutor.executeScript("arguments[0].value='" + testdata + "';",
					searchbox);
			status = true;
			LOG.info("JS type on : "+ locatorName);
		} catch (Exception e) {
			status = false;
			LOG.info(e.getMessage());
			e.printStackTrace();
			takeScreenshot(locatorName);
		}
		return status;
	}

	/**
	 * Moves the mouse to the middle of the element. The element is scrolled
	 * into view and its location is calculated using getBoundingClientRect.
	 * 
	 * @param locator
	 *            : Action to be performed on element (Get it from Object
	 *            repository)
	 * 
	 *
	 * 
	 */
	public boolean waitForTitlePresent(By locator) throws Throwable {
		boolean bValue = false;

		try {
			for (int i = 0; i < 200; i++) {
				if (Driver.findElements(locator).size() > 0) {
					bValue = true;
					break;
				} else {
					Driver.wait(50);
				}
			}
		} catch (Exception e) {
			bValue = false;
			LOG.info(e.getMessage());
			e.printStackTrace();
			takeScreenshot("waitFailed_" + locator);
		}
		return bValue;
	}

	public String getTitle() throws Throwable {

		String text = Driver.getTitle();
		return text;
	}

	public boolean assertText(By by, String text) throws Throwable {
		boolean flag = false;
		try {
			if (getText(by, text).trim().equalsIgnoreCase(text.trim()))
				flag = true;
			else
				throw new Exception();
		} catch (Exception e) {
			flag = false;
			LOG.info(e.getMessage());
			e.printStackTrace();
			takeScreenshot("assertTextFailed_" + text);
		}

		return flag;
	}

	public boolean asserTitle(String title) throws Throwable {
		boolean flag = false;
		try {
			By windowTitle = By.xpath("//title[contains(text(),'" + title
					+ "')]");
			if (waitForTitlePresent(windowTitle)) {
				if (getTitle().equalsIgnoreCase(title))
					flag = true;
				else
					throw new Exception();
			} else {
				return false;
			}
		} catch (Exception ex) {
			flag = false;
			LOG.info(ex.getMessage());
			ex.printStackTrace();
			takeScreenshot("assertTitle_" + title);
		}
		return flag;
	}

	public String getText(By locator, String locatorName) throws Throwable {
		String text = "";
		try {
			waitForElementByFluentWait(locator);
			if (isElementPresent(locator, locatorName, true)) {
				text = Driver.findElement(locator).getText();
			}
		} catch (Exception e) {
			LOG.info(e.getMessage());
			e.printStackTrace();
			takeScreenshot(locatorName);
		}
		return text;
	}

	public String getAttributeByValue(By locator, String locatorName)
			throws Throwable {
		String text = "";
		try {
			if (isElementPresent(locator, locatorName, true)) {
				text = Driver.findElement(locator).getAttribute("value");
			}
		} catch (Exception e) {
			e.printStackTrace();
			LOG.info(e.getMessage());
			takeScreenshot(locatorName);
		}
		return text;
	}

	/**
	 * Moves the mouse to the middle of the element. The element is scrolled
	 * into view and its location is calculated using getBoundingClientRect.
	 * 
	 * @param locator
	 *            : Action to be performed on element (Get it from Object
	 *            repository)
	 * 
	 * @param locatorName
	 *            : Meaningful name to the element (Ex:link,menus etc..)
	 * 
	 */
	public boolean mouseover(By locator, String locatorName) throws Throwable {
		boolean flag = false;
		try {
			WebElement mo = Driver.findElement(locator);
			new Actions(Driver).moveToElement(mo).build().perform();
			flag = true;
			return true;
		} catch (Exception e) {
			flag = false;
			LOG.info(e.getMessage());
			e.printStackTrace();
			takeScreenshot(locatorName);
		}
		return flag;
	}

	public boolean JSClick(By locator, String locatorName) throws Throwable {
		boolean flag = false;
		try {
			WebElement element = Driver.findElement(locator);
			JavascriptExecutor executor = (JavascriptExecutor) Driver;
			executor.executeScript("arguments[0].click();", element);
			flag = true;
		} catch (Exception e) {
			flag = false;
			LOG.info(e.getMessage());
			e.printStackTrace();
			takeScreenshot(locatorName);
		}
		return flag;
	}

	public boolean selectByVisibleText(By locator, String visibletext,
			String locatorName) throws Throwable {
		boolean flag = false;
		try {
			Select s = new Select(Driver.findElement(locator));
			s.selectByVisibleText(visibletext.trim());
			flag = true;
			LOG.info("Select by Visible Text : "+ locatorName);
		} catch (Exception e) {
			flag = false;
			LOG.info(e.getMessage());
			e.printStackTrace();
			takeScreenshot(locatorName);
		}
		return flag;
	}

	public boolean JSmousehover(By locator, String locatorName)
			throws Throwable {
		boolean flag = false;
		try {
			WebElement HoverElement = Driver.findElement(locator);
			String mouseOverScript = "if(document.createEvent){var evObj = document.createEvent('MouseEvents');evObj.initEvent('mouseover',true, false); arguments[0].dispatchEvent(evObj);} else if(document.createEventObject) { arguments[0].fireEvent('onmouseover');}";
			((JavascriptExecutor) Driver).executeScript(mouseOverScript,
					HoverElement);
			flag = true;
			LOG.info("JS Mouse hover : "+ locatorName);
		} catch (Exception e) {
			flag = false;
			LOG.info(e.getMessage());
			e.printStackTrace();
			takeScreenshot(locatorName);
		}
		return flag;
	}

	public void sleep(int time) throws InterruptedException {
		Thread.sleep(time);
	}

	public boolean verify(String act, String exp, String value)
			throws Throwable {
		boolean flag = false;
		try {
			if (act.contains(exp)) {
				flag = true;
			}
			LOG.info("Verify String exp: "+exp+" act: "+act);
		} catch (Exception e) {
			flag = false;
			LOG.info(e.getMessage());
			e.printStackTrace();
			takeScreenshot("verifyFailed_" + exp);
		}
		return flag;
	}

	public boolean waitForElementPresent(By by, String locator, int secs)
			throws Throwable {
		boolean status = false;
		try {
			WebDriverWait wait = new WebDriverWait(Driver, 60);
			wait.until(ExpectedConditions.elementToBeClickable(by));
			for (int i = 0; i < secs / 2; i++) {
				List<WebElement> elements = Driver.findElements(by);
				if (elements.size() > 0) {
					status = true;
					return status;
				} else {
					Driver.manage().timeouts()
							.implicitlyWait(2, TimeUnit.SECONDS);
				}
			}
			LOG.info("Wait for Element Present :"+ locator);

		} catch (Exception e) {
			status = false;
			LOG.info(e.getMessage());
			e.printStackTrace();
			takeScreenshot("waitForElementFailed_" + locator);
		}
		return status;
	}

	/**
	 * This helper method waits for 60 seconds with a frequency check of 5 sec
	 * to assert the element is visible.
	 * 
	 * @param locator
	 */
	public void waitForElementByFluentWait(By locator) {
		org.openqa.selenium.support.ui.Wait<EventFiringWebDriver> wait = new FluentWait<EventFiringWebDriver>(
				Driver).withTimeout(20, TimeUnit.SECONDS)
				.pollingEvery(5, TimeUnit.SECONDS)
				.ignoring(NoSuchElementException.class);
		wait.until(ExpectedConditions.visibilityOf(Driver.findElement(locator)));
	}

	public boolean isElementEnabled(By by) throws Throwable {
		boolean flag = false;
		try {
			Driver.findElement(by).isEnabled();
			flag = true;
			LOG.info("Element is Enabled");
		} catch (Exception e) {
			flag = false;
			LOG.info(e.getMessage());
			e.printStackTrace();
			takeScreenshot("IsElementEnabledFailed_");
		}
		return flag;
	}

	public String getCurrentDate() throws Throwable {

		DateFormat dateFormat = new SimpleDateFormat("dd/MMM/yyyy");
		Date date = new Date();
		String currentDate = dateFormat.format(date);
		return currentDate;
	}

	public String getFutureDate() throws Throwable {

		DateFormat dateFormat = new SimpleDateFormat("dd/MMM/yyyy");
		Calendar c = Calendar.getInstance();
		c.setTime(new Date());
		c.add(Calendar.DATE, 5);
		String futureDate = dateFormat.format(c.getTime());
		return futureDate;
	}

	public int generateRandomNumber() {

		Random generator = new Random();
		int intRandom_number = generator.nextInt(9999) + 1000;
		return intRandom_number;

	}



	public boolean isElementSelected(By by) throws Throwable {
		boolean flag = false;
		try {
			Driver.findElement(by).isSelected();
			flag = true;
			LOG.info("Element is Selected");
		} catch (Exception e) {
			flag = false;
			LOG.info(e.getMessage());
			e.printStackTrace();
			takeScreenshot("isElementSelected" + by);
		}
		return flag;
	}

	public boolean rightclick(WebElement locator, String locatorName)
			throws Throwable {
		boolean status = false;
		try {

			// WebElement ele = Driver.findElement(ContentEditorPage.NewsTree);

			Actions action = new Actions(Driver).contextClick(locator);
			action.build().perform();

			status = true;
			LOG.info(msgClickSuccess + locatorName);
			LOG.info("Rightclick on locator - " + locatorName);
		} catch (Exception e) {
			status = false;
			LOG.info(e.getMessage());
			e.printStackTrace();
			takeScreenshot(locatorName);
		}
		return status;
	}

	public boolean enterTextIntoAlert(String text) throws Throwable {
		boolean flag = false;
		try {
			Alert alert = Driver.switchTo().alert();
			alert.sendKeys(text);
			alert.accept();

			flag = true;
			LOG.info("text: "+text+" Entered into Alert");
		} catch (Exception e) {
			flag = false;
			LOG.info(e.getMessage());
			e.printStackTrace();
			takeScreenshot("enterTextIntoAlert" + text);
		}
		return flag;
	}

	public boolean accecptTheAlert() throws Throwable {
		boolean flag = false;
		try {
			Alert alert = Driver.switchTo().alert();
			alert.accept();

			flag = true;
			LOG.info("Alert accepted");
		} catch (Exception e) {
			flag = false;
			LOG.info(e.getMessage());
			e.printStackTrace();
			takeScreenshot("accecpt the Alert");
		}
		return flag;
	}

	public boolean waitForAlertToPresent() throws Throwable {
		boolean flag = false;
		try {
			new WebDriverWait(Driver, 60).until(ExpectedConditions
					.alertIsPresent());

			flag = true;
			LOG.info("Wait for Alert present");
		} catch (Exception e) {
			flag = false;
			LOG.info(e.getMessage());
			e.printStackTrace();
			takeScreenshot("waitForAlertToPresent");
		}
		return flag;
	}
	
	public boolean isAlertPresent()  throws Throwable { 
		boolean flag = false;
	    try 
	    { 
	        Driver.switchTo().alert(); 
	        flag = true;
	        LOG.info("Alert is Present");
	    }   // try 
	    catch (Exception e) {
			flag = false;
			
		}
		return flag;// catch 
	}   // isAlertPresent()
	
	public By createDynamicEle(By ele, String value){
		String xpExpression = ele.toString();
		xpExpression = xpExpression.substring(xpExpression.indexOf("/"));
		
		return By.xpath(xpExpression.replaceFirst("<replaceValue>", value));
		
	}
	
	public boolean isElementNotPresent(By by, String locatorName) throws Throwable {
		boolean flag = true;
		try {
			Driver.findElement(by);
			flag = false;
			LOG.info("Alert is not present");
		} catch (Exception e) {
			flag = true;
			LOG.info(e.getMessage());
			takeScreenshot(locatorName);
		}				
		return flag;
	}
	

	
}
