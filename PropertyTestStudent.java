package propertypackage;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PropertyTestStudent {
    private Property property;

    @BeforeEach
    public void setUp() {
        property = new Property("Maple House", "Springfield", 2500, "Alice Johnson");
    }

    @Test
    public void testConstructor() {
        assertEquals("Maple House", property.getPropertyName());
        assertEquals("Springfield", property.getCity());
        assertEquals(2500, property.getRentAmount());
        assertEquals("Alice Johnson", property.getOwner());
    }

    @Test
    public void testConstructorWithPlot() {
        Property propertyWithPlot = new Property("Oak Villa", "Metropolis", 3000, "Bob Smith", 1, 1, 4, 4);
        assertEquals("Oak Villa", propertyWithPlot.getPropertyName());
        assertEquals("Metropolis", propertyWithPlot.getCity());
        assertEquals(3000, propertyWithPlot.getRentAmount());
        assertEquals("Bob Smith", propertyWithPlot.getOwner());
        assertEquals(new Plot(1, 1, 4, 4), propertyWithPlot.getPlot());
    }

    @Test
    public void testCopyConstructor() {
        Property copyProperty = new Property(property);
        assertEquals(property.getPropertyName(), copyProperty.getPropertyName());
        assertEquals(property.getCity(), copyProperty.getCity());
        assertEquals(property.getRentAmount(), copyProperty.getRentAmount());
        assertEquals(property.getOwner(), copyProperty.getOwner());
    }

    @Test
    public void testSettersAndGetters() {
        property.setPropertyName("Sunshine Apartments");
        property.setCity("Newport");
        property.setRentAmount(4000);
        property.setOwner("Chris Green");

        assertEquals("Sunshine Apartments", property.getPropertyName());
        assertEquals("Newport", property.getCity());
        assertEquals(4000, property.getRentAmount());
        assertEquals("Chris Green", property.getOwner());
    }

    @Test
    public void testSetPlot() {
        Plot newPlot = new Plot(2, 2, 6, 6);
        property.setPlot(newPlot);

        assertEquals(newPlot, property.getPlot());
    }

    @Test
    public void testToString() {
        assertEquals("Maple House,Springfield,Alice Johnson,2500.0", property.toString());
    }
}

