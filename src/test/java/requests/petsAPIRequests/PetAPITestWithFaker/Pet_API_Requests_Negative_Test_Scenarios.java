package requests.petsAPIRequests.PetAPITestWithFaker;

import base_url.PetStoreApiBaseUrl;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.petPojos.negativePetPojos.NegativePetPojo;
import pojos.petPojos.negativePetPojos.negativePostResponsePojo.NegativeResponsePetPojo;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Pet_API_Requests_Negative_Test_Scenarios extends PetStoreApiBaseUrl {
    public static ExtentReports extent;
    public static ExtentTest test;
    public static ExtentHtmlReporter htmlReporter;


    @Test(priority = 1)
    public static void post_Api_Create_Pet() {

        // 1- Set the URL
        bilgiNotu("URL Ayarlandi");

        spec.pathParams("first", "pet");
        // 2- Set the expected data
        bilgiNotu("Expected Data Ayarlandi");

        NegativePetPojo invalidPayload = new NegativePetPojo(false, null, null, null, null, null
        );
        System.out.println("invalidPayload = " + invalidPayload);
        // 3- Send the request and get the response
        bilgiNotu("POST Request  Gonderildi");
        Response response = given()
                .spec(spec)
                .contentType(ContentType.JSON)
                .body(invalidPayload)
                .when()
                .post("{first}");
        response.prettyPrint();


        // 4- Verify the response
        NegativeResponsePetPojo actualData = response.as(NegativeResponsePetPojo.class);
        System.out.println("actualData = " + actualData);
        bilgiNotu("Response kodu doğrulandı");
        assertEquals(500, response.statusCode());
        bilgiNotu("Response message verisi dogrulandı");
        assertEquals(actualData.getMessage(), "something bad happened");
        bilgiNotu("Response type verisi dogrulandı");
        assertEquals(actualData.getType(), "unknown");
        bilgiNotu("Response Süresi Verisi Dogrulandı");
        assertTrue(response.getTime() < 1500);
    }
}
