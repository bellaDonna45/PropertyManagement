package propertypackage;

public class Property {

	    private String propertyName;
	    private String city;
	    private double rentAmount;
	    private String owner;
	    private Plot plot;

	   
	    public Property() {
	        propertyName = "";
	        city = "";
	        rentAmount = 0.0;
	        owner = "";
	        plot = new Plot();
	    }
	    public Property(String propName, String cty, double rents, String owns) {
	        propertyName = propName;
	        city = cty;
	        rentAmount = rents;
	        owner = owns;
	        plot = new Plot(); 
	    }

	    public Property(String prop, String cit, double rent, String own, int x, int y, int wid, int dep) {
	        propertyName = prop;
	        city = cit;
	        rentAmount = rent;
	        owner = own;
	        plot = new Plot(x,y,wid,dep); 
	    }

	    public Property(Property otherProp) {
	        propertyName = otherProp.propertyName;
	        city = otherProp.city;
	        rentAmount = otherProp.rentAmount;
	        owner = otherProp.owner;
	        plot = new Plot(otherProp.plot); 
	    }

	    
	   
		public String getPropertyName() {
	        return propertyName;
	    }
	    public String getCity() {
	        return city;
	    }
	    public double getRentAmount() {
	        return rentAmount;
	    }
	    public Plot getPlot() {
	        return plot;
	    }
	    public String getOwner() {
	        return owner;
	    }
	    
	    
	    public void setPropertyName(String properName) {
	        propertyName = properName;
	    }

	    

	    public void setCity(String cty) {
	        city = cty;
	    }

	   

	    public void setRentAmount(double rentalAmount) {
	        rentAmount = rentalAmount;
	    }

	    

	    public void setOwner(String own) {
	        owner = own;
	    }

	    

	    public void setPlot(Plot pt) {
	        plot = new Plot(pt); 
	    }

	    
	    public String toString() {
	        return propertyName + "," + city + "," + owner + "," + rentAmount;
	    }

//ジェイド;)
}
