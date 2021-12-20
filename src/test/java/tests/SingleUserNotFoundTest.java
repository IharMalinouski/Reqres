package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class SingleUserNotFoundTest {

    @Test
    public void getSingleUserTwoSecondPageTest() {
        String responseResourceList = given()
        .when()
                .get("https://reqres.in/api/unknown/23")
        .then()
                .log().all()
                .statusCode(404)
                .extract().response().asString();
        Assert.assertEquals(responseResourceList, "{}");
        Assert.assertNotNull(responseResourceList);
    }
}
