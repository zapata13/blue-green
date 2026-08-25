package demo.redhat;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import java.util.Map;


@Path("/api/shape")
@Produces(MediaType.APPLICATION_JSON)
public class ShapeResource {

    @Inject
    ShapeConfig shapeConfig;

    @GET
    public Map<String, String> getShape() {
        return Map.of("type", shapeConfig.getType(), "color", shapeConfig.getColor());
    }
}
