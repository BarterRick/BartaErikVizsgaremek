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

    private String username;
    private String password;
    private String email;
    private String description;

    public void SwitchToLoginForm()
    {
        WebElement loginFormSwitch = driver.findElement(loginFormPath);
        loginFormSwitch.click();
    }
    public void Registration(String username,String password,String email,String description)
    {
        WebElement usernameField = driver.findElement(usernameRegInput);
        usernameField.sendKeys(username);
        WebElement passwordField = driver.findElement(passwordRegInput);
        passwordField.sendKeys(password);
        WebElement emailField = driver.findElement(emailRegInput);
        emailField.sendKeys(email);
        WebElement descriptionField = driver.findElement(descriptionInput);
        descriptionField.sendKeys(description);
        WebElement submitButton = driver.findElement(registerButton);
        submitButton.click();
    }
    public void Registration() throws Exception
    {
        UserData userdata = new UserData();
        String[] data = userdata.GetUserData();
        username = data[0];
        password = data[1];
        email = data[2];
        description = data[3];
        WebElement usernameField = driver.findElement(usernameRegInput);
        usernameField.sendKeys(username);
        WebElement passwordField = driver.findElement(passwordRegInput);
        passwordField.sendKeys(password);
        WebElement emailField = driver.findElement(emailRegInput);
        emailField.sendKeys(email);
        WebElement descriptionField = driver.findElement(descriptionInput);
        descriptionField.sendKeys(description);
        WebElement submitButton = driver.findElement(registerButton);
        submitButton.click();
    }
    public String CheckRegistrationAlert()
    {
        WebElement messageText = driver.findElement(message);
        String result = messageText.getText();
        return result;
    }
}
