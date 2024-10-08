import static io.restassured.RestAssured.given;


public class DeleteUser {
    private final User user = UserData.defaultUserLogin();
    private String baseURL = "https://stellarburgers.nomoreparties.site";

    public void deleteDefaultUser() {
        String token;
        token = given()
                .header("Content-type", "application/json")
                .baseUri(baseURL)
                .body(user)
                .when()
                .post("/api/auth/login").then().extract().path("accessToken");

        given()
                .header("Authorization", token)
                .baseUri(baseURL)
                .when()
                .delete("/api/auth/user")
                .then().statusCode(202);
    }
}
