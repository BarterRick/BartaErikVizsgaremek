import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver driver) { this.driver = driver; }

    private final String url = "https://lennertamas.github.io/blondesite/";
    private final By acceptButtonId = By.id("terms-and-conditions-button");
    private final By registerFormPath = By.xpath("//*[@id=\"login\"]/button[text()=\"Register\"]");
    private final By usernameLogInput = By.id("email");
    private final By passwordLogInput = By.id("password");
    private final By loginButton = By.xpath("//*[@class=\"form\"]//button[text()=\"Login\"]");



    public void Navigate() { driver.navigate().to(url); }

    public void AcceptTerms()
    {
        WebElement acceptButton = driver.findElement(acceptButtonId);
        acceptButton.click();
    }
    public void SwitchToRegisterForm()
    {
        WebElement registerFormSwitch = driver.findElement(registerFormPath);
        registerFormSwitch.click();
    }
    public void FillUsername(String username)
    {
        WebElement usernameInput = driver.findElement(usernameLogInput);
        usernameInput.sendKeys(username);
    }
    public void FillPassword(String password)
    {
        WebElement passwordInput = driver.findElement(passwordLogInput);
        passwordInput.sendKeys(password);
    }
    public void SubmitForm()
    {
        WebElement submitButton = driver.findElement(loginButton);
        submitButton.click();
    }


}
