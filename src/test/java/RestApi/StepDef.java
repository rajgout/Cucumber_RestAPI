package RestApi;

import org.junit.Assert;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class StepDef 
{
	Response response;
	RequestSpecification request;
	
	@Given("^The \"([^\"]*)\" for Get Operation$")
    public void the_something_for_get_operation(String baseuri) throws Throwable {
        request = RestAssured.given()
        		.baseUri(baseuri);
    }

    @When("^User poerform the Get Operation$")
    public void user_poerform_the_get_operation() throws Throwable {
        response =request.get();
        String responseString = response.then().extract().asString();
        System.out.println(responseString);
    }
    
    @Given("^The \"([^\"]*)\" for PATCH Operation and token is \"([^\"]*)\"$")
    public void the_something_for_patch_operation_and_token_is_something(String baseuri, String token) throws Throwable {
    	request = RestAssured.given()
        		.baseUri(baseuri)
        		.contentType(ContentType.JSON)
        		.accept(ContentType.JSON)
        		.auth()
        		.oauth2(token)
        		.body("{\n" + 
        				"    \"name\": \"Postman2\",\n" + 
        				"    \"desription\": \"Test Repo\",\n" + 
        				"    \"homepage\": \"https://github.com/\",\n" + 
        				"    \"private\": false,\n" + 
        				"    \"has_issues\": true,\n" + 
        				"    \"has_projects\": true,\n" + 
        				"    \"has_wiki\": true\n" + 
        				"}");
    }

    @When("^User poerform the PATCH Operation$")
    public void user_poerform_the_patch_operation() throws Throwable {
    	response =request.patch();
        String responseString = response.then().extract().asString();
        System.out.println(responseString);
        
    }
    @Given("^The \"([^\"]*)\" for POST Operation and token is \"([^\"]*)\"$")
    public void the_something_for_post_operation_and_token_is_something(String baseuri, String token) throws Throwable {
    	request = RestAssured.given()
        		.baseUri(baseuri)
        		.contentType(ContentType.JSON)
        		.accept(ContentType.JSON)
        		.auth()
        		.oauth2(token)
        		.body("{\n" + 
        				"    \"name\": \"Postman2\",\n" + 
        				"    \"desription\": \"Test Repo\",\n" + 
        				"    \"homepage\": \"https://github.com/\",\n" + 
        				"    \"private\": false,\n" + 
        				"    \"has_issues\": true,\n" + 
        				"    \"has_projects\": true,\n" + 
        				"    \"has_wiki\": true\n" + 
        				"}");
    }

    @When("^User poerform the POST Operation$")
    public void user_poerform_the_post_operation() throws Throwable {
    	 response =request.post();
         String responseString = response.then().extract().asString();
         System.out.println(responseString);
    }

    @Then("^Resonse should not be null$")
    public void resonse_should_not_be_null() throws Throwable {
        Assert.assertNotNull(response);
    }

    @And("^\"([^\"]*)\" should be as expected$")
    public void something_should_be_as_expected(int responsecode) throws Throwable {
        Assert.assertEquals(responsecode, response.getStatusCode());
    }


}
