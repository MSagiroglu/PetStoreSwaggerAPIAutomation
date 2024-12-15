package pojos.petPojos.negativePetPojos;

import java.util.Objects;

public class NegativeTagsPojo {
    /*
    tags": [
    {
      "id": 0,
      "name": "string"
    }
  ]
     */
    private String id;
    private Integer name;

    public NegativeTagsPojo(String id, Integer name) {
        this.id = id;
        this.name = name;
    }

    public NegativeTagsPojo() {
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
        return "TagsPojo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NegativeTagsPojo tagsPojo = (NegativeTagsPojo) o;
        return Objects.equals(id, tagsPojo.id) && Objects.equals(name, tagsPojo.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }
}
