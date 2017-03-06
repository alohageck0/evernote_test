package objectRepo;

import serviceClasses.PageTemplate;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Userpage extends PageTemplate {
   public Userpage(WebDriver driver) {
      super(driver);
   }

   @FindBy(xpath = "html/body/div[2]/div[2]/div/div[1]/div[3]/div[1]/div/div/div[1]/div/div[1]/div/img[1]")
   private WebElement userPicture;

   @FindBy(xpath = "html/body/div[2]/div[2]/div/div[2]/div[3]/div[2]/div/div[1]/div/div/div")
   private WebElement notesTitle;

   public WebElement getUserPicture() {
      return userPicture;
   }

   public WebElement getNotesTitle() {
      return notesTitle;
   }
}
