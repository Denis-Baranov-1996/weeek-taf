package net.weeek.denisbaranov;

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

        String actualTextPassword = loginPage.emptyEmailAndPasswordText();
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

        String actualTextPassword = loginPage.errorPasswordText();
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

        String actualTextPassword = loginPage.errorEmailText();
        String expectedTextPassword = "Необходимо заполнить все подсвеченные поля";

        Assertions.assertEquals(expectedTextPassword,actualTextPassword);
    }

    @Test
    public void testLoginWithNotExistTextOfPasswordAndEmail() {

        HomePage homePage = new HomePage();
        homePage.open();
        homePage.clickButtonLogin();

        LoginPage loginPage = new LoginPage();
        loginPage.inputEmail("test@test.by");
        loginPage.inputPassword("123456)))");
        loginPage.clickButtonEnter();

        String actualTextPassword = loginPage.notExistEmailAndPasswordText();
        String expectedTextPassword = "Неверный Email или пароль.";

        Assertions.assertEquals(expectedTextPassword,actualTextPassword);
    }

    @Test
    public void testLoginWithWrongTextOfEmail() {

        HomePage homePage = new HomePage();
        homePage.open();
        homePage.clickButtonLogin();

        LoginPage loginPage = new LoginPage();
        loginPage.inputEmail("123456");
        loginPage.inputPassword("123456)))");
        loginPage.clickButtonEnter();

        String actualTextPassword = loginPage.wrongTextEmail();
        String expectedTextPassword = "Email введён некорректно";

        Assertions.assertEquals(expectedTextPassword,actualTextPassword);
    }
}
