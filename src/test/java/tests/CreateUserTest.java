package tests;

import io.restassured.path.json.JsonPath;
import lombok.Data;
import objects.create_user.CreateUser;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

@Data
public class CreateUserTest {
    @Test
    public void postCreateUserTest() {
        CreateUser createUser = CreateUser.builder()
                .name("morpheus")
                .job("leader")
                .build();
        String responseCreateUserMethod = given()
        .body(createUser)
                .header("Content-Type", "application/json")
        .when()
                .post("https://reqres.in/api/users")
        .then()
                .log().all()
                .statusCode(201)
                .extract().response().asString();
        JsonPath jsonPath = new JsonPath(responseCreateUserMethod);
        String name = jsonPath.getString("name");
        String job = jsonPath.getString("job");
        int id = jsonPath.getInt("id");
        String createdAt = jsonPath.getString("createdAt");
        Assert.assertEquals(name, "morpheus");
        Assert.assertEquals(job, "leader");
        Assert.assertNotNull(createdAt);
        Assert.assertNotNull(id);
    }
}
