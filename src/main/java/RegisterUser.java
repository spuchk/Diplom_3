import static io.restassured.RestAssured.given;


public class RegisterUser {
    private final User user = UserData.defaultUserData();
    String baseURL = "https://stellarburgers.nomoreparties.site";
    public void registrationUser() {
        given()
                .header("Content-type", "application/json")
                .baseUri(baseURL)
                .body(user)
                .when()
                .post("/api/auth/register")
                .then().statusCode(200);
    }
}
