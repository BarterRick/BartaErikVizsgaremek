import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class LandingPage {
    WebDriver driver;
    public LandingPage(WebDriver driver) { this.driver = driver; }

    private final By leftBlock = By.xpath("//div[@id=\"content\"]/div/div/div/a");
    private final By secondPage = By.xpath("//a[text()=\"2\"]");
    private final By contactButton = By.xpath("//a[text()=\"Contact\"]");
    private final By profileButton = By.xpath("//a/img");
    private final By logoutButton = By.xpath("//a[text()=\"Logout\"]");
    private final By firstArticle = By.xpath("//div[@id=\"content\"]/div/div/div/a[1]");
    private final By articleTitle = By.xpath("//h1");

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
    public void SaveFirstArticleTitleToFile() throws Exception
    {
        WebElement first = driver.findElement(firstArticle);
        first.click();
        WebElement title = driver.findElement(articleTitle);
        String str= title.getText();
        BufferedWriter writer = new BufferedWriter(new FileWriter("src/main/resources/content.txt"));
        writer.write(str);
        writer.close();
    }
    public String ReadContentFromFile() throws Exception
    {
        String result = Files.readString(Paths.get("src/main/resources/content.txt"));
        return result;
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
