package pojos.petPojos.negativePetPojos;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import pojos.petPojos.positivePetPojo.CategoryPojo;
import pojos.petPojos.positivePetPojo.TagsPojo;

import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class NegativePetPojo {

    private Boolean id;
    private NegativeCategoryPojo category;
    private Integer name;
    private List<Integer> photoUrls;
    private List<NegativeTagsPojo> tags;
    private String  status;

    public NegativePetPojo(Boolean id, NegativeCategoryPojo category, Integer name, List<Integer> photoUrls, List<NegativeTagsPojo> tags, String status) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.photoUrls = photoUrls;
        this.tags = tags;
        this.status = status;
    }

    public NegativePetPojo() {
    }

    public Boolean getId() {
        return id;
    }

    public void setId(Boolean id) {
        this.id = id;
    }

    public NegativeCategoryPojo getCategory() {
        return category;
    }

    public void setCategory(NegativeCategoryPojo category) {
        this.category = category;
    }

    public Integer getName() {
        return name;
    }

    public void setName(Integer name) {
        this.name = name;
    }

    public List<Integer> getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(List<Integer> photoUrls) {
        this.photoUrls = photoUrls;
    }

    public List<NegativeTagsPojo> getTags() {
        return tags;
    }

    public void setTags(List<NegativeTagsPojo> tags) {
        this.tags = tags;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "PetPojo{" +
                "id=" + id +
                ", category=" + category +
                ", name='" + name + '\'' +
                ", photoUrls=" + photoUrls +
                ", tags=" + tags +
                ", status='" + status + '\'' +
                '}';
    }
}
