package pojos;

import java.util.Objects;

public class TagsPojo {
    /*
    tags": [
    {
      "id": 0,
      "name": "string"
    }
  ]
     */
    private Integer id;
    private String name;

    public TagsPojo(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public TagsPojo() {
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
        return "TagsPojo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TagsPojo tagsPojo = (TagsPojo) o;
        return Objects.equals(id, tagsPojo.id) && Objects.equals(name, tagsPojo.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
