import io.restassured.RestAssured;
import io.restassured.config.EncoderConfig;
import io.restassured.config.LogConfig;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;

import java.util.Scanner;


import static io.restassured.RestAssured.given;
public class Test
{   
	public static void main(String[] args) throws InterruptedException {
		Response response = null;RestAssured.baseURI="https://c-auth-qa4.copart.com";
		response = given().header("Content-Type", "application/json")        
				.header("Authorization", "Basic Y29wYXJ0LWRldjpjYjA3MmI0NzM3YmI0NjBmOTFhNjgwNzU3OWIzMDVlMQ==")        
				.config(RestAssured.config().encoderConfig(EncoderConfig.encoderConfig()
						.encodeContentTypeAs("x-www-form-urlencoded", ContentType.URLENC)))        
				.contentType("application/x-www-form-urlencoded; charset=UTF-8")        
				.config(RestAssured.config.logConfig(LogConfig.logConfig().blacklistHeader("Authorization")))        
				.formParam("username", "srivalli.parasapuri@copart.com").formParam("grant_type", "password")
				.formParam("password", "Sailu-ala@1999")
				.when().post("gauthemployee/oauth/token?grant_type=password");
		    	String accesstoken = response.jsonPath().get("access_token");
		       System.out.println("Access Token - " +accesstoken);
		       response.then().log().all().assertThat().statusCode(200);

		int lot_num=79589343;
//Lock Token
		RestAssured.baseURI="https://g2-qa4.copart.com";
		response=given().headers(Common_Headers.CommonHeaders())
		.header("Authorization","bearer "+accesstoken)
		.when().post("services/lotreview-ws/lot/v2/"+lot_num+"/?isLock=true");
		response.then().log().all();
		JsonPath js=new JsonPath("token");
		int token= response.jsonPath().getInt("token");
		System.out.println("token - " +token);


//Add SO
		 RestAssured.baseURI="https://g2-qa4.copart.com";
		response=given().headers(Common_Headers.SOHeaders())
		.header("Authorization","bearer"+accesstoken).header("x-lock-token",+token)
				.body(PayLoad.AddSO())
		.when().post("services/ycssomus/som/lots/"+lot_num+"/service_order");
		response.then().log().all();
		int service_order_id= response.jsonPath().getInt("data.service_order_id");
		System.out.println("service_order_id - " +service_order_id);


//Lock Token Release
		RestAssured.baseURI="https://g2-qa4.copart.com";
		response=given().headers(Common_Headers.TokenHeaders())
				.header("Authorization","bearer "+accesstoken).header("tokenNumber",+token)
				.when().post("services/lotreview-ws/lot/v2/"+lot_num+"/?isLock=false&keepAlive=true&tokenNumber="+token+"");
		response.then().log().all().assertThat().statusCode(200);



		Thread.sleep(5000);


//Complete SO
		RestAssured.baseURI="https://g2-qa4.copart.com";
		response=given().headers(Common_Headers.SOHeaders())
				.header("Authorization","bearer"+accesstoken)
				.header("x-lock-token",+token)
				.body(PayLoad.CompleteSO())
				.when().put("services/ycssomus/som/lots/"+lot_num+"/service_order/"+service_order_id+"");
		response.then().log().all().assertThat().statusCode(200);


//Add SO 2
		RestAssured.baseURI="https://g2-qa4.copart.com";
		response=given().headers(Common_Headers.SOHeaders())
				.header("Authorization","bearer"+accesstoken).header("x-lock-token",+token)
				.body(PayLoad.AddSO2())
				.when().post("services/ycssomus/som/lots/"+lot_num+"/service_order");
		response.then().log().all();
		int service_order_id_2= response.jsonPath().getInt("data.service_order_id");
		System.out.println("service_order_id 2 - " +service_order_id_2);

//Approve SO
		RestAssured.baseURI="https://g2-qa4.copart.com";
		response=given().headers(Common_Headers.SOHeaders())
				.header("Authorization","bearer"+accesstoken)
				.header("x-lock-token",+token)
				.body(PayLoad.ApproveSO())
				.when().put("services/ycssomus/som/lots/"+lot_num+"/service_order/"+service_order_id_2+"");
		response.then().log().all().assertThat().statusCode(200);



		Thread.sleep(3000);


//Add SO 3
		RestAssured.baseURI="https://g2-qa4.copart.com";
		response=given().headers(Common_Headers.SOHeaders())
				.header("Authorization","bearer"+accesstoken)
				.header("x-lock-token",+token)
				.body(PayLoad.AddSO3())
				.when().post("services/ycssomus/som/lots/"+lot_num+"/service_order");
		response.then().log().all();
		int service_order_id_3= response.jsonPath().getInt("data.service_order_id");
		System.out.println("service_order_id 3 - " +service_order_id_3);


//Reject SO
		RestAssured.baseURI="https://g2-qa4.copart.com";
		response=given().headers(Common_Headers.SOHeaders())
				.header("Authorization","bearer"+accesstoken)
				.header("x-lock-token",+token)
				.body(PayLoad.RejectSO())
				.when().put("services/ycssomus/som/lots/"+lot_num+"/service_order/"+service_order_id_3+"");
		response.then().log().all().assertThat().statusCode(200);


//Add SO 4
		RestAssured.baseURI="https://g2-qa4.copart.com";
		response=given().headers(Common_Headers.SOHeaders())
				.header("Authorization","bearer"+accesstoken)
				.header("x-lock-token",+token)
				.body(PayLoad.AddSO4())
				.when().post("services/ycssomus/som/lots/"+lot_num+"/service_order");
		response.then().log().all();
		int service_order_id_4= response.jsonPath().getInt("data.service_order_id");
		System.out.println("service_order_id 4 - " +service_order_id_4);

//Delete SO
		RestAssured.baseURI="https://g2-qa4.copart.com";
		response=given().headers(Common_Headers.SOHeaders())
				.header("Authorization","bearer"+accesstoken)
				.header("x-lock-token",+token)
				.body(PayLoad.DeleteS0())
				.when().put("services/ycssomus/som/lots/"+lot_num+"/service_order/"+service_order_id_4+"");
		response.then().log().all().assertThat().statusCode(200);
	}
}