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
        loginPage.clickButtonEnter();
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

        String actualTextPassword = loginPage.errorPasswordAndEmailText();
        String expectedTextPassword = "Укажите пароль";

        Assertions.assertEquals(expectedTextPassword,actualTextPassword);
    }
}
