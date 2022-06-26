import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class RegisterPage {
    WebDriver driver;
    public RegisterPage(WebDriver driver) { this.driver = driver; }

    private final By loginFormPath = By.xpath("//*[@id=\"register\"]/button[text()=\"Login\"]");
    private final By usernameRegInput = By.id("register-username");
    private final By passwordRegInput = By.id("register-password");
    private final By emailRegInput = By.id("register-email");
    private final By descriptionInput = By.id("register-description");
    private final By registerButton = By.xpath("//*[@class=\"form\"]//button[text()=\"Register\"]");
    private final By message = By.id("register-alert");

    public void SwitchToLoginForm()
    {
        WebElement loginFormSwitch = driver.findElement(loginFormPath);
        loginFormSwitch.click();
    }
    public void FillUsername(String username)
    {
        WebElement usernameField = driver.findElement(usernameRegInput);
        usernameField.sendKeys(username);
    }
    public void FillPassword(String password)
    {
        WebElement passwordField = driver.findElement(passwordRegInput);
        passwordField.sendKeys(password);
    }
    public void FillEmail(String email)
    {
        WebElement emailField = driver.findElement(emailRegInput);
        emailField.sendKeys(email);
    }
    public void FillDescription(String description)
    {
        WebElement descriptionField = driver.findElement(descriptionInput);
        descriptionField.sendKeys(description);
    }
    public void SubmitForm()
    {
        WebElement submitButton = driver.findElement(registerButton);
        submitButton.click();
    }
    public void GetMessageText()
    {
        WebElement messageText = driver.findElement(message);
        messageText.getText();
    }
}
