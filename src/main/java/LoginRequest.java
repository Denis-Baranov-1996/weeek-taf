import java.util.HashMap;
import java.util.Map;

public class LoginRequest {
    public static final String LOGIN_URL = "https://api.weeek.net/auth/login";

    public static String getBody() {
        return "{\"email\":\"\",\"password\":\"\",\"remember\":\"\"}";
    }

    public static Map<String, String> getHeaders() {
        Map<String, String> headers = new HashMap<>();
        headers.put("Content-Type", "application/json");
        return headers;
    }

    public static String getBody(String email, String password, boolean remember) {
        return "{\"email\":\"" + email + "\",\"password\":\"" + password + "\" , \"remember\":\"" + remember + "\"}";
    }

}
