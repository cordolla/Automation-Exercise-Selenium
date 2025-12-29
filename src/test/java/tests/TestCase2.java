package tests;

import base.BaseTest;
import io.qameta.allure.*;
import models.SignupModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.LoginSignupPage;

@Epic("Regressão Testes")
@Feature("Login de Usuário com Sucesso")
public class TestCase2 extends BaseTest {

    @Test
    @DisplayName("Deve realizar login de usuário com sucesso")
    @Description("Verificar se o usuário consegue fazer login com credenciais válidas")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Marcelo Barbosa")
    public void testLoginComSucesso() throws Exception {
        SignupModel usuarioCadastrado = cadastrarUsuarioPadrao();

        HomePage homePage = new HomePage(driver);
        LoginSignupPage loginSignupPage = new LoginSignupPage(driver);

        homePage.clicarNoBotaoSignupLogin();

        // usar os dados do usuario cadastrado para fazer login
        loginSignupPage.preencherLogin(usuarioCadastrado.getEmail(), usuarioCadastrado.getPassword());

        Assertions.assertTrue(homePage.isLoggedInAsVisible(usuarioCadastrado.getFirstName()),
                "O login não foi bem-sucedido ou o nome do usuário não está visível.");
    }
}
