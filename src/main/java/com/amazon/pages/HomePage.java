package com.amazon.pages;

import com.accelerators.ActionEngine;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.By;

public class HomePage extends ActionEngine{

    private final Logger LOG = Logger.getLogger(HomePage.class);

    public static By SearchBar = By.xpath("//input[@id='twotabsearchtextbox']");
    public static By SubmitLink = By.xpath("//input[@type='submit']");
    public static By cartCount = By.xpath("//span[@id='nav-cart-count']");
    public static By firstResult = By.xpath("//div[@id='desktop-sx-nav_sxwds-bovbp-featured-asin-widget']/div[2]/div[1]/div[1]/div[1]/a");
    public static By addToCartButton = By.xpath("//input[@id='add-to-cart-button']");

  public void SearchProduct(String product) throws Throwable{

      waitForElementPresent(SearchBar, "SearchBar",60);
      click(SearchBar,"SearchBar");
      type(SearchBar,product,"SearchBar");
      click(SubmitLink, "SubmitLink");

  }

  public void verifyandClickResults()throws Throwable
  {
      waitForElementPresent(firstResult, "FirstResult",60);
      click(firstResult, "FirstResult");

  }

  public void addToCart()throws Throwable
  {
      waitForElementPresent(addToCartButton, "addToCartButton",60);
      click(addToCartButton, "addToCartButton");


  }



    public void checkCart(int cart) throws Throwable{

        waitForElementPresent(cartCount,"CartCount", 60);
        int count = Integer.valueOf(getText(cartCount,"getText"));
        LOG.info("Cart count is " + count);
    }

    public void getTitleofPage() throws Throwable
    {
      String Titile =  getTitle();

    }
}
