package net.weeek.denisbaranov;

import net.weeek.denisbaranov.driver.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    WebDriver driver;

    public LoginPage() {
        this.driver = DriverSingleton.getDriver();
    }

    public void clickButtonEnter()  {
        Waiters.waitFor(4);
        By buttonEnterBy = By.xpath(LoginPageXPath.BUTTON_ENTER_XPATH);
        WebElement buttonEnter = driver.findElement(buttonEnterBy);
        buttonEnter.click();
    }

    public void inputEmail(String email) {
        Waiters.waitFor(4);
        By inputEmailBy = By.xpath(LoginPageXPath.INPUT_EMAIL_XPATH);
        WebElement inputEmail = driver.findElement(inputEmailBy);
        inputEmail.sendKeys(email);
    }

    public void inputPassword(String password) {
        Waiters.waitFor(4);
        By inputPasswordBy = By.xpath(LoginPageXPath.INPUT_PASSWORD_XPATH);
        WebElement inputPassword = driver.findElement(inputPasswordBy);
        inputPassword.sendKeys(password);
    }

    public String emptyEmailAndPasswordText() {
        Waiters.waitFor(4);
        By errorEmptyEMailAndPasswordBy = By.xpath(LoginPageXPath.ERROR_ENTER_EMPTY_EMAIL_AND_ENTER_EMPTY_PASSWORD_XPATH);
        WebElement getErrorEmailAndPassword = driver.findElement(errorEmptyEMailAndPasswordBy);
        return getErrorEmailAndPassword.getText();
    }

    public String errorPasswordText() {
        Waiters.waitFor(4);
        By errorPasswordBy = By.xpath(LoginPageXPath.ERROR_ENTER_EMAIL_WITHOUT_ENTER_PASSWORD_XPATH);
        WebElement getErrorPassword = driver.findElement(errorPasswordBy);
        return getErrorPassword.getText();
    }

    public String errorEmailText() {
        Waiters.waitFor(4);
        By errorEmailBy = By.xpath(LoginPageXPath.ERROR_ENTER_PASSWORD_WITHOUT_ENTER_EMAIL_XPATH);
        WebElement getErrorEmail = driver.findElement(errorEmailBy);
        return getErrorEmail.getText();
    }

    public String notExistEmailAndPasswordText() {
        Waiters.waitFor(4);
        By errorNotExistPasswordAndEmailBy = By.xpath(LoginPageXPath.ERROR_ENTER_EMAIL_AND_PASSWORD_XPATH);
        WebElement getNotExistErrorPasswordAndEmail = driver.findElement(errorNotExistPasswordAndEmailBy);
        return getNotExistErrorPasswordAndEmail.getText();
    }
    public String wrongTextEmail() {
        Waiters.waitFor(4);
        By errorWrongEmailTextBy = By.xpath(LoginPageXPath.ERROR_ENTER_EMAIL_TEXT_XPATH);
        WebElement getErrorWrongEmailText = driver.findElement(errorWrongEmailTextBy);
        return getErrorWrongEmailText.getText();
    }

}
