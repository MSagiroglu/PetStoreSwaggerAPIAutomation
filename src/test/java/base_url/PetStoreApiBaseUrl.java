package base_url;

import com.github.javafaker.Faker;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.*;
import pojos.petPojos.positivePetPojo.CategoryPojo;
import pojos.petPojos.positivePetPojo.TagsPojo;
import utilities.ExtentReport;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PetStoreApiBaseUrl extends ExtentReport {



    public static RequestSpecification spec;

    @BeforeMethod
    public void Setup() {

        spec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri("https://petstore.swagger.io/v2")
                .build();
    }
    public static Faker faker = new Faker();
    public static Long tagsId;
    public static String tagsName;
    public static String photoUrl;
    public static Long categoryId;
    public static String categoryName;
    public static String petName;
    public static Long petId;
    public static String[] petStatus = new String[]{"available", "sold", "pending"};
    public static String petStatus1;
    public static List<TagsPojo> tags;
    public static List<String> photoUrls;
    public static CategoryPojo category;
    public static Long orderID;
    public static Integer quantity;
    public static LocalDateTime now = LocalDateTime.now();
    public static DateTimeFormatter formatter = DateTimeFormatter.ISO_DATE_TIME;
    public static String shipDate ;
    public static Boolean complete ;
    public static Long userId ;
    public static String userName;
    public static String firstName;
    public static String lastName;
    public static String email;
    public static String password;
    public static String phone;
    public static Integer userStatus;

    @BeforeSuite
    public void setup() {
        tagsId = faker.number().randomNumber(15,true);
        tagsName = faker.name().name();
        photoUrl = faker.internet().url();
        categoryId = faker.number().randomNumber(15,true);
        categoryName = faker.name().name();
        petName = faker.name().name();
        petId = faker.number().randomNumber();
        petStatus1 = petStatus[new Random().nextInt(petStatus.length)];
        tags = Arrays.asList(new TagsPojo(tagsId, tagsName));
        photoUrls = Arrays.asList(photoUrl);
        category = new CategoryPojo(categoryId, categoryName);
        orderID = faker.number().randomNumber();
        quantity = faker.number().randomDigit();
        shipDate = now.format(formatter);
        complete=faker.bool().bool();
        userId = faker.number().randomNumber();
        userName = faker.name().username();
        firstName = faker.name().firstName();
        lastName = faker.name().lastName();
        email = faker.internet().emailAddress();
        password = faker.internet().password();
        phone = faker.phoneNumber().cellPhone();
        userStatus = faker.number().randomDigit();
    }




}
