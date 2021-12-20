package tests;

import io.restassured.path.json.JsonPath;
import lombok.Data;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

@Data
public class SingleUserTest {

    @Test
    public void getSingleUserTest() {
        String responseSingleUser = given()
        .when()
                .get("https://reqres.in/api/users/2")
        .then()
                .log().all()
                .statusCode(200)
                .extract().asString();
        JsonPath jsonPath = new JsonPath(responseSingleUser);
        int userId = jsonPath.getInt("data.id");
        String email = jsonPath.getString("data.email");
        String firstName = jsonPath.getString("data.first_name");
        String lastName = jsonPath.getString("data.last_name");
        String avatar = jsonPath.getString("data.avatar");
        Assert.assertEquals(userId, 2);
        Assert.assertEquals(email, "janet.weaver@reqres.in");
        Assert.assertEquals(firstName, "Janet");
        Assert.assertEquals(lastName, "Weaver");
        Assert.assertEquals(avatar, "https://reqres.in/img/faces/2-image.jpg");
    }
}
