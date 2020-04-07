package apiTest;

import files.payload;
import io.restassured.path.json.JsonPath;


public class ComplexJsonParse {
    public static void main(String[] args) {

        int totalPrice = 0;
        int sum = 0;

        JsonPath js = new JsonPath(payload.CoursePrice());

        //   1. Print No of courses returned by API

        int coursesSize = js.getInt("courses.size()");
        System.out.println(coursesSize);

        //2.Print Purchase Amount

        int purchaseAmount = js.getInt("dashboard.purchaseAmount");
        System.out.println(purchaseAmount);

        //3. Print Title of the first course
        String title = js.getString("courses[0].title");//ilk arrayin icindeki title'i alir
        System.out.println(title);

        //4. Print All course titles and their respective Prices
        for (int i = 0; i < coursesSize; i++) {
            System.out.println(js.getString("courses[" + i + "].title"));
            System.out.println(js.getString("courses[" + i + "].price"));
        }

        //5. Print no of copies sold by RPA Course
        for (int i = 0; i < coursesSize; i++) {
            if (js.getString("courses[" + i + "].title").equalsIgnoreCase("RPA")) {
                System.out.println(js.getString("courses[" + i + "].copies")); //10
                break;
            }

        }


    }}
