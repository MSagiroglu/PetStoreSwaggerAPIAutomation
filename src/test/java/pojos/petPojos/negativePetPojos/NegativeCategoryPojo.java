package pojos.petPojos.negativePetPojos;

public class NegativeCategoryPojo {
    /*
    "category": {
    "id": 5,
    "name": "Dog"
  }
     */
    private String id;
    private Integer name;

    public NegativeCategoryPojo(String id, Integer name) {
        this.id = id;
        this.name = name;
    }

    public NegativeCategoryPojo() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getName() {
        return name;
    }

    public void setName(Integer name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "CategoryPojo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
