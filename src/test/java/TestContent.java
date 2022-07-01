import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestContent extends TestSetup{

    @BeforeEach
    public void PomSetup()
    {
        login = new LoginPage(driver);
        register = new RegisterPage(driver);
        landing = new LandingPage(driver);
        profile = new ProfilePage(driver);

        login.Navigate();
        login.AcceptTerms();
        login.SwitchToRegisterForm();
        register.Registration("testuser2","testpw","tesmail@mail.hu","test");
        register.SwitchToLoginForm();
        login.Login("testuser2","testpw");
    }

    @Test
    @DisplayName("Bejegyzések számának ellenőrzése")
    public void CheckContentNumberTest()
    {
        Integer actual = landing.GetArticleNumber();
        Assertions.assertEquals(5,actual);
    }
    @Test
    @DisplayName("Oldal lapozás tesztelése")
    public void CheckSecondPageTest()
    {
        landing.SelectSecondPage();
        Integer actual = landing.GetArticleNumber();
        Assertions.assertEquals(1,actual);
    }
    @Test
    @DisplayName("Bejegyzés címének ellenőrzése")
    public void CheckFirstArticleTitle() throws Exception
    {
        landing.SaveFirstArticleTitleToFile();
        String actual = landing.ReadContentFromFile();
        Assertions.assertEquals("Image Test",actual);
    }
    @Test
    @DisplayName("Profil módosítása")
    public void ProfileEditTest()
    {
    landing.GoToProfilePage();
    profile.EditProfile("newname","newbio","1234567");
    String actual = profile.CheckEditAlert();
    Assertions.assertEquals("Profile Edited!",actual);
    }
    @Test
    @DisplayName("Kijelentkezés")
    public void Logout()
    {
        landing.Logout();
        String actual = driver.getCurrentUrl();
        Assertions.assertEquals("https://lennertamas.github.io/blondesite/index.html",actual);
    }
    @Test
    @DisplayName("Profil törlése")
    public void DeleteProfile()
    {
        landing.GoToProfilePage();
        profile.DeleteAccount();
        login.Login("testuser2","testpw");
        Assertions.assertFalse(login.IsLoginSuccessful());
    }
}
