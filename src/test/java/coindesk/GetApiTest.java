package coindesk;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;

import java.util.List;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;


public class GetApiTest {
    public static void main(String[] args) {
        RestAssured.baseURI="https://api.coindesk.com";
       String response=given().when().get("/v1/bpi/currentprice.json")
                .then().assertThat().statusCode(200).body("chartName",equalTo("Bitcoin")).extract().response().asString();
        JsonPath js= new JsonPath(response);

        System.out.println(js.getInt("bpi.size()"));
        System.out.println(js.getString("bpi.GBP.description"));

    }

}
