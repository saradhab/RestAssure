import static org.codehaus.groovy.tools.shell.util.Logger.io;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.get;
import io.restassured.RestAssured;
import static io.restassured.RestAssured.get;
import org.testng.Assert;
import org.testng.annotations.Test;

public class RestAssuredtest {


        @Test //TestNG annotation
        public void verifyEmployeeRESTService() {
            // Setting base URL and port numbers for Amazon Service
            RestAssured.baseURI = "http://ec2-3-15-180-132.us-east-2.compute.amazonaws.com";
            RestAssured.port = 8080;

            try {
                // Values of expected and actual
                String expected = "[{\"id\":1,\"name\":\"Murali\"}]";
                String actual = get("/employees").asString(); //Calling service via REST Assured

                System.out.println(expected);
                System.out.println(actual);

                Assert.assertEquals(actual, expected);
            } finally {
                //do nothing
            }
        }
}

