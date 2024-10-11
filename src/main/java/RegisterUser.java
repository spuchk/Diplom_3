import static io.restassured.RestAssured.given;


public class RegisterUser {
    private final User user = UserData.defaultUserData();

    public void registrationUser() {
        given()
                .header("Content-type", "application/json")
                .baseUri(Url.URL_BASE)
                .body(user)
                .when()
                .post("/api/auth/register")
                .then().statusCode(200);
    }
}
