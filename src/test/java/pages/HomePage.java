package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class HomePage {

    private WebDriver driver;

    @FindBy(css = "a[href='/login']")
    private WebElement botaoSignupLogin;

    @FindBy(xpath = "//li[contains(.,' Logged in as')]")
    private WebElement loggedInInfo;

    public HomePage(WebDriver driver) {
        this.driver = driver;

        PageFactory.initElements(driver, this);
    }

    public void clicarNoBotaoSignupLogin() {
        botaoSignupLogin.click();
    }

    public boolean isLoggedInAsVisible(String nomeUsuario) {
        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));

            // Espera até que o elemento esteja visível
            WebElement elementoVisivel = wait.until(ExpectedConditions.visibilityOf(loggedInInfo));

            // Verifica se o texto do elemento contém o nome do usuário
            return elementoVisivel.getText().contains(nomeUsuario);
        } catch (Exception e) {
            return false;
        }

    }
}
