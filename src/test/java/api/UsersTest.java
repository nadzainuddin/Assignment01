package api;

import api.common.BaseTest;
import api.common.Utils;
import constants.Endpoints;
import io.qameta.allure.Description;
import io.restassured.path.json.JsonPath;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class UsersTest extends BaseTest {
    @Test()
    @Description("Verify able to retrieve user datails")
    public void getUserDetailsById() {
        JsonPath resp = Utils.GETQueryParam(requestSpecBuilder(), "id", "6", Endpoints.users, HttpStatus.SC_OK);
        Assert.assertEquals(resp.getString("[0].address.street"), "Norberto Crossing");
        Assert.assertEquals(resp.getString("[0].address.city"), "South Christy");
    }
}
