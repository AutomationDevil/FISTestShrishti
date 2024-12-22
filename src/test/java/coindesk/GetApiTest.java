package coindesk;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;

@Test(groups = "api")
public class GetApiTest {
    public void testapi() {
        RestAssured.baseURI="https://api.coindesk.com";
       String response=given().when().get("/v1/bpi/currentprice.json")
                .then().assertThat().statusCode(200).body("chartName",equalTo("Bitcoin")).extract().response().asString();
        JsonPath js= new JsonPath(response);
        Assert.assertEquals(js.getInt("bpi.size()"),3);
        Assert.assertEquals(js.getString("bpi.GBP.description"),"British Pound Sterling");
    }

}
