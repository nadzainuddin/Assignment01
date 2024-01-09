package api.common;

import io.restassured.path.json.JsonPath;
import io.restassured.specification.RequestSpecification;

import static io.restassured.RestAssured.given;

public class Utils extends BaseTest {
    public static JsonPath GETQueryParam(RequestSpecification requestSpecification, String field, String value,
                                         String uri, int status) {
        return given().spec(requestSpecification)
                .queryParam(field, value)
                .when()
                .get(uri)
                .then()
                .log().ifError()
                .assertThat().statusCode(status)
                .extract().response().jsonPath();
    }

    public static JsonPath POSTWithBodyReq(RequestSpecification requestSpecification, String bodyReq,
                                           String uri, int status) {
        return given().spec(requestSpecification)
                .body(bodyReq)
                .when()
                .post(uri)
                .then()
                .log().ifError()
                .assertThat().statusCode(status)
                .extract().response().jsonPath();
    }
}
