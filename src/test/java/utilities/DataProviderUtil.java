package utilities;

import org.testng.annotations.DataProvider;
import pojos.CategoryPojo;
import pojos.TagsPojo;

import java.util.Arrays;

public class DataProviderUtil {

    @DataProvider(name = "petDatas")
    public Object[][] createPetData() {
        return new Object[][]{
                {10L, new CategoryPojo(10L, "MustafaTest"), "MustafaTest", Arrays.asList("MustafaTest"), Arrays.asList(new TagsPojo(10L, "MustafaTest")), "available"},
                {20L, new CategoryPojo(20L, "MustafaTest2"), "MustafaTest2", Arrays.asList("MustafaTest2"), Arrays.asList(new TagsPojo(20L, "MustafaTest2")), "available"},
                {30L, new CategoryPojo(30L, "MustafaTest3"), "MustafaTest3", Arrays.asList("MustafaTest3"), Arrays.asList(new TagsPojo(30L, "MustafaTest3")), "available"},
                {40L, new CategoryPojo(40L, "MustafaTest4"), "MustafaTest4", Arrays.asList("MustafaTest4"), Arrays.asList(new TagsPojo(40L, "MustafaTest4")), "available"},
                {50L, new CategoryPojo(50L, "MustafaTest5"), "MustafaTest5", Arrays.asList("MustafaTest5"), Arrays.asList(new TagsPojo(50L, "MustafaTest5")), "available"}
        };
    }

    ;


    @DataProvider(name = "newPetDatas")
    public Object[][] updateNewPetData() {
        return new Object[][]{
                {10L, new CategoryPojo(60L, "Category60"), "Pet60", Arrays.asList("photoUrl60"), Arrays.asList(new TagsPojo(60L, "tag60")), "available"},
                {20L, new CategoryPojo(70L, "Category70"), "Pet70", Arrays.asList("photoUrl70"), Arrays.asList(new TagsPojo(70L, "tag70")), "sold"},
                {30L, new CategoryPojo(80L, "Category80"), "Pet80", Arrays.asList("photoUrl80"), Arrays.asList(new TagsPojo(80L, "tag80")), "pending"},
                {40L, new CategoryPojo(90L, "Category90"), "Pet90", Arrays.asList("photoUrl90"), Arrays.asList(new TagsPojo(90L, "tag90")), "available"},
                {50L, new CategoryPojo(100L, "Category100"), "Pet100", Arrays.asList("photoUrl100"), Arrays.asList(new TagsPojo(100L, "tag100")), "sold"}
        };
    }


}



