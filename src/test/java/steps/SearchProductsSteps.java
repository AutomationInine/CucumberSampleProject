package steps;

import com.amazon.pages.HomePage;
import com.amazon.pages.LoginPage;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.log4j.Logger;

public class SearchProductsSteps {


    private final Logger LOG = Logger.getLogger(LoginSteps.class);
    LoginPage loginpage = new LoginPage();
    HomePage homePage = new HomePage();

    @When("^I search for \"([^\"]*)\" product$")
    public void i_search_for_product(String arg1) throws Throwable {

        homePage.SearchProduct(arg1);

    }

    @Then("^I see search results$")
    public void i_see_search_results() throws Throwable {

        homePage.verifyandClickResults();

    }

    @Then("^I see cart is empty$")
    public void i_see_cart_is_empty() throws Throwable {
        homePage.checkCart(0);
    }

    @When("^I add first result to the cart$")
    public void i_add_first_result_to_the_cart() throws Throwable {
        homePage.addToCart();
    }

    @Then("^I see cart count is increased by (\\d+) to the earlier cartCount$")
    public void i_see_cart_count_is_increased_by_to_the_earlier_cartCount(int arg1) throws Throwable {
        homePage.checkCart(arg1);
    }


}
