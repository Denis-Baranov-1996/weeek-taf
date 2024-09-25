import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

import static org.hamcrest.Matchers.equalTo;

public class LoginTestApi {
    @Test
    public void LoginTestApi() {
        RestAssured.
                when().
                post("https://api.weeek.net/auth/login").
                then().log().all();
    }
    @Test
    public void LoginTestApiCheckStatusCodeInBody() {
        RestAssured.
                when().
                post("https://api.weeek.net/auth/login").
                then().statusCode(422);
    }
    @Test
    public void LoginTestApiCheckSuccessInBody() {
        RestAssured.
                when().
                post("https://api.weeek.net/auth/login").
                then().statusCode(422).
                body("success", equalTo(false));
    }

    @Test
    public void LoginTestApiCheckIfWriteNotWordSuccessInBody() {
        RestAssured.
                when().
                post("https://api.weeek.net/auth/login").
                then().statusCode(422).
                body("success_any", equalTo(false));
    }

    @Test
    public void LoginTestApiCheckSucccessIfTrueInBody() {
        RestAssured.
                when().
                post("https://api.weeek.net/auth/login").
                then().log().all().
                statusCode(422).
                body("success_any", equalTo(true));
    }

    @Test
    public void LoginTestApiCheckSuccessMessageEmailPassword() {
        RestAssured.
                when().
                post("https://api.weeek.net/auth/login").
                then().log().body().
                statusCode(422).
                body("success", equalTo(false)).
                body("message",equalTo("The field is required. (and 1 more error)")).
                body("errors.email[0]",equalTo("The field is required.")).
                body("errors.password[0]",equalTo("The field is required."));
    }
}
