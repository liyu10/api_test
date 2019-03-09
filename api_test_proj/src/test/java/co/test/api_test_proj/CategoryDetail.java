package co.test.api_test_proj;

import static io.restassured.RestAssured.*;
import static org.hamcrest.Matchers.*;
import java.util.List;

import io.restassured.builder.ResponseSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.ResponseSpecification;

import org.testng.Assert;
import org.testng.annotations.*;
import com.jayway.jsonpath.JsonPath;

import org.apache.log4j.Logger;

public class CategoryDetail {

	private static Logger logger = Logger.getLogger(CategoryDetail.class);  
	
	ResponseSpecification checkStatusCodeAndContentType = new ResponseSpecBuilder().expectStatusCode(200)
			.expectContentType(ContentType.JSON).build();

	public static String API_URL = "https://api.tmsandbox.co.nz/v1/Categories/6327/Details.json?catalogue=false";

	@BeforeTest
	public void test_Before() {
		logger.info(" -------  Start CategoryDetail API test -------------");
	}
	
	@Test(priority = 0)
	public void test_APIstatusCodeAndContentType() {
		logger.info(" -------  Start APIstatusCodeAndContentType() test -------------");
		given().when().get(API_URL).then().assertThat().spec(checkStatusCodeAndContentType);

	}

	@Test(priority = 1)
	public void test_CategoryName() {
		logger.info(" -------  Start CategoryName() test -------------");
		logger.info("name :[" + given().when().get(API_URL).path("Name") + "]");
		given().when().get(API_URL).then().assertThat().body("Name", equalTo("Carbon credits"));
	}

	@Test(priority = 2)
	public void test_CanRelist() {
		logger.info(" -------  Start CanRelist() test -------------");
		logger.info("CanRelist :[" + given().when().get(API_URL).path("CanRelist") + "]");
		given().when().get(API_URL).then().assertThat().body("CanRelist", equalTo(true));

	}

	@Test(priority = 3)
	public void test_Promotions() {
		logger.info(" -------  Start Promotions() test -------------");
		String expectString = "2x larger image";

		String json = get(API_URL).asString();
		logger.info("response body :[" + json + "]");

		List<String> Promotions = JsonPath.read(json, "$.Promotions[?(@.Name == 'Gallery')].Description");

		for (String obj : Promotions) {
			if (obj instanceof String) {
				logger.info("Description :[" + obj.toString() + "]");
			}
		}

		if (Promotions.size() == 0)
			Assert.fail("No expected promotion found.");
		else
			Assert.assertEquals(true, Promotions.get(0).contains(expectString));

	}
	
	@AfterTest
	public void test_After() {
		logger.info(" -------  End CategoryDetail API test -------------");
	}
}
