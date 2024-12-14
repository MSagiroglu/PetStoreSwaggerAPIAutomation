package requests.petsAPIRequests.APITestWithDataProvider;

import base_url.PetStoreApiBaseUrl;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.CategoryPojo;
import pojos.PetPojo;
import pojos.TagsPojo;
import utilities.DataProviderUtil;

import java.util.List;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class Test_02_PetAPIRequestsWithDataProvidersPositiveTestScenarios extends PetStoreApiBaseUrl {
    public static ExtentReports extent;
    public static ExtentTest test;
    public static ExtentHtmlReporter htmlReporter;
    @Test(priority = 1, dataProvider = "petDatas", dataProviderClass = DataProviderUtil.class)
    public static void post(Long id, CategoryPojo category, String name, List<String> photoUrls, List<TagsPojo> tags, String status) {
        // 1- Set the URL
        bilgiNotu("URL Ayarlandi");
        spec.pathParams("first", "pet");
        // 2- Set the expected data
        bilgiNotu("Expected Data Ayarlandi");
        PetPojo payload = new PetPojo(id, category, name, photoUrls, tags, status);
        System.out.println("payload = " + payload);
        // 3- Send the request and get the response
        bilgiNotu("POST Request  Gonderildi");
        Response response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .body(payload).when()
                .post("{first}");
        response.prettyPrint();


        // 4- Verify the response

        PetPojo actualData = response.as(PetPojo.class);
        System.out.println("actualData = " + actualData);
        bilgiNotu("Response kodu dogrulandı");
        assertEquals(200, response.statusCode());
        bilgiNotu("Response name verisi dogrulandı");
        assertEquals(actualData.getName(), payload.getName());
        bilgiNotu("Response category verisi dogrulandı");
        assertEquals(actualData.getCategory().getId(), payload.getCategory().getId());
        assertEquals(actualData.getCategory().getName(), payload.getCategory().getName());
        bilgiNotu("Response tags verisi dogrulandı");
        assertEquals(actualData.getTags(), payload.getTags());
        bilgiNotu("Response status verisi dogrulandı");
        assertEquals(actualData.getStatus(), payload.getStatus());
        bilgiNotu("Response photoUrls verisi dogrulandı");
        assertEquals(actualData.getPhotoUrls(), payload.getPhotoUrls());
        bilgiNotu("Response id verisi dogrulandı");
        assertEquals(actualData.getId(), payload.getId());
    }

    @Test(priority = 3, dependsOnMethods = "post", dataProvider = "newPetDatas", dataProviderClass = DataProviderUtil.class)
    public void getById(Long id, CategoryPojo category, String name, List<String> photoUrls, List<TagsPojo> tags, String status) {
        // 1- Set the URL
        bilgiNotu("URL Ayarlandi");
        spec.pathParams("first", "pet", "second", id);
        // 2- Send the request and get the response
        bilgiNotu("GET Request  Gonderildi");
        Response response = given().spec(spec).contentType(ContentType.JSON).when().get("{first}/{second}");
        response.prettyPrint();
        // 3- Verify the response
        PetPojo actualData = response.as(PetPojo.class);
        System.out.println("actualData = " + actualData);
        bilgiNotu("Response kodu dogrulandı");
        assertEquals(200, response.statusCode());
        bilgiNotu("Response name verisi dogrulandı");
        assertEquals(actualData.getName(), name);
        bilgiNotu("Response category verisi dogrulandı");
        assertEquals(actualData.getCategory().getId(), category.getId());
        assertEquals(actualData.getCategory().getName(), category.getName());
        bilgiNotu("Response tags verisi dogrulandı");
        assertEquals(actualData.getTags(), tags);
        bilgiNotu("Response status verisi dogrulandı");
        assertEquals(actualData.getStatus(), status);
        bilgiNotu("Response photoUrls verisi dogrulandı");
        assertEquals(actualData.getPhotoUrls(), photoUrls);
        bilgiNotu("Response id verisi dogrulandı");
        assertEquals(actualData.getId(), id);
    }


    @Test(priority = 2, dependsOnMethods = "post", dataProvider = "newPetDatas", dataProviderClass = DataProviderUtil.class)
    public void put(Long id, CategoryPojo category, String name, List<String> photoUrls, List<TagsPojo> tags, String status) {
        // 1- Set the URL
        bilgiNotu("URL Ayarlandi");
        spec.pathParams("first", "pet");
        // 2- Set the expected data
        bilgiNotu("Expected Data Ayarlandi");
        PetPojo payload = new PetPojo(id, category, name, photoUrls, tags, status);
        System.out.println("payload = " + payload);
        // 3- Send the PUT request and get the response
        bilgiNotu("PUT Request  Gonderildi");
        Response response = given().spec(spec).contentType(ContentType.JSON).body(payload).when().put("{first}");
        response.prettyPrint();
        // 4- Verify the response
        PetPojo actualData = response.as(PetPojo.class);
        System.out.println("actualData = " + actualData);
        bilgiNotu("Response kodu dogrulandı");
        assertEquals(200, response.statusCode());
        bilgiNotu("Response name verisi dogrulandı");
        assertEquals(actualData.getName(), payload.getName());
        bilgiNotu("Response category verisi dogrulandı");
        assertEquals(actualData.getCategory().getId(), payload.getCategory().getId());
        assertEquals(actualData.getCategory().getName(), payload.getCategory().getName());
        bilgiNotu("Response tags verisi dogrulandı");
        assertEquals(actualData.getTags(), payload.getTags());
        bilgiNotu("Response status verisi dogrulandı");
        assertEquals(actualData.getStatus(), payload.getStatus());
        bilgiNotu("Response photoUrls verisi dogrulandı");
        assertEquals(actualData.getPhotoUrls(), payload.getPhotoUrls());
    }


    @Test(priority = 4, dependsOnMethods = "post", dataProvider = "newPetDatas", dataProviderClass = DataProviderUtil.class)
    public void delete(Long id, CategoryPojo category, String name, List<String> photoUrls, List<TagsPojo> tags, String status) {
        // 1- Set the URL
        bilgiNotu("URL Ayarlandi");
        spec.pathParams("first", "pet", "second", id);

        // 2- Send the request and get the response
        bilgiNotu("DELETE Request Gonderildi");
        Response response = given().spec(spec).contentType(ContentType.JSON).header("api_key", "special-key").when().delete("{first}/{second}");
        response.prettyPrint();
        // 3- Verify the response
        bilgiNotu("Response kodu dogrulandı");
        assertEquals(200, response.statusCode());
        bilgiNotu("Response message verisi dogrulandı");
        assertEquals(response.jsonPath().getString("message"),id.toString());
    }

}