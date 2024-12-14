package requests.petsAPIRequests.APITestwithFaker;

import base_url.PetStoreApiBaseUrl;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.PetPojo;
import pojos.TagsPojo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;

public class Test_02_PetAPIRequestsNegativeTestScenarios extends PetStoreApiBaseUrl {
    public static ExtentReports extent;
    public static ExtentTest test;
    public static ExtentHtmlReporter htmlReporter;


    @Test(priority = 1)
    public static void post() {

        // 1- Set the URL
        bilgiNotu("URL Ayarlandi");

        spec.pathParams("first", "pet");
        // 2- Set the expected data
        bilgiNotu("Expected Data Ayarlandi");

        PetPojo payload = new PetPojo(petId, category, petName, photoUrls, tags, petStatus1);
        System.out.println("payload = " + payload);
        // 3- Send the request and get the response
        bilgiNotu("POST Request  Gonderildi");
        Response response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .post("{first}");
        response.prettyPrint();


        // 4- Verify the response
        PetPojo actualData = response.as(PetPojo.class);
        System.out.println("actualData = " + actualData);
        bilgiNotu("Response kodu doğrulandı");
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

    @Test(priority = 3, dependsOnMethods = "post")
    public void getById() {
        // 1- Set the URL
        bilgiNotu("URL Ayarlandi");
        spec.pathParams("first", "pet", "second", petId);
        // 2- Send the request and get the response
        bilgiNotu("GET Request Gonderildi");
        Response response = given().spec(spec).contentType(ContentType.JSON).when().get("{first}/{second}");
        response.prettyPrint();
        // 3- Verify the response
        PetPojo actualData = response.as(PetPojo.class);
        System.out.println("actualData = " + actualData);
        bilgiNotu("Response kodu doğrulandı");
        assertEquals(200, response.statusCode());
        bilgiNotu("Response name verisi dogrulandı");
        assertEquals(actualData.getName(), "MustafaTest");
        bilgiNotu("Response category verisi dogrulandı");
        assertEquals(actualData.getCategory().getId(), categoryId);
        assertEquals(actualData.getCategory().getName(), categoryName);
        bilgiNotu("Response tags verisi dogrulandı");
        assertEquals(actualData.getTags(), Collections.singletonList(new TagsPojo(tagsId, tagsName)));
        bilgiNotu("Response status verisi dogrulandı");
        assertEquals(actualData.getStatus(), "sold");
        bilgiNotu("Response photoUrls verisi dogrulandı");
        assertEquals(actualData.getPhotoUrls(), Collections.singletonList(photoUrl));
        bilgiNotu("Response id verisi dogrulandı");
        assertEquals(actualData.getId(), petId);
    }


    @Test(priority = 2, dependsOnMethods = "post")
    public void put() {
        // 1- Set the URL
        bilgiNotu("URL Ayarlandi");
        spec.pathParams("first", "pet");
        // 2- Set the expected data
        bilgiNotu("Expected Data Ayarlandi");
        PetPojo payload = new PetPojo(petId, category, "MustafaTest", photoUrls, tags, "sold");
        System.out.println("payload = " + payload);
        // 3- Send the request and get the response
        bilgiNotu("PUT Request Gonderildi");
        Response response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .body(payload)
                .when()
                .put("{first}");
        response.prettyPrint();
        // 4- Verify the response
        PetPojo actualData = response.as(PetPojo.class);
        System.out.println("actualData = " + actualData);
        bilgiNotu("Response kodu doğrulandı");
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

    @Test(priority = 5, dependsOnMethods = "post")
    public void getByStatus() {
        // 1- Set the URL
        bilgiNotu("URL Ayarlandi");
        spec.pathParams("first", "pet", "second", "findByStatus").queryParam("status", petStatus1); // Durum parametresini ayarlayın
        // 2- Send the request and get the response
        bilgiNotu("GET Request Gonderildi");
        Response response = given().spec(spec).contentType(ContentType.JSON).when().get("{first}/{second}");
        System.out.println("petStatus = " + petStatus1);
        response.prettyPrint();
        // 3- Verify the response
        List<PetPojo> actualData = Arrays.asList(response.getBody().as(PetPojo[].class));
        //List<PetPojo> actualData = response.as(List.class);
        System.out.println("actualData = " + actualData);
        bilgiNotu("Response kodu doğrulandı");
        assertEquals(200, response.statusCode());

        for (PetPojo pet : actualData) {
            bilgiNotu("Respons Liste verileri dogrulandı ve status verileri dogrulandı");
            assertEquals(pet.getStatus(), petStatus1);
        }
    }

    @Test(priority = 4, dependsOnMethods = {"post", "put"})
    public void delete() {
        // 1- Set the URL
        bilgiNotu("URL Ayarlandi");
        spec.pathParams("first", "pet", "second", petId);

        // 2- Send the request and get the response
        bilgiNotu("DELETE Request Gonderildi");
        Response response = given().spec(spec).contentType(ContentType.JSON).header("api_key", "special-key").when().delete("{first}/{second}");
        response.prettyPrint();
        // 3- Verify the response
        bilgiNotu("Response kodu doğrulandı");
        assertEquals(200, response.statusCode());
        bilgiNotu("Response message verisi dogrulandı");
        assertEquals(response.body().jsonPath().getString("message"), petId.toString());
    }

}
