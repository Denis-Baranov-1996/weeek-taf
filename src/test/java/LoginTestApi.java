import io.restassured.RestAssured;
import org.junit.jupiter.api.Test;

public class LoginTestApi {
    @Test
            public void LoginTestApi() {
        RestAssured.when().post("https://api.weeek.net/auth/login").then().log().all();
    }
}
