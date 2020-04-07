package files;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import static io.restassured.RestAssured.given;
import static io.restassured.RestAssured.when;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;



public class DynamicJson {


    @Test(dataProvider = "BooksData")

    public void addBook(String isbn, String aisle) {

        RestAssured.baseURI = "http://216.10.245.166";

    Response resp = given().

                header("Content-Type", "application/json").

                body(payload.Addbook("adsfs", "6464"))

                .when().post("/Library/Addbook.php").

                        then().assertThat().statusCode(200).

                        extract().response();

        JsonPath js = ReusableMethods.rawToJson(resp.toString());

        String id = js.get("ID");

        System.out.println(id);


        //deleteBOok

    }

    @DataProvider(name = "BooksData")

    public Object[][] getData() {

//array=collection of elements

//multidimensional array= collection of arrays

        return new Object[][] {{"ojfwrx", "9363" } , { "cweese", "4253" } , { "rkmfet", "533" } };

    }


}









