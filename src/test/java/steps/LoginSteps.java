package steps;


import com.accelerators.ActionEngine;
import com.amazon.pages.LoginPage;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;
import org.junit.Assert;

/**
 * Created by Satish on 10/15/2016.
 */
public class LoginSteps {

    private final Logger LOG = Logger.getLogger(LoginSteps.class);
    LoginPage lp= new LoginPage();

    @Given("^I navigate to Amazon landing page$")
    public void i_navigate_to_Amazon_landing_page() throws Throwable {

        LOG.info("Navigating to Amazon webApplication Page");

    }

    @When("^I input valid credentials of \"([^\"]*)\" and \"([^\"]*)\"$")
    public void i_input_valid_credentials_of_and(String arg1, String arg2) throws Throwable {

        lp.login(arg1,arg2);

    }

    @Then("^I see Amazon home page with title as \"([^\"]*)\"$")
    public void i_see_Amazon_home_page_with_title_as(String arg1) throws Throwable {

        LOG.info(lp.getTitle());

    }

    @When("^I input invalid credentials of \"([^\"]*)\" and \"([^\"]*)\"$")
    public void i_input_invalid_credentials_of_and(String arg1, String arg2) throws Throwable {

        lp.inValidlogin(arg1,arg2);
    }

    @Then("^I do not see  Amazon home page$")
    public void i_do_not_see_Amazon_home_page() throws Throwable {

        Assert.assertEquals(lp.getTitle(),"Amazon[.com: Online Shopping for Electronics, Apparel, Computers, Books, DVDs & more");

    }

}
