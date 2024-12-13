package pojos;

public class CategoryPojo {
    /*
    "category": {
    "id": 5,
    "name": "Dog"
  }
     */
    private Integer id;
    private String name;

    public CategoryPojo(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public CategoryPojo() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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
