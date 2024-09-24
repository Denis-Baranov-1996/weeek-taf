package net.weeek.denisbaranov;

public class LoginPageXPath {
    public static final String INPUT_EMAIL_XPATH = "//input[@placeholder='Электронная почта']";
    public static final String INPUT_PASSWORD_XPATH = "//input[@placeholder='Пароль']";
    public static final String BUTTON_ENTER_XPATH = "//button[@class='button-component']";
    public static final String ERROR_ENTER_EMPTY_EMAIL_AND_ENTER_EMPTY_PASSWORD_XPATH = "//div[@class='error']";
    public static final String ERROR_ENTER_EMAIL_WITHOUT_ENTER_PASSWORD_XPATH = "//div[@class='error']";
    public static final String ERROR_ENTER_PASSWORD_WITHOUT_ENTER_EMAIL_XPATH = "//div[@class='error']";
    public static final String ERROR_ENTER_EMAIL_AND_PASSWORD_XPATH = "//div[@class='error errors-log__error visible']";
    public static final String ERROR_ENTER_EMAIL_TEXT_XPATH = "//div[@class='error errors-log__error visible']";
}
