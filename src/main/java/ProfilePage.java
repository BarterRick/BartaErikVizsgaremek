import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class ProfilePage {
    WebDriver driver;
    public ProfilePage(WebDriver driver){this.driver=driver;}

    private final By nameField = By.id("name");
    private final By bioField = By.id("bio");
    private final By phoneField = By.id("phone-number");
    private final By saveButton = By.xpath("//button[text()=\"Save Profile\"]");
    private final By deleteButton = By.xpath("//button[@style=\"background-color: red;\"]");
    private final By editAlert = By.id("edit-alert");
    private final By deleteConfirmButton = By.id("delete-account-btn");

    public void EditProfile(String name, String bio, String phone)
    {
        WebElement nameInput = driver.findElement(nameField);
        nameInput.sendKeys(name);
        WebElement bioInput = driver.findElement(bioField);
        bioInput.sendKeys(bio);
        WebElement phoneInput = driver.findElement(phoneField);
        phoneInput.sendKeys(phone);
        WebElement saveBtn = driver.findElement(saveButton);
        saveBtn.click();
    }
    public String CheckEditAlert()
    {
        WebElement alert = driver.findElement(editAlert);
        String result = alert.getText();
        return result;
    }
    public void DeleteAccount()
    {
        WebElement delete = driver.findElement(deleteButton);
        delete.click();
        WebElement deleteConfirm = driver.findElement(deleteConfirmButton);
        deleteConfirm.click();
    }

}
