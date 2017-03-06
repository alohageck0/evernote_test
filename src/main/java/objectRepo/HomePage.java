package objectRepo;

import serviceClasses.PageTemplate;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends PageTemplate {
   public HomePage(WebDriver driver) {
      super(driver);
   }

   @FindBy(xpath = "html/body/header/div[2]/a[1]")
   private WebElement signIn;
   @FindBy(xpath = "html/body/div/div/div[2]/form/fieldset[1]/input")
   private WebElement usernameTextfield;
   @FindBy(xpath = "html/body/div/div/div[2]/form/fieldset[2]/input")
   private WebElement passwordTextfield;

   @FindBy(xpath = "html/body/div/div/div[2]/form/fieldset[5]/input")
   private WebElement signInButton;

   @FindBy(xpath = "html/body/div/div/div[2]/div[1]")
   private WebElement signInPopupTitle;

   public WebElement getSignInPopupTitle() {
      return signInPopupTitle;
   }

   public WebElement getSignIn() {
      return signIn;
   }

   public WebElement getUsernameTextfield() {
      return usernameTextfield;
   }

   public WebElement getPasswordTextfield() {
      return passwordTextfield;
   }

   public WebElement getSignInButton() {
      return signInButton;
   }
}
