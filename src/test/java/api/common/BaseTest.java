package api.common;

import constants.Endpoints;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;

public class BaseTest {
    public RequestSpecification requestSpecBuilder() {
        return new RequestSpecBuilder()
                .addHeader("Content-Type", String.valueOf(ContentType.JSON))
                .setBaseUri(Endpoints.baseURL)
                .addFilter(new RequestLoggingFilter())
                .build();
    }
}
