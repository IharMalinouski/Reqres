package objects.resourceList;

import com.google.gson.annotations.SerializedName;
import lombok.Data;

@Data
public class Resource {
    ResourceList resourceList;
    int id;
    String name;
    int year;
    String color;
    @SerializedName("pantone_value")
    String pantoneValue;
}

