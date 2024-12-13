package utulities;

import org.testng.annotations.DataProvider;
import pojos.CategoryPojo;
import pojos.TagsPojo;

import java.util.Arrays;

public class DataProviderUtil {

    @DataProvider(name = "petDatas")
    public Object[][] createPetData() {
        return new Object[][]{
                {10L, new CategoryPojo(10, "MustafaTest"), "MustafaTest", Arrays.asList("MustafaTest"), Arrays.asList(new TagsPojo(10, "MustafaTest")), "available"},
                {20L, new CategoryPojo(20, "MustafaTest2"), "MustafaTest2", Arrays.asList("MustafaTest2"), Arrays.asList(new TagsPojo(20, "MustafaTest2")), "available"},
                {30L, new CategoryPojo(30, "MustafaTest3"), "MustafaTest3", Arrays.asList("MustafaTest3"), Arrays.asList(new TagsPojo(30, "MustafaTest3")), "available"},
                {40L, new CategoryPojo(40, "MustafaTest4"), "MustafaTest4", Arrays.asList("MustafaTest4"), Arrays.asList(new TagsPojo(40, "MustafaTest4")), "available"},
                {50L, new CategoryPojo(50, "MustafaTest5"), "MustafaTest5", Arrays.asList("MustafaTest5"), Arrays.asList(new TagsPojo(50, "MustafaTest5")), "available"}
        };
    }

    ;


    @DataProvider(name = "newPetDatas")
    public Object[][] updateNewPetData() {
        return new Object[][]{
                {10L, new CategoryPojo(60, "Category60"), "Pet60", Arrays.asList("photoUrl60"), Arrays.asList(new TagsPojo(60, "tag60")), "available"},
                {20L, new CategoryPojo(70, "Category70"), "Pet70", Arrays.asList("photoUrl70"), Arrays.asList(new TagsPojo(70, "tag70")), "sold"},
                {30L, new CategoryPojo(80, "Category80"), "Pet80", Arrays.asList("photoUrl80"), Arrays.asList(new TagsPojo(80, "tag80")), "pending"},
                {40L, new CategoryPojo(90, "Category90"), "Pet90", Arrays.asList("photoUrl90"), Arrays.asList(new TagsPojo(90, "tag90")), "available"},
                {50L, new CategoryPojo(100, "Category100"), "Pet100", Arrays.asList("photoUrl100"), Arrays.asList(new TagsPojo(100, "tag100")), "sold"}
        };
    }


}



