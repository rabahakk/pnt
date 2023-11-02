package pages.demoblaze;

import base.CommonAPI;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import pages.LoginPage;
import utility.Utility;

public class SignUpPage extends CommonAPI {
    Logger LOG = LogManager.getLogger(homePage.class.getName());
    public SignUpPage(WebDriver driver){
        PageFactory.initElements(driver, this);
    }

            @FindBy(id = "sign-username")
            WebElement sUsername;

            @FindBy(id = "sign-password")
            WebElement sPassword;)

            @FindBy(xpath = "//button[text()='Sign up']")
    WebElement signUpBtn;

    public void typeUsername(String username){
        type(sUsername, username);
        LOG.info("type username success");
    }
    public void typePassword(String password){
        type(sPassword, password);
        LOG.info("type password success");
}
    public void clickOnLoginBtn() {
        clickOn(signUpBtn);
        LOG.info("click on login button success");
    }

    @FindBy(id = "FirstName")
    WebElement FirstName;
    @FindBy(id = "Email")
    WebElement Email;

    @FindBy(id = "Password")
    WebElement Password;

    @FindBy(id = "ConfirmPassword")
    WebElement confirmPassword;

    @FindBy(id = "register-button")
    WebElement registerButton;


    public void typeFirstName(String nopfirst) {
        type(FirstName, nopfirst);
        LOG.info("type username success");
    }
        public void typePassword(String noppw) {
            type(Password, noppw);
            LOG.info("type password success");
        }
    public void clickOnRegisterBtn(){
        clickOn(registerButton);
        LOG.info("click on login button success");

        String email = prop.getProperty("nopemail");

        public void loginWithValidCredentials() {

            nopcommerce.loginPage LoginPage = new LoginPage(getDriver());




        }
