package tests;

import com.google.gson.Gson;
import lombok.Data;
import objects.list_users.UsersList;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;

@Data
public class UserListTest {

    @Test
    public void getListUsersTest() {
        String responseListUser = given()
        .when()
                .get("https://reqres.in/api/users?page=2")
        .then()
                .log().all()
                .statusCode(200)
                .extract().body().asString();
        UsersList usersList = new Gson().fromJson(responseListUser, UsersList.class);
        int getId = usersList.getData().get(0).getId();
        String getEmail = usersList.getData().get(0).getEmail();
        String firstName = usersList.getData().get(0).getFirstName();
        String lastName = usersList.getData().get(0).getLastName();
        String avatar = usersList.getData().get(0).getAvatar();
        Assert.assertEquals(getId, 7);
        Assert.assertEquals(getEmail, "michael.lawson@reqres.in");
        Assert.assertEquals(firstName, "Michael");
        Assert.assertEquals(lastName, "Lawson");
        Assert.assertEquals(avatar, "https://reqres.in/img/faces/7-image.jpg");
    }
}
