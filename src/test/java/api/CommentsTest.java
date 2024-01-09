package api;

import api.common.BaseTest;
import api.common.Utils;
import com.fasterxml.jackson.core.JsonProcessingException;
import constants.Endpoints;
import io.qameta.allure.Description;
import io.restassured.path.json.JsonPath;
import org.apache.http.HttpStatus;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

public class CommentsTest extends BaseTest {
    @Test()
    @Description("Verify able to retrieve comments by id")
    public void getCommentsById() {
        JsonPath resp = Utils.GETQueryParam(requestSpecBuilder(), "id", "3", Endpoints.comments, HttpStatus.SC_OK);
        Assert.assertEquals(resp.getString("[0].name"), "odio adipisci rerum aut animi");
        Assert.assertEquals(resp.getString("[0].email"), "Nikita@garfield.biz");
    }

    @Test()
    @Description("Verify able to post comments")
    public void submitComments() {
        String request = "{\"posId\":1,\"name\":\"Melissa\",\"email\":\"abc@gmail.com\"}";
        JsonPath resp =  Utils.POSTWithBodyReq(requestSpecBuilder(), request,
                Endpoints.comments, HttpStatus.SC_CREATED);
        Assert.assertEquals(resp.getInt("id"), 501);
    }
}
