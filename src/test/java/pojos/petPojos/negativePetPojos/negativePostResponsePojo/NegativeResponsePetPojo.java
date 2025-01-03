package pojos.petPojos.negativePetPojos.negativePostResponsePojo;



import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = false)
public class NegativeResponsePetPojo {

   /*
   {
    "code": 500,
    "type": "unknown",
    "message": "something bad happened"
}
    */

    private int code;
    private String type;
    private String message;

    public NegativeResponsePetPojo(int code, String type, String message) {
        this.code = code;
        this.type = type;
        this.message = message;
    }

    public NegativeResponsePetPojo() {
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "NegativePetPojo{" +
                "code=" + code +
                ", type='" + type + '\'' +
                ", message='" + message + '\'' +
                '}';
    }
}
