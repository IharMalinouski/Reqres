package tests;

import com.google.gson.Gson;
import objects.resourceList.ResourceList;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

public class ResourceListTest {

    @Test
    public void getResourceListTest() {
        String responseResourceList = given()
        .when()
                .get("https://reqres.in/api/unknown")
        .then()
                .log().all()
                .statusCode(200)
                .extract().body().asString();
        ResourceList resourceList = new Gson().fromJson(responseResourceList, ResourceList.class);
        int getId = resourceList.getData().get(0).getId();
        String getEmail = resourceList.getData().get(0).getName();
        int firstName = resourceList.getData().get(0).getYear();
        String lastName = resourceList.getData().get(0).getColor();
        String avatar = resourceList.getData().get(0).getPantoneValue();
        Assert.assertNotNull(responseResourceList);
        Assert.assertEquals(getId, 1);
        Assert.assertEquals(getEmail, "cerulean");
        Assert.assertEquals(firstName, 2000);
        Assert.assertEquals(lastName, "#98B2D1");
        Assert.assertEquals(avatar, "15-4020");
    }
}
