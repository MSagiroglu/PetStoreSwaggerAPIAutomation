package requests.userAPIRequests;

import base_url.PetStoreApiBaseUrl;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import org.testng.annotations.Test;
import pojos.userPojo.UserPojo;

import static io.restassured.RestAssured.given;
import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class User_API_Requests extends PetStoreApiBaseUrl {
    public static ExtentReports extent;
    public static ExtentTest test;
    public static ExtentHtmlReporter htmlReporter;

    @Test(priority = 1)
    public void post_Api_Create_User_With_Faker() {
        // 1- Set the URL
        bilgiNotu("URL Ayarlandi");
        spec.pathParams("first", "user");

        // 2- Set the expected data
        bilgiNotu("Expected Data Ayarlandi");
        UserPojo payload = new UserPojo(userId, userName, firstName, lastName, email, password, phone, userStatus);
        System.out.println("payload = " + payload);

        // 3- Send the request and get the response
        bilgiNotu("Request Gonderildi");
        Response response = given().spec(spec).contentType(ContentType.JSON).body(payload).when().post("{first}");
        response.prettyPrint();

        // 4- Verify the response
        bilgiNotu("Response kodu gönderildi");
        assertEquals(200, response.statusCode());
        bilgiNotu("Response süresi verisi dogrulandı");
        System.out.println("response.getTime() = " + response.getTime());
        assertTrue(response.getTime() < 1500);
    }

    @Test(priority = 2, dependsOnMethods = "post_Api_Create_User_With_Faker")
    public void get_Api_Display_User_With_Faker() {
        bilgiNotu("URL Ayarlandi");
        // 1- Set the URL
        spec.pathParams("first", "user", "second", userName);
        // 2- Send the request and get the response
        bilgiNotu("Request Gonderildi");
        Response response = given().spec(spec).contentType(ContentType.JSON).when().get("{first}/{second}");
        response.prettyPrint();
        // 3- Verify the response
        UserPojo actualData = response.as(UserPojo.class);
        bilgiNotu("Response kodu gönderildi");
        assertEquals(200, response.statusCode());
        bilgiNotu("User Id verisi dogrulandı");
        assertEquals(actualData.getId(), userId);
        bilgiNotu("User Name verisi dogrulandı");
        assertEquals(actualData.getUsername(), userName);
        bilgiNotu("First Name verisi dogrulandı");
        assertEquals(actualData.getFirstName(), firstName);
        bilgiNotu("Last Name verisi dogrulandı");
        assertEquals(actualData.getLastName(), lastName);
        bilgiNotu("Email verisi dogrulandı");
        assertEquals(actualData.getEmail(), email);
        bilgiNotu("Password verisi dogrulandı");
        assertEquals(actualData.getPassword(), password);
        bilgiNotu("Phone verisi dogrulandı");
        assertEquals(actualData.getPhone(), phone);
        bilgiNotu("User Status verisi dogrulandı");
        assertEquals(actualData.getUserStatus(), userStatus);
        bilgiNotu("Response Süresi Verisi Dogrulandı");
        assertTrue(response.getTime() < 1500);
    }

    @Test(priority = 3)
    public void update_Api_Update_User_With_Faker() {
        bilgiNotu("URL Ayarlandi");
        // 1- Set the URL
        spec.pathParams("first", "user", "second", userName);
        // 2- Set the expected data
        bilgiNotu("Expected Data Ayarlandi");
        Long userId = 10L;
        String firstName = "firstName";
        String lastName = "lastName";
        String email = "email";
        String phone = "phone";
        Integer userStatus = 1;
        UserPojo payload = new UserPojo(userId, userName, firstName, lastName, email, password, phone, userStatus);
        // 3- Send the request and get the response
        bilgiNotu("Request Gonderildi");
        Response response = given().spec(spec).contentType(ContentType.JSON).body(payload).when().put("{first}/{second}");
        response.prettyPrint();
        // 4- Verify the response
        bilgiNotu("Response kodu gönderildi");
        assertEquals(200, response.statusCode());
        bilgiNotu("Response Süresi Verisi Dogrulandı");
        assertTrue(response.getTime() < 1500);
    }

    @Test(priority = 4)
    public void get_Api_login_With_Faker() {
        bilgiNotu("URL Ayarlandi");
        // 1- Set the URL
        spec.pathParams("first", "user", "second", "login").queryParams("username", userName, "password", password);
        // 2-  Send the request and get the response
        bilgiNotu("Request Gonderildi");
        Response response = given().spec(spec).contentType(ContentType.JSON).when().get("{first}/{second}");
        response.prettyPrint();
        // 4- Verify the response
        bilgiNotu("Response kodu gönderildi");
        assertEquals(200, response.statusCode());
        bilgiNotu("Response Mesaj Verisi Dogrulandı");
        assertTrue(response.body().jsonPath().getString("message").contains("logged in user session:"));
        bilgiNotu("Response Süresi Verisi Dogrulandı");
        assertTrue(response.getTime() < 1500);
    }

    @Test(priority = 5)
    public void get_Api_logout() {
        bilgiNotu("URL Ayarlandi");
        // 1- Set the URL
        spec.pathParams("first", "user", "second", "logout");
        // 2-  Send the request and get the response
        bilgiNotu("Request Gonderildi");
        Response response = given().spec(spec).contentType(ContentType.JSON).when().get("{first}/{second}");
        response.prettyPrint();
        // 4- Verify the response
        bilgiNotu("Response kodu gönderildi");
        assertEquals(200, response.statusCode());
        bilgiNotu("Response Mesaj Verisi Dogrulandı");
        assertTrue(response.body().jsonPath().getString("message").equals("ok"));
        bilgiNotu("Response Süresi Verisi Dogrulandı");
        assertTrue(response.getTime() < 1500);
    }

    @Test(priority = 6)
    public void delete_Api_Delete_User_With_Faker() {
        bilgiNotu("URL Ayarlandi");
        // 1- Set the URL
        spec.pathParams("first", "user", "second", userName);
        // 2-  Send the request and get the response
        bilgiNotu("Request Gonderildi");
        Response response = given().spec(spec).contentType(ContentType.JSON).when().delete("{first}/{second}");
        response.prettyPrint();
        // 4- Verify the response
        bilgiNotu("Response kodu gönderildi");
        assertEquals(200, response.statusCode());
        bilgiNotu("Response Mesaj Verisi Dogrulandı");
        assertTrue(response.body().jsonPath().getString("message").equals(userName));
        bilgiNotu("Response Süresi Verisi Dogrulandı");
        assertTrue(response.getTime() < 1500);


    }
}
