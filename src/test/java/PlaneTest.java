import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PlaneTest {
    Plane plane;

    @Before
    public void setUp() throws Exception {
        plane = new Plane(PlaneType.BOEING747);
    }

    @Test
    public void hasPlaneType() {
        assertEquals(PlaneType.BOEING747, plane.getPlaneType());
    }

    @Test
    public void hasCapacity() {
        assertEquals(524, plane.getCapacity());
    }

    @Test
    public void hasWeight() {
        assertEquals(333400, plane.getWeight());
    }
}
