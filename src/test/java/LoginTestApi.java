import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class LoginTestApi {
    @Test
    public void testLoginApiCheckCorrectStatusCode() {
        given().headers(LoginRequest.getHeaders()).body(LoginRequest.getBody()).
                when().post(LoginRequest.LOGIN_URL).
                then().statusCode(422);
    }

    @Test
    public void testLoginApiCheckIncorrectStatusCode() {
        given().headers(LoginRequest.getHeaders()).body(LoginRequest.getBody()).
                when().post(LoginRequest.LOGIN_URL).
                then().statusCode(400);
    }

    @Test
    public void testLoginWithEmptyEmailAndPasswordAndRememberTrue() {
        given().headers(LoginRequest.getHeaders()).body(LoginRequest.getBody("", "", true)).
                when().post(LoginRequest.LOGIN_URL).
                then().statusCode(422)
                .body("success", equalTo(false))
                .body("message", equalTo("The field is required. (and 1 more error)"))
                .body("errors.email[0]", equalTo("The field is required."))
                .body("errors.password[0]", equalTo("The field is required."))
                .header("Content-Type", equalTo("application/json"));
    }

    @Test
    public void testLoginWithEmptyEmailAndEnterPasswordAndRememberTrue() {
        given().headers(LoginRequest.getHeaders()).body(LoginRequest.getBody("", "123456", true)).
                when().post(LoginRequest.LOGIN_URL).
                then().statusCode(422)
                .body("success", equalTo(false))
                .body("message", equalTo("The field is required."))
                .body("errors.email[0]", equalTo("The field is required."))
                .header("Content-Type", equalTo("application/json"));
    }

    @Test
    public void testLoginWithEnterEmailAndEmptyPasswordAndRememberTrue() {
        given().headers(LoginRequest.getHeaders()).body(LoginRequest.getBody("test@test.by", "", true)).
                when().post(LoginRequest.LOGIN_URL).
                then().statusCode(422)
                .body("success", equalTo(false))
                .body("message", equalTo("The field is required."))
                .body("errors.password[0]", equalTo("The field is required."))
                .header("Content-Type", equalTo("application/json"));
    }

    @Test
    public void testLoginWithEnterEmailAndPasswordAndRememberTrue() {
        given().headers(LoginRequest.getHeaders()).body(LoginRequest.getBody("test@test.by", "123456", true)).
                when().post(LoginRequest.LOGIN_URL).
                then().statusCode(422)
                .body("success", equalTo(false))
                .body("message", equalTo("Email or password incorrect."))
                .body("errors.email[0]", equalTo("Email or password incorrect."))
                .header("Content-Type", equalTo("application/json"));
    }

    @Test
    public void testLoginWithEnterEmailAndPasswordAndRememberFalse() {
        given().headers(LoginRequest.getHeaders()).body(LoginRequest.getBody("test@test.by", "123456", false)).
                when().post(LoginRequest.LOGIN_URL).
                then().statusCode(422)
                .body("success", equalTo(false))
                .body("message", equalTo("Email or password incorrect."))
                .body("errors.email[0]", equalTo("Email or password incorrect."))
                .header("Content-Type", equalTo("application/json"));
    }

    @Test
    public void testLoginWithEmailAndPasswordAndRememberFalse() {
        given().headers(LoginRequest.getHeaders()).body(LoginRequest.getBody("", "", false)).
                when().post(LoginRequest.LOGIN_URL).
                then().statusCode(422)
                .body("success", equalTo(false))
                .body("message", equalTo("The field is required. (and 1 more error)"))
                .body("errors.email[0]", equalTo("The field is required."))
                .body("errors.password[0]", equalTo("The field is required."))
                .header("Content-Type", equalTo("application/json"));
    }

    @Test
    public void testLoginWithEnterEmailAndEmptyPasswordAndRememberFalse() {
        given().headers(LoginRequest.getHeaders()).body(LoginRequest.getBody("test@test.by", "", false)).
                when().post(LoginRequest.LOGIN_URL).
                then().statusCode(422)
                .body("success", equalTo(false))
                .body("message", equalTo("The field is required."))
                .body("errors.password[0]", equalTo("The field is required."))
                .header("Content-Type", equalTo("application/json"));
    }

    @Test
    public void testLoginWithEmptyEmailAndEnterPasswordAndRememberFalse() {
        given().headers(LoginRequest.getHeaders()).body(LoginRequest.getBody("", "123456", false)).
                when().post(LoginRequest.LOGIN_URL).
                then().statusCode(422)
                .body("success", equalTo(false))
                .body("message", equalTo("The field is required."))
                .body("errors.email[0]", equalTo("The field is required."))
                .header("Content-Type", equalTo("application/json"));
    }
}
