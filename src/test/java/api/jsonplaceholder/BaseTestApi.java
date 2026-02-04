package api.jsonplaceholder;

import io.restassured.RestAssured;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
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
}
