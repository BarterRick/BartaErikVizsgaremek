import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;


public class LoginPage {
    WebDriver driver;
    public LoginPage(WebDriver driver) { this.driver = driver; }

    private final String url = "https://lennertamas.github.io/blondesite/";
    private final By acceptButtonId = By.id("terms-and-conditions-button");
    private final By terms = By.id("overlay");
    private final By registerFormPath = By.xpath("//*[@id=\"login\"]/button[text()=\"Register\"]");
    private final By usernameLogInput = By.id("email");
    private final By passwordLogInput = By.id("password");
    private final By loginButton = By.xpath("//*[@class=\"form\"]//button[text()=\"Login\"]");
    private final String landingUrl = "https://lennertamas.github.io/blondesite/landing.html";

    private String username;
    private String password;
    private boolean success = false;



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
    public void Login(String username,String password)
    {
        WebElement usernameInput = driver.findElement(usernameLogInput);
        usernameInput.sendKeys(username);
        WebElement passwordInput = driver.findElement(passwordLogInput);
        passwordInput.sendKeys(password);
        WebElement submitButton = driver.findElement(loginButton);
        submitButton.click();
    }
    public void Login() throws Exception
    {
        UserData userdata = new UserData();
        String[] data = userdata.GetUserData();
        username = data[0];
        password = data[1];
        WebElement usernameInput = driver.findElement(usernameLogInput);
        usernameInput.sendKeys(username);
        WebElement passwordInput = driver.findElement(passwordLogInput);
        passwordInput.sendKeys(password);
        WebElement submitButton = driver.findElement(loginButton);
        submitButton.click();
    }
    public Boolean IsPopupVisible()
    {
        WebElement popup = driver.findElement(terms);
        Boolean display = popup.isDisplayed();
        return display;
    }
    public Boolean IsLoginSuccessful()
    {
        if (driver.getCurrentUrl().equals(landingUrl)){
            success = true;
        }
        return success;
    }
}
