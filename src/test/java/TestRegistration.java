import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestRegistration extends TestSetup{
    @BeforeEach
    public void PomSetup()
    {
        login = new LoginPage(driver);
        register = new RegisterPage(driver);
    }

    @Test
    @DisplayName("Regisztráció fájlból beolvasott adatokkal")
    public void RegistrationFromFileTest() throws Exception
    {
        login.Navigate();
        login.AcceptTerms();
        login.SwitchToRegisterForm();
        register.Registration();
        String actual = register.CheckRegistrationAlert();
        Assertions.assertEquals("User registered!",actual);
    }
    @Test
    @DisplayName("Regisztráció manuálisan beírt adatokkal")
    public void RegistrationTest()
    {
        login.Navigate();
        login.AcceptTerms();
        login.SwitchToRegisterForm();
        register.Registration("testuser2","testpw2","testemail2@test.hu","Test Description");
        String actual = register.CheckRegistrationAlert();
        Assertions.assertEquals("User registered!",actual);
    }
}
