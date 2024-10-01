package net.weeek.denisbaranov.pages;

import net.weeek.denisbaranov.xpathes.LoginPageXPath;
import net.weeek.denisbaranov.utils.Waiters;
import net.weeek.denisbaranov.driver.DriverSingleton;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage {
    WebDriver driver;

    public LoginPage() {
        this.driver = DriverSingleton.getDriver();
    }

    public void clickButtonEnter() {
        Waiters.waitFor(Waiters.DEFAULT_WAIT_SECONDS);
        By buttonEnterBy = By.xpath(LoginPageXPath.BUTTON_ENTER_XPATH);
        WebElement buttonEnter = driver.findElement(buttonEnterBy);
        buttonEnter.click();
    }

    public void inputEmail(String email) {
        Waiters.waitFor(Waiters.DEFAULT_WAIT_SECONDS);
        By inputEmailBy = By.xpath(LoginPageXPath.INPUT_EMAIL_XPATH);
        WebElement inputEmail = driver.findElement(inputEmailBy);
        inputEmail.sendKeys(email);
    }

    public void inputPassword(String password) {
        Waiters.waitFor(Waiters.DEFAULT_WAIT_SECONDS);
        By inputPasswordBy = By.xpath(LoginPageXPath.INPUT_PASSWORD_XPATH);
        WebElement inputPassword = driver.findElement(inputPasswordBy);
        inputPassword.sendKeys(password);
    }

    public String errorEmptyEmailOrPasswordText() {
        Waiters.waitFor(Waiters.DEFAULT_WAIT_SECONDS);
        By errorEmptyEmailOrPasswordBy = By.xpath(LoginPageXPath.ERROR_EMPTY_TEXT_WHEN_ENTER_EMAIL_OR_ENTER_PASSWORD_XPATH);
        WebElement getEmptyEmailOrPasswordError = driver.findElement(errorEmptyEmailOrPasswordBy);
        return getEmptyEmailOrPasswordError.getText();
    }

    public String errorTextEmailOrErrorTextEmailAndPassword() {
        Waiters.waitFor(Waiters.DEFAULT_WAIT_SECONDS);
        By errorWrongEmailTextBy = By.xpath(LoginPageXPath.ERROR_ENTER_EMAIL_OR_ERROR_ENTER_EMAIL_AND_PASSWORD_TEXT_XPATH);
        WebElement getErrorWrongEmailText = driver.findElement(errorWrongEmailTextBy);
        return getErrorWrongEmailText.getText();
    }
}
