package objects.single_user;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class SingleUser {

    SingleUserList singleUserList;
    int id;
    String email;
    @SerializedName("first_name")
    String firstName;
    @SerializedName("last_name")
    String lastName;
    String avatar;
    String error;
}
