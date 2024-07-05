import io.restassured.response.Response;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.equalTo;

public class ReqresTest {
    private final static String URL = "https://reqres.in/";

    @Test
    public void checkSingleUserNoPojo() {
        Specification.installSpecification(Specification.requestSpecification(URL), Specification.responseSpecificationStatus200());
        Response response = given()
                .when()
                .get("api/users/2")
                .then().log().all()
                .body("data.id", equalTo(2))
                .body("data.email", equalTo("janet.weaver@reqres.in"))
                .body("data.first_name", equalTo("Janet"))
                .body("data.last_name", equalTo("Weaver"))
                .body("data.avatar", equalTo("https://reqres.in/img/faces/2-image.jpg"))
                .extract().response();
    }
}
