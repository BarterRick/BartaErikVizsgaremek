import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestLogin extends TestSetup{
    @BeforeEach
    public void PomSetup()
    {
        login = new LoginPage(driver);
        register = new RegisterPage(driver);
    }

    @Test
    @DisplayName("Belépés regisztráció nélkül")
    @Severity(SeverityLevel.CRITICAL)
    public void LoginWithoutRegistrationTest()
    {
        login.Navigate();
        login.AcceptTerms();
        login.Login("nonexist","testpw");
        Assertions.assertFalse(login.IsLoginSuccessful());
    }
    @Test
    @DisplayName("Belépés jelszó nélkül")
    @Severity(SeverityLevel.CRITICAL)
    public void LoginWithoutPasswordTest()
    {
        login.Navigate();
        login.AcceptTerms();
        login.SwitchToRegisterForm();
        register.Registration("testuser2","testpw","tesmail@mail.hu","test");
        register.SwitchToLoginForm();
        login.Login("testuser2","");
        Assertions.assertFalse(login.IsLoginSuccessful());
    }
    @Test
    @DisplayName("Belépés valós adatokkal")
    @Severity(SeverityLevel.BLOCKER)
    public void LoginTest()throws Exception
    {
        login.Navigate();
        login.AcceptTerms();
        login.SwitchToRegisterForm();
        register.Registration();
        register.SwitchToLoginForm();
        login.Login();
        Assertions.assertTrue(login.IsLoginSuccessful());
    }
}
