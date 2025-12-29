package tests;

import base.BaseTest;
import io.qameta.allure.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.LoginSignupPage;

@Epic("Regressão Testes")
@Feature("Login de Usuário com dados inválidos")
public class TestCase3 extends BaseTest {

    @Test
    @DisplayName("Deve realizar login de usuário com dados inválidos")
    @Description("Verificar se o sistema exibe mensagem de erro ao tentar fazer login com credenciais inválidas")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Marcelo Barbosa")
    public void testarLoginInvalido() throws Exception {
        HomePage homePage = new HomePage(driver);
        LoginSignupPage loginSignupPage = new LoginSignupPage(driver);

        homePage.clicarNoBotaoSignupLogin();

        // Tentar fazer login com credenciais inválidas
        loginSignupPage.preencherLogin("emailinvalido@teste.com", "senhaerrada");

        loginSignupPage.clicarBotaoLogin();

        // Validar que a mensagem de erro é exibida
        Assertions.assertTrue(loginSignupPage.isInvalidLoginMessageDisplayed(),
                "A mensagem de 'Your email or password is incorrect!' deveria estar visível");

    }

}
