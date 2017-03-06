package tests;

import data.MySQLDataProviders;
import serviceClasses.TestTemplate;
import objectRepo.HomePage;
import objectRepo.Userpage;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.IOException;
import java.lang.reflect.Method;

/**
 * LoginTests class used to store automated test cases.
 * <p>
 * It is used for test cases related with login functionality.
 *
 * @author Evgenii Iavorovich evgenii.iavorovich@qolsys.com
 */
public class LoginTests extends TestTemplate {
   public LoginTests(RemoteWebDriver webDriver) {
      super(webDriver);
   }

   public LoginTests() {
   }

   //   @AfterMethod(alwaysRun = true)
   @Override
   public void tearDown(Method test) throws IOException {
      logger.info("overriden teardown method");
   }

   @Test(groups = {"login", "smoke"}, dataProvider = "usernames", dataProviderClass = MySQLDataProviders.class, dependsOnMethods = {"clickSignIn"})
//   @Test(groups = {"login", "smoke"})
   public void login(String username, String password) {
      logger.info("login test case started");
      getWebDriver().navigate().to("https://evernote.com/");
      logger.info("Home page opened");

      HomePage homePage = new HomePage(getWebDriver());
      homePage.getSignIn().click();
      logger.info("Sign in clicked");

      Assert.assertEquals(homePage.getSignInPopupTitle().getText(), "Sign in");
      logger.info("Sign in pop up opened");

      homePage.getUsernameTextfield().sendKeys(username);
      logger.info("Username " + username + " entered");

      homePage.getPasswordTextfield().sendKeys(password);
      logger.info("Password entered");

      homePage.getSignInButton().click();
      logger.info("Sign in button clicked");

      Userpage userpage = new Userpage(getWebDriver());
      Assert.assertEquals(userpage.getNotesTitle().getText(), "NOTES");

   }

   @Test(groups = {"login", "smoke"})
   public void clickSignIn() {
      logger.info("clickSignIn test case started");
      getWebDriver().navigate().to("https://evernote.com/");
      logger.info("Home page opened");

      HomePage homePage = new HomePage(getWebDriver());
      homePage.getSignIn().click();
      logger.info("Sign in clicked");

      Assert.assertEquals(homePage.getSignInPopupTitle().getText(), "Sign in");
      logger.info("Sign in pop up opened");
   }

}
