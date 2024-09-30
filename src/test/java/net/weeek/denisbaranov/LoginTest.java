package net.weeek.denisbaranov;

import net.weeek.denisbaranov.driver.DriverSingleton;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class LoginTest {
    @Test
    public void testLoginWithEmptyData() {

        HomePage homePage = new HomePage();
        homePage.open();
        homePage.clickButtonLogin();

        LoginPage loginPage = new LoginPage();
        loginPage.inputEmail("");
        loginPage.inputPassword("");
        loginPage.clickButtonEnter();

        String actualTextPassword = loginPage.errorEmptyEmailOrPasswordText();
        String expectedTextPassword = "Необходимо заполнить все подсвеченные поля";

        Assertions.assertEquals(expectedTextPassword,actualTextPassword);
    }
    @Test
    public void testLoginWithEmptyTextOfPassword() {

        HomePage homePage = new HomePage();
        homePage.open();
        homePage.clickButtonLogin();

        LoginPage loginPage = new LoginPage();
        loginPage.inputEmail("test@test.by");
        loginPage.inputPassword("");
        loginPage.clickButtonEnter();

        String actualTextPassword = loginPage.errorEmptyEmailOrPasswordText();
        String expectedTextPassword = "Необходимо заполнить все подсвеченные поля";

        Assertions.assertEquals(expectedTextPassword,actualTextPassword);
    }

    @Test
    public void testLoginWithEmptyTextOfEmail() {

        HomePage homePage = new HomePage();
        homePage.open();
        homePage.clickButtonLogin();

        LoginPage loginPage = new LoginPage();
        loginPage.inputEmail("");
        loginPage.inputPassword("123456");
        loginPage.clickButtonEnter();

        String actualTextPassword = loginPage.errorEmptyEmailOrPasswordText();
        String expectedTextPassword = "Необходимо заполнить все подсвеченные поля";

        Assertions.assertEquals(expectedTextPassword,actualTextPassword);
    }

    @Test
    public void testLoginWithWrongTextOfEmailAndPassword() {

        HomePage homePage = new HomePage();
        homePage.open();
        homePage.clickButtonLogin();

        LoginPage loginPage = new LoginPage();
        loginPage.inputEmail("test@test.by");
        loginPage.inputPassword("123456");
        loginPage.clickButtonEnter();

        String actualTextPassword = loginPage.errorTextEmailOrErrorTextEmailAndPassword();
        String expectedTextPassword = "Неверный Email или пароль.";

        Assertions.assertEquals(expectedTextPassword,actualTextPassword);
    }

    @Test
    public void testLoginWithWrongTextOfEmail() {

        HomePage homePage = new HomePage();
        homePage.open();
        homePage.clickButtonLogin();

        LoginPage loginPage = new LoginPage();
        loginPage.inputEmail("@.by");
        loginPage.inputPassword("123456)))");
        loginPage.clickButtonEnter();

        String actualTextPassword = loginPage.errorTextEmailOrErrorTextEmailAndPassword();
        String expectedTextPassword = "Email введён некорректно";

        Assertions.assertEquals(expectedTextPassword,actualTextPassword);
    }

    @AfterEach
    public void close() {
        DriverSingleton.closeDriver();
    }
}
