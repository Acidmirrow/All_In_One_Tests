package api.jsonplaceholder;

import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.given;


public class FullTest extends BaseTestApi {

    @Test
    @DisplayName("Тест для получения всех Posts")
    public void takePost () {
        Response all_posts = given()
                .when()
                .get("/posts")
                .then()
                .statusCode(200)
                .extract()
                .response();

        List<Post> users = all_posts.body()
                .jsonPath()
                .getList("data", Post.class);

        System.out.println(users.toString());


    }

}
