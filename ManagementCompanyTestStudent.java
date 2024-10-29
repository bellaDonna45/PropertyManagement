package propertypackage;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ManagementCompanyTestStudent {
    private ManagementCompany company;

    @BeforeEach
    public void setUp() {
        company = new ManagementCompany("THE Experts", "98765", 10.0);
    }

    @Test
    public void testConstructor() {
        assertEquals("Realty Experts", company.getName());
        assertEquals(10.0, company.mgmtFee);
        assertEquals(0, company.getPropertyCount());
        assertNotNull(company.getPlot());
    }

    @Test
    public void testAddProperty() {
        Property p1 = new Property("Blue Town", "Halle-Belle", 3000, "Natsu");
        Property p2 = new Property("Satoru Kamisato", "The MET", 3500, "Lucy");
        
        // Test adding properties
        assertEquals(0, company.addProperty(p1)); // Should succeed and add at index 0
        assertEquals(1, company.addProperty(p2)); // Should succeed and add at index 1
        assertEquals(2, company.getPropertyCount());

        // Test array full condition
        company.addProperty(new Property("Apt A", "Place", 2000, "Owner A"));
        company.addProperty(new Property("Apt B", "Place", 2000, "Owner B"));
        company.addProperty(new Property("Apt C", "Place", 2000, "Owner C"));
        assertEquals(-1, company.addProperty(new Property("Apt D", "Place", 2000, "Owner D"))); // Array is full
    }

    @Test
    public void testAddPropertyWithInvalidCases() {
        // Test null property
        assertEquals(-2, company.addProperty(null));
        
        // Test property with a plot outside the company plot boundaries
        Property outOfBoundsProperty = new Property("Remote Cabin", "Wilderness", 2500, "Explorer", 20, 20, 5, 5);
        assertEquals(-3, company.addProperty(outOfBoundsProperty));

        // Test overlapping properties
        Property p1 = new Property("Building 1", "City", 3000, "Owner", 1, 1, 5, 5);
        Property overlappingProperty = new Property("Building 2", "City", 4000, "Owner", 2, 2, 5, 5);
        
        company.addProperty(p1);
        assertEquals(-4, company.addProperty(overlappingProperty)); // Overlaps with p1
    }

    @Test
    public void testGetTotalRent() {
        company.addProperty(new Property("Apt 1", "City", 1000, "Owner 1"));
        company.addProperty(new Property("Apt 2", "City", 2000, "Owner 2"));
        company.addProperty(new Property("Apt 3", "City", 3000, "Owner 3"));
        
        assertEquals(6000, company.getTotalRent());
    }

    @Test
    public void testGetHighestRentProperty() {
        Property p1 = new Property("Small House", "Town", 1000, "Owner 1");
        Property p2 = new Property("Big House", "Town", 3000, "Owner 2");
        Property p3 = new Property("Apartment", "City", 2000, "Owner 3");
        
        company.addProperty(p1);
        company.addProperty(p2);
        company.addProperty(p3);

        assertEquals(p2, company.getHighestRentProperty());
    }

    @Test
    public void testRemoveLastProperty() {
        Property p1 = new Property("House 1", "Town", 1500, "Owner 1");
        Property p2 = new Property("House 2", "Town", 2500, "Owner 2");
        
        company.addProperty(p1);
        company.addProperty(p2);

        company.removeLastProperty();
        assertEquals(1, company.getPropertyCount());
        assertEquals(p1, company.getHighestRentProperty());
    }

    @Test
    public void testIsPropertiesFull() {
        assertFalse(company.isPropertiesFull());

        for (int i = 0; i < ManagementCompany.MAX_PROPERTY; i++) {
            company.addProperty(new Property("Property " + i, "City", 2000, "Owner"));
        }

        assertTrue(company.isPropertiesFull());
    }

    @Test
    public void testIsManagementFeeValid() {
        assertTrue(company.isManagementFeeValid());
        
        ManagementCompany invalidFeeCompany = new ManagementCompany("Invalid Co.", "000000000", 120.0);
        assertFalse(invalidFeeCompany.isManagementFeeValid());
    }

    @Test
    public void testToString() {
        Property p1 = new Property("Blue Town", "Halle-Belle", 3000, "Natsu");
        Property p2 = new Property("Satoru Kamisato", "The MET", 3500, "Lucy");

        company.addProperty(p1);
        company.addProperty(p2);

        String expected = "List of the properties for THE Experts, taxID: 98765\n" +
                          "______________________________________________________\n" +
                          "Blue Town,Halle-Belle,Natsu,3000.0\n" +
                          "Satoru Kamisato,The MET,Lucy,3500.0\n" +
                          "______________________________________________________\n" +
                          "total management Fee: 650.0";

        assertEquals(expected, company.toString().trim());
    }
}

