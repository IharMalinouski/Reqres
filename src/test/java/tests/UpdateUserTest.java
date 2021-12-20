package tests;

import io.restassured.path.json.JsonPath;
import objects.create_user.CreateUser;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class UpdateUserTest {

    @Test
    public void updateUserTest() {
        CreateUser createUser = CreateUser.builder()
                .name("morpheus")
                .job("zion resident")
                .build();
        String responseUpdateUserMethod = given()
                .body(createUser)
                .header("Content-Type", "application/json")
        .when()
                .put("https://reqres.in/api/users/2")
        .then()
                .log().all()
                .statusCode(200)
                .extract().response().asString();
        JsonPath jsonPath = new JsonPath(responseUpdateUserMethod);
        String name = jsonPath.getString("name");
        String job = jsonPath.getString("job");
        String updatedAt = jsonPath.getString("updatedAt");
        Assert.assertEquals(name, "morpheus");
        Assert.assertEquals(job, "zion resident");
        Assert.assertNotNull(updatedAt);
    }
}
