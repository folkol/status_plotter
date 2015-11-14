import javax.validation.constraints.NotNull;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Application;
import javax.ws.rs.core.MediaType;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Scanner;

@ApplicationPath("proxy")
@Path("/")
public class StatusProxy extends Application {
    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String proxy(@NotNull @QueryParam("url") String url) throws IOException {
        InputStream inputStream = new URL(url).openStream();
        try(Scanner sc = new Scanner(inputStream)) {
            sc.useDelimiter("\\A");
            return sc.next();
        }
    }
}
