package base_url;

import com.github.javafaker.Faker;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.*;
import pojos.CategoryPojo;
import pojos.TagsPojo;
import utilities.ExtentReport;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PetStoreApiBaseUrl extends ExtentReport {



    public static RequestSpecification spec;

    @BeforeClass
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
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Yeni test başladı.");
    }


}
