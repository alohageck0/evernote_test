package Tests;

import ServiceClasses.TestTemplate;
import org.openqa.selenium.remote.RemoteWebDriver;
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

//   @Test(groups = {"login", "smoke"}, dataProvider = "usernames", dataProviderClass = MySQLDataProviders.class)
   @Test(groups = {"login", "smoke"})
   public void login() {
      logger.info("login test case started");
      getWebDriver().navigate().to("https://evernote.com/");
      logger.info("Home page opened");
   }


}
