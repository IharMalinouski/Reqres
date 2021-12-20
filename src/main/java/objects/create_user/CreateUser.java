package objects.create_user;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CreateUser {
    String name;
    String job;
    String createdAt;
    int id;
}
