import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.config.LogConfig;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

import static io.restassured.RestAssured.given;

public class Test01 {
    public static void main(String[] args) throws InterruptedException {
        Response response = null;
        RestAssured.baseURI = "https://c-auth-qa4.copart.com";
        response = given().header("Content-Type", "application/json")
                .header("Authorization", "Basic Y29wYXJ0LWRldjpjYjA3MmI0NzM3YmI0NjBmOTFhNjgwNzU3OWIzMDVlMQ==")
                .config(RestAssured.config().encoderConfig(EncoderConfig.encoderConfig()
                        .encodeContentTypeAs("x-www-form-urlencoded", ContentType.URLENC)))
                .contentType("application/x-www-form-urlencoded; charset=UTF-8")
                .config(RestAssured.config.logConfig(LogConfig.logConfig().blacklistHeader("Authorization")))
                .formParam("username", "srivalli.parasapuri@copart.com")
                .formParam("grant_type", "password")
                .formParam("password", "Sailu-ala@1999")
                .when().post("gauthemployee/oauth/token?grant_type=password");
        String accesstoken = response.jsonPath().get("access_token");
        System.out.println("Access Token - " + accesstoken);
        response.then().log().all().assertThat().statusCode(200);

        Common_Headers.CommonHeaders();
        int lot_num=79589343;
//Lock Token
        RestAssured.baseURI="https://g2-qa4.copart.com";
        response=given().headers(Common_Headers.CommonHeaders())
             .header("Authorization","bearer "+accesstoken)
                .when().post("services/lotreview-ws/lot/v2/"+lot_num+"/?isLock=true");
        response.then().log().all();
        int token= response.jsonPath().getInt("token");
        System.out.println("token - " +token);

    }
}
