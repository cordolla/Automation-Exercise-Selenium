package base;

import models.SignupModel;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.net.UrlChecker;
import pages.HomePage;
import pages.LoginSignupPage;
import utils.DataUtils;
import utils.PropertiesLoader;

import java.io.IOException;
import java.time.Duration;

public class BaseTest {

    protected WebDriver driver;

    @BeforeEach
    public void iniciarNavegador() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        String urlSite = PropertiesLoader.loadProperty("url");
        driver.get(urlSite);


    }

    @AfterEach
    public void fecharNavegador() {
        if (driver != null) {
            driver.quit();
        }
    }

    protected SignupModel cadastrarUsuarioPadrao() throws IOException {
        HomePage homePage = new HomePage(driver);
        LoginSignupPage registerPage = new LoginSignupPage(driver);

        SignupModel usuario = DataUtils.getSignupData("massa_dados/cadastro_valido.json");

        String emailUnico = "autoTester" + System.currentTimeMillis() + "@email.com";
        usuario.setEmail(emailUnico);

        homePage.clicarNoBotaoSignupLogin();
        registerPage.preencherSignup(usuario.getFirstName(), usuario.getEmail());
        registerPage.preencherTodosCamposCadastro(usuario);

        if(registerPage.isAccountCreatedMessageDisplayed()){
            registerPage.clicarEmContinue();
        }

        registerPage.clicarEmLogout();

        return usuario;
    }
}
