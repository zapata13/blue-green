package demo.redhat;

import jakarta.enterprise.context.ApplicationScoped;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class ShapeConfig {

    @ConfigProperty(name = "shape.type")
    String type;

    @ConfigProperty(name = "shape.color")
    String color;

    public String getType() { return type; }
    public String getColor() { return color; }
}
