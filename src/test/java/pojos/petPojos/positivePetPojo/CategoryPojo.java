package pojos.petPojos.positivePetPojo;

public class CategoryPojo {
    /*
    "category": {
    "id": 5,
    "name": "Dog"
  }
     */
    private Long id;
    private String name;

    public CategoryPojo(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public CategoryPojo() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
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
