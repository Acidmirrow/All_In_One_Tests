package api.jsonplaceholder;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.junit.jupiter.api.BeforeAll;

import static io.restassured.RestAssured.given;

public class BaseTestApi {

    @BeforeAll
    public static void configureRestAssured() {
        RestAssured.baseURI = "https://jsonplaceholder.typicode.com";
        RestAssured.requestSpecification = given()
                .header("Language", "en");
        RestAssured.filters(new RequestLoggingFilter(), new ResponseLoggingFilter());
    }

    public Response responseForGetRequest (String path) {
        return given()
                .accept(ContentType.JSON)
                .when()
                .get(path)
                .then()
                .statusCode(200)
                .extract()
                .response();
    }

    public Response responseForPostRequest (String path) {
        return given()
                .when()
                .get(path)
                .then()
                .statusCode(200)
                .extract()
                .response();
    }

}
