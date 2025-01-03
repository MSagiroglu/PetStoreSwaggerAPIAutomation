package requests.storeAPIRequests;

import base_url.PetStoreApiBaseUrl;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.storePojos.InventoryPojo;
import pojos.storePojos.OrderPostPojo;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class Order_API_Requests extends PetStoreApiBaseUrl {

    public static ExtentReports extent;
    public static ExtentTest test;
    public static ExtentHtmlReporter htmlReporter;

    @Test(priority = 1)
    public void post_Api_Create_Order_With_Faker() {
        bilgiNotu("URL Ayarlandi");
        // 1- Set the URL
        spec.pathParams("first", "store", "second", "order");
        // 2- Set the expected data
        bilgiNotu("Expected Data Ayarlandi");
        OrderPostPojo payload = new OrderPostPojo(orderID, petId, quantity, shipDate, petStatus1, complete);
        // 3- Send the request and get the response
        bilgiNotu("Request Gonderildi");
        Response response = given().spec(spec).contentType(ContentType.JSON).body(payload).when().post("{first}/{second}");
        response.prettyPrint();
        // 4- Verify the response
        OrderPostPojo actualData = response.as(OrderPostPojo.class);
        bilgiNotu("Response kodu gönderildi");
        assertEquals(200, response.statusCode());
        bilgiNotu("Response order id verisi dogrulandı");
        assertEquals(actualData.getId(), payload.getId());
        bilgiNotu("Response pet id verisi dogrulandı");
        assertEquals(actualData.getPetId(), payload.getPetId());
        bilgiNotu("Response quantity verisi dogrulandı");
        assertEquals(actualData.getQuantity(), payload.getQuantity());
        bilgiNotu("Response status verisi dogrulandı");
        assertEquals(actualData.getStatus(), payload.getStatus());
        bilgiNotu("Response complete verisi dogrulandı");
        assertEquals(actualData.getComplete(), payload.getComplete());
        System.out.println("response.getTime() = " + response.getTime());
        assertTrue(response.getTime() < 1500);
    }

    @Test(priority =4)
    public void get_Api_Display_Inventory() {
        bilgiNotu("URL Ayarlandi");
        // 1- Set the URL
        spec.pathParams("first", "store", "second", "inventory");
        // 2- Set the expected data
        bilgiNotu("Expected Data Ayarlandi");
        // 3- Send the request and get the response
        bilgiNotu("Request Gonderildi");
        Response response = given().spec(spec).contentType(ContentType.JSON).when().get("{first}/{second}");
        response.prettyPrint();
        // 4- Verify the response
        InventoryPojo actualData = response.as(InventoryPojo.class);
        response.prettyPrint();
        bilgiNotu("Response kodu gönderildi");
        assertEquals(200, response.statusCode());
        bilgiNotu("Response süresi verisi dogrulandı");
        assertTrue(response.getTime() < 1500);
        System.out.println("response.getTime() = " + response.getTime());

    }

    @Test(dependsOnMethods = "post_Api_Create_Order_With_Faker" , priority = 2)
    public void get_Api_Display_Order_By_OrderId_With_Faker() {
        bilgiNotu("URL Ayarlandi");
        // 1- Set the URL
        spec.pathParams("first", "store", "second", "order", "third", orderID);
        // 2- Set the expected data
        bilgiNotu("Expected Data Ayarlandi");
        // 3- Send the request and get the response
        bilgiNotu("Request Gonderildi");
        Response response = given().spec(spec).contentType(ContentType.JSON).when().get("{first}/{second}/{third}");
        response.prettyPrint();
        // 4- Verify the response
        OrderPostPojo actualData = response.as(OrderPostPojo.class);
        response.prettyPrint();
        bilgiNotu("Response kodu gönderildi");
        assertEquals(200, response.statusCode());
        bilgiNotu("Response order id verisi dogrulandı");
        assertEquals(actualData.getId(), orderID);
        bilgiNotu("Response pet id verisi dogrulandı");
        assertEquals(actualData.getPetId(), petId);
        bilgiNotu("Response quantity verisi dogrulandı");
        assertEquals(actualData.getQuantity(), quantity);
        bilgiNotu("Response status verisi dogrulandı");
        assertEquals(actualData.getStatus(), petStatus1);
        bilgiNotu("Response complete verisi dogrulandı");
        assertEquals(actualData.getComplete(), complete);
        System.out.println("response.getTime() = " + response.getTime());
        assertTrue(response.getTime() < 1500);
    }
    @Test(priority = 3, dependsOnMethods = "post_Api_Create_Order_With_Faker")
    public void delete_Api_Delete_Order_With_Faker() {
        bilgiNotu("URL Ayarlandi");
        // 1- Set the URL
        spec.pathParams("first", "store", "second", "order", "third", orderID);
        // 2- Set the expected data
        bilgiNotu("Expected Data Ayarlandi");
        // 3- Send the request and get the response
        bilgiNotu("Request Gonderildi");
        Response response = given().spec(spec).contentType(ContentType.JSON).when().delete("{first}/{second}/{third}");
        response.prettyPrint();
        // 4- Verify the response
        bilgiNotu("Response kodu gönderildi");
        assertEquals(200, response.statusCode());
        bilgiNotu("Response süresi verisi dogrulandı");
        System.out.println("response.getTime() = " + response.getTime());
        assertTrue(response.getTime() < 1500);
    }
}
