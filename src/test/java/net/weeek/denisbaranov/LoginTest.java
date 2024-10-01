package net.weeek.denisbaranov;

import net.weeek.denisbaranov.driver.DriverSingleton;
import net.weeek.denisbaranov.pages.HomePage;
import net.weeek.denisbaranov.pages.LoginPage;
import org.junit.jupiter.api.*;

public class LoginTest  {

    @BeforeEach
    public void openLoginPage() {
        HomePage homePage = new HomePage();
        homePage.open();
        homePage.clickButtonLogin();
    }

    @Test
    public void testLoginWithEmptyData() {
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

        LoginPage loginPage = new LoginPage();
        loginPage.inputEmail("");
        loginPage.inputPassword("123456");
        loginPage.clickButtonEnter();

        String actualTextPassword = loginPage.errorEmptyEmailOrPasswordText();
        String expectedTextPassword = "Необходимо заполнить все подсвеченные поля";

        Assertions.assertEquals(expectedTextPassword,actualTextPassword);
    }

    @Test
    public void testLoginWithNotExistTextOfEmailAndPassword() {

        LoginPage loginPage = new LoginPage();
        loginPage.inputEmail("tester123@testers.by");
        loginPage.inputPassword("123456@#$%^&");
        loginPage.clickButtonEnter();

        String actualTextPassword = loginPage.errorTextEmailOrErrorTextEmailAndPassword();
        String expectedTextPassword = "Неверный Email или пароль.";

        Assertions.assertEquals(expectedTextPassword,actualTextPassword);
    }

    @Test
    public void testLoginWithWrongTextOfEmail() {

        LoginPage loginPage = new LoginPage();
        loginPage.inputEmail("!@№$%^&?*.by");
        loginPage.inputPassword("12qwasZ*");
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
