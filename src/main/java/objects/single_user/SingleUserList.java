package objects.single_user;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
public class SingleUserList {

    List<SingleUser>data = new ArrayList<SingleUser>();;
}
