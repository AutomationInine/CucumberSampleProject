package steps;

import Base.BaseUtil;
import cucumber.api.DataTable;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import pages.HomePage;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Karthik on 10/15/2016.
 */
public class HomePageStep extends BaseUtil{

    private  BaseUtil base;

    public HomePageStep(BaseUtil base) {
        this.base = base;
    }


    @Given("^I navigate to GitHub cucumber project landing page$")
    public void i_navigate_to_GitHub_cucumber_project_landing_page() throws Throwable {

        base.Driver.navigate().to("https://github.com/AutomationInine/CucumberSampleProject");

    }

    @Then("^I see read me section about the project$")
    public void i_see_read_me_section_about_the_project() throws Throwable {

        HomePage homePage = new HomePage(base.Driver);
       String title = homePage.getTitile();
        org.testng.Assert.assertEquals("GitHub - AutomationInine/CucumberSampleProject",title);

    }

}
