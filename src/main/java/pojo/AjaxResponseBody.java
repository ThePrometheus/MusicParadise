package pojo;

/**
 * Created by nazar on 12.04.17.
 */
public class AjaxResponseBody {
    private String message;
    private String code;

    public AjaxResponseBody(String message, String code) {
        this.message = message;
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    @Override
    public String toString() {
        return "AjaxResponseBody{" +
                "message='" + message + '\'' +
                ", code='" + code + '\'' +
                '}';
    }
}
