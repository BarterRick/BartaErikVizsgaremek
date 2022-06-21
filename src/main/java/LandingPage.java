import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class LandingPage {
    WebDriver driver;
    public LandingPage(WebDriver driver) { this.driver=driver; }

    private final By leftBlock = By.cssSelector(".col-span-3");
    private final By pageSelector = By.cssSelector("ul.flex");

}
