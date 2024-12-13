package base_url;

import com.github.javafaker.Faker;
import io.restassured.builder.RequestSpecBuilder;
import io.restassured.http.ContentType;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.*;
import pojos.CategoryPojo;
import pojos.TagsPojo;

import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class PetStoreApiBaseUrl {
    public static Faker faker = new Faker();
    public static Integer tagsId;
    public static String tagsName;
    public static String photoUrl;
    public static Integer categoryId;
    public static String categoryName;
    public static String petName;
    public static Long petId;
    public static String[] petStatus = new String[]{"available", "sold", "pending"};
    public static String petStatus1;
    public static List<TagsPojo> tags;
    public static List<String> photoUrls;
    public static CategoryPojo category;

    @BeforeClass
    public void setup() {
        tagsId = faker.number().randomDigit();
        tagsName = faker.name().name();
        photoUrl = faker.internet().url();
        categoryId = faker.number().randomDigit();
        categoryName = faker.name().name();
        petName = faker.name().name();
        petId = faker.number().randomNumber();
        petStatus1 = petStatus[new Random().nextInt(petStatus.length)];
        tags = Arrays.asList(new TagsPojo(tagsId, tagsName));
        photoUrls = Arrays.asList(photoUrl);
        category = new CategoryPojo(categoryId, categoryName);
    }

    public static RequestSpecification spec;

    @BeforeTest
    public void Setup() {

        spec = new RequestSpecBuilder()
                .setContentType(ContentType.JSON)
                .setBaseUri("https://petstore.swagger.io/v2")
                .build();
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("Yeni test başladı.");
    }


}
