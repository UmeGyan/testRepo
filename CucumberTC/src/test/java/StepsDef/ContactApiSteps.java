package StepsDef;
import com.ContactApi;
import com.Contact;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.io.IOException;
import org.junit.Assert;
import java.io.File;
import java.io.FileNotFoundException;

public class ContactApiSteps {

	private static final String FILE_PATH = "src/test/java/resources/example.csv";

    @Given("the CSV file is generated with randomly generated data")
    public void the_generated_CSV_file_exists() throws FileNotFoundException, IOException{
    	Contact con = new Contact();
    	con.csvWrite();
        File file = new File(FILE_PATH);
        Assert.assertTrue(file.exists());
        System.out.println("CSV file with random data exist in local directory");
    }

    @When("I read the CSV file and create contacts using the REST API")
    public void i_read_the_csv_file_and_create_contacts_using_the_rest_api() throws IOException{   	 
    	System.out.println("Payload created, assert to be checked in next step");
    	
    }

    @Then("the response status code should be {int} for each contact created")
    public void the_response_status_code_should_be_for_each_contact_created(Integer int1) throws IOException{
    	ContactApi conapi = new ContactApi();
    	conapi.CsvReader();
    }
}
