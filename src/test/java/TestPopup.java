import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class TestPopup extends TestSetup{
    @BeforeEach
    public void PomSetup(){
        login = new LoginPage(driver);
    }

    @Test
    @DisplayName("Adatkezelési tájékoztató megjelenik")
    @Severity(SeverityLevel.CRITICAL)
    public void TermsAndConditionsShowsTest()
    {
        login.Navigate();
        Assertions.assertTrue(login.IsPopupVisible());
    }
    @Test
    @DisplayName("Adatkezelési tájékoztató elfogadás után eltűnik")
    @Severity(SeverityLevel.BLOCKER)
    public void TermsAndConditionsDisappearsTest()
    {
        login.Navigate();
        login.AcceptTerms();
        Assertions.assertFalse(login.IsPopupVisible());
    }
}
