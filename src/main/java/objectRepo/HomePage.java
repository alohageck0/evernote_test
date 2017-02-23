package objectRepo;

import ServiceClasses.PageTemplate;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageTemplate {
   public HomePage(WebDriver driver) {
      super(driver);
   }

   @FindBy(xpath = "html/body/header/div[2]/a[1]")
   private WebElement signIn;

   public WebElement getSignIn() {
      return signIn;
   }
}
