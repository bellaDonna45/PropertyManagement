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

public class Plot {

	    private int x, y, depth, width;

	    
	    public Plot() {
	        x = 0;
	        y = 0;
	        depth = 1;
	        width = 1;
	    }

	    public Plot(int ex, int why, int wid, int dep) {
	        x = ex;
	        y = why;
	        depth = dep;
	        width = wid;
	    }
	    public Plot(Plot p) {
	        this.x = p.x;
	        this.y = p.y;
	        this.width = p.width;
	        this.depth = p.depth;
	    }

	    public int getX() {
	        return x;
	    }

	    public int getY() {
	        return y;
	    }
	    public int getDepth() {
	        return depth;
	    }
	    public int getWidth() {
	        return width;
	    }

	    

	    
	    public void setX(int ex) {
	        x = ex;
	    }

	    public void setY(int why) {
	        y = why;
	    }
	    public void setDepth(int dep) {
	        depth = dep;
	    }
	    public void setWidth(int wid) {
	        width = wid;
	    }

	   


	    public boolean overlaps(Plot plot) {
	        return !(plot.x >= x + width || plot.x + plot.width <= x ||	plot.y >= y + depth || plot.y + plot.depth <= y);
	    }

	    public boolean encompasses(Plot plot) {
	        return (plot.x >= x && plot.x + plot.width <= x + width &&
	               plot.y >= y && plot.y + plot.depth <= y + depth);
	    }

	   
	    public String toString() {
	        return (x + "," + y + "," + width + "," + depth);
	    }


}
