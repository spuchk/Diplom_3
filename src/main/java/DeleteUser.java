import static io.restassured.RestAssured.given;


public class DeleteUser {
    private final User user = UserData.defaultUserLogin();


    public void deleteDefaultUser() {
        String token;
        token = given()
                .header("Content-type", "application/json")
                .baseUri(Url.URL_BASE)
                .body(user)
                .when()
                .post("/api/auth/login").then().extract().path("accessToken");

        given()
                .header("Authorization", token)
                .baseUri(Url.URL_BASE)
                .when()
                .delete("/api/auth/user")
                .then().statusCode(202);
    }
}
