package objects.create_user;

import lombok.Data;

import java.util.ArrayList;

@Data
public class CreateUserResponse {
  ArrayList<CreateUser> user;
}
