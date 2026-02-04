package api.jsonplaceholder.tests;

import api.jsonplaceholder.BaseTestApi;
import api.jsonplaceholder.models.Comments;
import api.jsonplaceholder.models.Post;
import io.restassured.common.mapper.TypeRef;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class FullTest extends BaseTestApi {

    @Test
    @DisplayName("Проверка колличества всех Posts")
    public void checkCountOfPosts() {
       Response all_posts = responseForGetRequest("/posts");
        List<Post> posts = all_posts
                .as(new TypeRef<List<Post>>() {});
        assertEquals(100,posts.size(),"Колличество сообщений не равно 100");
    }

    @Test
    @DisplayName("Проверка колличества всех Comments")
    public void checkCountOfComments () {
        Response all_comments = responseForGetRequest("/comments");
        List<Comments> comments = all_comments
                .as(new TypeRef<List<Comments>>() {});
        assertEquals(500,comments.size(),"Колличество сообщений не равно 100");
    }

}
