package propertypackage;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PlotTestStudent {
    private Plot plot;

    @BeforeEach
    public void setUp() {
        plot = new Plot(0, 0, 5, 5);
    }

    @Test
    public void testConstructor() {
        assertEquals(0, plot.getX());
        assertEquals(0, plot.getY());
        assertEquals(5, plot.getWidth());
        assertEquals(5, plot.getDepth());
    }

    @Test
    public void testCopyConstructor() {
        Plot copyPlot = new Plot(plot);
        assertEquals(plot.getX(), copyPlot.getX());
        assertEquals(plot.getY(), copyPlot.getY());
        assertEquals(plot.getWidth(), copyPlot.getWidth());
        assertEquals(plot.getDepth(), copyPlot.getDepth());
    }

    @Test
    public void testOverlaps() {
        Plot overlappingPlot = new Plot(3, 3, 5, 5);
        assertTrue(plot.overlaps(overlappingPlot));

        Plot nonOverlappingPlot = new Plot(10, 10, 2, 2);
        assertFalse(plot.overlaps(nonOverlappingPlot));
    }

    @Test
    public void testEncompasses() {
        Plot innerPlot = new Plot(1, 1, 2, 2);
        assertTrue(plot.encompasses(innerPlot));

        Plot outsidePlot = new Plot(-1, -1, 7, 7);
        assertFalse(plot.encompasses(outsidePlot));
    }

    @Test
    public void testSettersAndGetters() {
        plot.setX(2);
        plot.setY(2);
        plot.setWidth(6);
        plot.setDepth(6);

        assertEquals(2, plot.getX());
        assertEquals(2, plot.getY());
        assertEquals(6, plot.getWidth());
        assertEquals(6, plot.getDepth());
    }

    @Test
    public void testToString() {
        assertEquals("0,0,5,5", plot.toString());
    }
}

