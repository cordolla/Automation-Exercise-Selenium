package tests;

import base.BaseTest;
import io.qameta.allure.*;
import models.SignupModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.HomePage;
import pages.LoginSignupPage;
import utils.DataUtils;

import java.io.IOException;

@Epic("Regressão Testes")
@Feature("Cadastro de Usuário")
public class TestCase1 extends BaseTest {

    String name = "Marcelo";
    String email = "Marcelo" + System.currentTimeMillis() + "@gmail.com";

    @Test
    @DisplayName("Deve realizar cadastro de usuário com sucesso")
    @Description("Verifica se o usuário consegue se cadastrar com dados válidos")
    @Severity(SeverityLevel.CRITICAL)
    @Owner("Marcelo Barbosa")
    public void validarCadastroUser() throws IOException {
        LoginSignupPage cadastroPage = new LoginSignupPage(driver);
        HomePage homePage = new HomePage(driver);

        // passo inicial
        homePage.clicarNoBotaoSignupLogin();

        // preencher nome, email e clicar em signup
        cadastroPage.preencherSignup(name, email);

        // validar que a página "ENTER ACCOUNT INFORMATION" é exibida
        String currentUrl = driver.getCurrentUrl();
        assert currentUrl != null;
        Assertions.assertTrue(currentUrl.contains("/signup"),
                "A URL deveria conter '/signup'");

        // carregar dados do usuário
        SignupModel dadosUser = DataUtils.getSignupData("massa_dados/cadastro_valido.json");

        //preencher detalhes do cadastro
        cadastroPage.preencherTodosCamposCadastro(dadosUser);

        // validar que a conta foi criada com sucesso
        Assertions.assertTrue(driver.getCurrentUrl().contains("/account_created"),
                "A URL deveria conter '/account_created'");

        // validar mensagem de conta criada
        Assertions.assertTrue(cadastroPage.isAccountCreatedMessageDisplayed(),
                "A mensagem de 'ACCOUNT CREATED!' deveria estar visível");

        // clicar em continue
        cadastroPage.clicarEmContinue();

        // validar que o usuário está logado
        Assertions.assertTrue(homePage.isLoggedInAsVisible(name),
                "O texto 'Logged in as " + name + "' deveria estar visível");

        // Fim do teste
    }
}
