import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.WebResource;
import org.junit.*;

import play.mvc.*;
import play.test.*;
import play.libs.F.*;

import static play.test.Helpers.*;
import static org.fest.assertions.Assertions.*;

import static org.fluentlenium.core.filter.FilterConstructor.*;

public class IntegrationTest {

    @Test
    public void test() {
        running(testServer(3333, fakeApplication()), HTMLUNIT, new Callback<TestBrowser>() {
            public void invoke(TestBrowser browser) {
                Client client = Client.create();
                WebResource resource = client.resource("http://localhost:3333");
                String response = resource.get(String.class);
                assertThat(response).isEqualTo("Your new application is ready.");
            }
        });
    }
  
}
