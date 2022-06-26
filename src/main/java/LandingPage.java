import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class LandingPage {
    WebDriver driver;
    public LandingPage(WebDriver driver) { this.driver=driver; }

    private final By leftBlock = By.cssSelector(".col-span-3");
    private final By secondPage = By.xpath("//a[text()=\"2\"]");
    private final By contactButton = By.xpath("//a[text()=\"Contact\"]");
    private final By profileButton = By.xpath("//a/img");
    private final By logoutButton = By.xpath("//a[text()=\"Logout\"]");

    public Integer GetArticleNumber()
    {
        List<WebElement> articles = driver.findElements(leftBlock);
        Integer numArticles = articles.size();
        return numArticles;
    }
    public void SelectSecondPage()
    {
        WebElement pageSelect = driver.findElement(secondPage);
        pageSelect.click();
    }
    public void GoToContactPage()
    {
        WebElement selectContact = driver.findElement(contactButton);
        selectContact.click();
    }
    public void GoToProfilePage()
    {
        WebElement selectProfile = driver.findElement(profileButton);
        selectProfile.click();
    }
    public void Logout()
    {
        WebElement logout = driver.findElement(logoutButton);
        logout.click();
    }
}
