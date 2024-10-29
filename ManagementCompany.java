package propertypackage;
/*
 * Class: CMSC203 
 * Instructor: Aygun
 * Description:
 * Due: MM/DD/YYYY
 * Platform/compiler: Eclipse
 * I pledge that I have completed the programming 
assignment independently. 
 * I have not copied the code from a student or any source. 
 * I have not given my code to any student.
 * Print your Name here: Jade Belinga
*/
public class ManagementCompany {

	    private String name;
	    private String taxID;
	    double mgmtFee;
	    private Plot plot;
	    private Property[] properties;
	    private int propertyCount;

	    public static final int MAX_PROPERTY = 5;
	    public static final int MGMT_WIDTH = 10;
	    public static final int MGMT_DEPTH = 10;

	    // Default constructor
	    public ManagementCompany() {
	        this.name = "";
	        this.taxID = "";
	        this.mgmtFee = 0.0;
	        this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
	        this.properties = new Property[MAX_PROPERTY];
	        this.propertyCount = 0;
	    }

	    // Constructor with name, taxID, and management fee percentage
	    public ManagementCompany(String name, String taxID, double mgmtFee) {
	        this.name = name;
	        this.taxID = taxID;
	        this.mgmtFee = mgmtFee;
	        this.plot = new Plot(0, 0, MGMT_WIDTH, MGMT_DEPTH);
	        this.properties = new Property[MAX_PROPERTY];
	        this.propertyCount = 0;
	    }

	    // Constructor with name, taxID, management fee, and a custom plot
	    public ManagementCompany(String name, String taxID, double mgmtFee, int x, int y, int width, int depth) {
	        this.name = name;
	        this.taxID = taxID;
	        this.mgmtFee = mgmtFee;
	        this.plot = new Plot(x, y, width, depth);
	        this.properties = new Property[MAX_PROPERTY];
	        this.propertyCount = 0;
	    }

	    // Copy constructor
	    public ManagementCompany(ManagementCompany otherCompany) {
	        this.name = otherCompany.name;
	        this.taxID = otherCompany.taxID;
	        this.mgmtFee = otherCompany.mgmtFee;
	        this.plot = new Plot(otherCompany.plot);
	        this.properties = new Property[MAX_PROPERTY];
	        this.propertyCount = otherCompany.propertyCount;

	        for (int i = 0; i < otherCompany.propertyCount; i++) {
	            this.properties[i] = new Property(otherCompany.properties[i]);
	        }
	    }

	    // Getter methods
	    public String getName() {
	        return name;
	    }

	    public Plot getPlot() {
	        return plot;
	    }

	    public int getPropertyCount() {
	        return propertyCount;
	    }

	    // Method to add a property to the management company
	    public int addProperty(Property property) {
	        if (propertyCount >= MAX_PROPERTY) return -1;
	        if (property == null) return -2;
	        if (!plot.encompasses(property.getPlot())) return -3;

	        for (int i = 0; i < propertyCount; i++) {
	            if (properties[i].getPlot().overlaps(property.getPlot())) return -4;
	        }

	        properties[propertyCount] = new Property(property);
	        return propertyCount++;
	    }

	    // Method to calculate total rent of all properties
	    public double getTotalRent() {
	        double totalRent = 0;
	        for (int i = 0; i < propertyCount; i++) {
	            totalRent += properties[i].getRentAmount();
	        }
	        return totalRent;
	    }

	    // Method to get the property with the highest rent
	    public Property getHighestRentProperty() {
	        if (propertyCount == 0) return null;

	        Property highestRentProperty = properties[0];
	        for (int i = 1; i < propertyCount; i++) {
	            if (properties[i].getRentAmount() > highestRentProperty.getRentAmount()) {
	                highestRentProperty = properties[i];
	            }
	        }
	        return highestRentProperty;
	    }

	    // Method to remove the last property in the array
	    public void removeLastProperty() {
	        if (propertyCount > 0) {
	            properties[--propertyCount] = null;
	        }
	    }

	    // Check if properties array is full
	    public boolean isPropertiesFull() {
	        return propertyCount >= MAX_PROPERTY;
	    }

	    // Check if the management fee is valid (between 0 and 100)
	    public boolean isManagementFeeValid() {
	        return mgmtFee >= 0 && mgmtFee <= 100;
	    }

	    // toString method to represent the company and all its properties
	    public String toString() {
	        StringBuilder sb = new StringBuilder();
	        sb.append("List of the properties for ").append(name)
	          .append(", taxID: ").append(taxID).append("\n")
	          .append("______________________________________________________\n");

	        for (int i = 0; i < propertyCount; i++) {
	            sb.append(properties[i].toString()).append("\n");
	        }

	        sb.append("______________________________________________________\n")
	          .append("total management Fee: ").append(getTotalRent() * (mgmtFee / 100));

	        return sb.toString();
	    }

}
