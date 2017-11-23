package steps;

import Base.BaseUtil;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.When;
import cucumber.api.java.en.Then;
import org.testng.Assert;
import pages.LoginPage;

/**
 * Created by Karthik on 10/15/2016.
 */
public class LoginPageStep extends BaseUtil{

    private  BaseUtil base;

    LoginPage loginPage;
    public LoginPageStep(BaseUtil base) {
        this.base = base;
         loginPage = new LoginPage(base.Driver);
    }


    @Given("^I navigate to GitHublanding page$")
    public void i_navigate_to_GitHublanding_page() {

        base.Driver.navigate().to("https://github.com/");
    }

    @When("^I input valid credentials of \"(.*)\" and \"(.*)\"$")
    public void i_input_valid_credentials_of_and(String arg1, String arg2) throws Exception {
        loginPage.login("samineni007@gmail.com","Test@12345");

    }

    @When("^I can successfully signout from the application$")
    public void getSignout()
    {
        loginPage.getSignout();

    }

    @Then("^I see Github home page with all my open source projects$")
    public void i_see_Github_home_page_with_all_my_open_source_projects() throws Exception {
        Assert.assertEquals(3,loginPage.getVerifyProjects());

    }

    @When("^I input invalid credentials of \"(.*)\" and \"([^\"]*)\"$")
    public void i_input_invalid_credentials_of_and(String arg1, String arg2) {
        loginPage.inValidlogin("samineni007@gmail.com","test1234$");
    }


    @Then("^I see an error message for invalid credentials$")
    public void i_see_an_error_message_for_invalid_credentials() throws Throwable {
        loginPage.verifyErorMsg();
    }


}
