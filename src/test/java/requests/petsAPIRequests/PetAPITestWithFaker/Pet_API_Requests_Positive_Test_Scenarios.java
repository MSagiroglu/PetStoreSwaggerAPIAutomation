package requests.petsAPIRequests.PetAPITestWithFaker;

import base_url.PetStoreApiBaseUrl;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.petPojos.positivePetPojo.PetPojo;
import pojos.petPojos.positivePetPojo.TagsPojo;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Pet_API_Requests_Positive_Test_Scenarios extends PetStoreApiBaseUrl {
    public static ExtentReports extent;
    public static ExtentTest test;
    public static ExtentHtmlReporter htmlReporter;


    @Test(priority = 1)
    public static void post_Api_Create_Pet_With_Faker() {

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
        bilgiNotu("Response Süresi Verisi Dogrulandı");
        assertTrue(response.getTime() < 1500);
    }

    @Test(priority = 3, dependsOnMethods = "post_Api_Create_Pet_With_Faker")
    public void get_Api_Find_ById_With_Faker() {
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
        bilgiNotu("Response Süresi Verisi Dogrulandı");
        assertTrue(response.getTime() < 1500);
    }


    @Test(priority = 2, dependsOnMethods = "post_Api_Create_Pet_With_Faker")
    public void put_Api_Update_Pet_With_Faker() {
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
        bilgiNotu("Response Süresi Verisi Dogrulandı");
        assertTrue(response.getTime() < 1500);
    }

    @Test(priority = 5, dependsOnMethods = "post_Api_Create_Pet_With_Faker")
    public void get_Api_Find_ByStatus_With_Faker() {
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
        bilgiNotu("Response Süresi Verisi Dogrulandı");
        assertTrue(response.getTime() < 1500);

        for (PetPojo pet : actualData) {
            bilgiNotu("Respons Liste verileri dogrulandı ve status verileri dogrulandı");
            assertEquals(pet.getStatus(), petStatus1);
        }
    }

    @Test(priority = 4, dependsOnMethods = {"post_Api_Create_Pet_With_Faker", "put_Api_Update_Pet_With_Faker"})
    public void delete_Api_Delete_Pet_With_Faker() {
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
        bilgiNotu("Response Süresi Verisi Dogrulandı");
        assertTrue(response.getTime() < 1500);
    }

}
