package api.jsonplaceholder.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Comments {
     private Integer postId;
     private Integer id;
     private String name;
     private String email;
     private String body;
}
