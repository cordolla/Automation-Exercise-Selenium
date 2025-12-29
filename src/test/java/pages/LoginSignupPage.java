package pages;

import models.SignupModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class LoginSignupPage {

    private WebDriver driver;

    @FindBy(css = "input[data-qa='signup-name']")
    private WebElement signupNameInput;

    @FindBy(css = "input[data-qa='signup-email']")
    private WebElement signupEmailInput;

    @FindBy(css = "button[data-qa='signup-button']")
    private WebElement signupButton;

    @FindBy(css = "input[data-qa='password']")
    private WebElement passwordInput;

    @FindBy(css = "input[data-qa='login-email']")
    private WebElement loginEmailInput;

    @FindBy(css = "input[data-qa='login-password']")
    private WebElement loginPasswordInput;

    @FindBy(css = "button[data-qa='login-button']")
    private WebElement loginButton;

    @FindBy(css = "input[id='id_gender1']")
    private WebElement titleMrRadioButton;

    @FindBy(css = "select[id='days']")
    private WebElement daysDropdown;

    @FindBy(css = "select[id='months']")
    private WebElement monthsDropdown;

    @FindBy(css = "select[id='years']")
    private WebElement yearsDropdown;

    @FindBy(css = "input[id='first_name']")
    private WebElement firstNameInput;

    @FindBy(css = "input[id='last_name']")
    private WebElement lastNameInput;

    @FindBy(css = "input[id='company']")
    private WebElement companyInput;

    @FindBy(css = "input[id='address1']")
    private WebElement address1Input;

    @FindBy(css = "input[id='address2']")
    private WebElement address2Input;

    @FindBy(css = "select[id='country']")
    private WebElement countryDropdown;

    @FindBy(css = "input[id='state']")
    private WebElement stateInput;

    @FindBy(css = "input[id='city']")
    private WebElement cityInput;

    @FindBy(css = "input[id='zipcode']")
    private WebElement zipcodeInput;

    @FindBy(css = "input[id='mobile_number']")
    private WebElement mobileNumberInput;

    @FindBy(css = "button[data-qa='create-account']")
    private WebElement createAccountButton;

    @FindBy(css = "h2[data-qa='account-created']")
    private WebElement accountCreatedText;

    @FindBy(css = "a[data-qa='continue-button']")
    private WebElement continueButton;

    @FindBy(css = "a[href='/logout']")
    private WebElement logoutButton;

    @FindBy(xpath = "//p[text()='Your email or password is incorrect!']")
    private WebElement invalidLoginMessage;

    public LoginSignupPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // passo 1: preencher nome, email e clicar em signup
    public void preencherSignup(String nome, String email) {
        signupNameInput.sendKeys(nome);
        signupEmailInput.sendKeys(email);
        signupButton.click();
    }

    // passo 2: preencher detalhes do cadastro
    public void preencherTodosCamposCadastro(SignupModel user) {

        titleMrRadioButton.click();

        passwordInput.sendKeys(user.getPassword());

        new Select(daysDropdown).selectByVisibleText(user.getDay());
        new Select(monthsDropdown).selectByVisibleText(user.getMonth());
        new Select(yearsDropdown).selectByVisibleText(user.getYear());

        firstNameInput.sendKeys(user.getFirstName());
        lastNameInput.sendKeys(user.getLastName());
        companyInput.sendKeys(user.getCompany());
        address1Input.sendKeys(user.getAddress1());
        address2Input.sendKeys(user.getAddress2());

        new Select(countryDropdown).selectByVisibleText(user.getCountry());

        stateInput.sendKeys(user.getState());
        cityInput.sendKeys(user.getCity());
        zipcodeInput.sendKeys(user.getZipcode());
        mobileNumberInput.sendKeys(user.getMobileNumber());

        createAccountButton.click();
    }

    public boolean isAccountCreatedMessageDisplayed() {
        return accountCreatedText.isDisplayed();

    }

    public void clicarEmContinue() {
        continueButton.click();
    }

    public void clicarEmLogout() {
        logoutButton.click();
    }

    public void preencherLogin(String email, String password) {
        loginEmailInput.sendKeys(email);
        loginPasswordInput.sendKeys(password);
        loginPasswordInput.submit();
    }

    public void clicarBotaoLogin() {
        loginButton.click();
    }

    public boolean isInvalidLoginMessageDisplayed() {
        return invalidLoginMessage.isDisplayed();
    }
}
