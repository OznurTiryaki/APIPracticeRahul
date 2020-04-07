package files;


import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;
import org.testng.annotations.Test;

import java.io.IOException;
import java.nio.file.Paths;

import static io.restassured.RestAssured.given;
import static java.nio.file.Files.readAllBytes;

public class StaticJson {

    @Test

    public void addBook() throws IOException {

        RestAssured.baseURI="http://216.10.245.166";

        String resp=given().

                header("Content-Type","application/json").

                body(GenerateStringFromResource("/Users/oznurtiryakii/Desktop/AddBookRequest.json")).

                when().

                post("/Library/Addbook.php").

                then().assertThat().statusCode(200).

                extract().response().toString();

        JsonPath js= ReusableMethods.rawToJson(resp);

        String id=js.get("ID");

        System.out.println(id);



        //deleteBOok

    }

    public static String GenerateStringFromResource(String path) throws IOException {

        return new String(readAllBytes(Paths.get(path)));



    }

}

