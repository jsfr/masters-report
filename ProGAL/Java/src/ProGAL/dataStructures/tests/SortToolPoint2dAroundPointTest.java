package ProGAL.dataStructures.tests;

import static org.junit.Assert.*;

import org.junit.Test;

import ProGAL.dataStructures.SortTool;
import ProGAL.dataStructures.SortToolPoint2dAroundPoint;
import ProGAL.geom2d.Point;

public class SortToolPoint2dAroundPointTest {

	@Test
	public void testCompare() {
		SortToolPoint2dAroundPoint tool = new SortToolPoint2dAroundPoint(new Point(1,1));
		assertEquals(SortTool.COMP_LESS, tool.compare(new Point(2,1), new Point(3,2)));
		assertEquals(SortTool.COMP_LESS, tool.compare(new Point(2,1.01), new Point(3,2)));
		assertEquals(SortTool.COMP_GRTR, tool.compare(new Point(2,2), new Point(3,1.1)));
		assertEquals(SortTool.COMP_EQUAL, tool.compare(new Point(2,1), new Point(2,1)));
		assertEquals(SortTool.COMP_GRTR, tool.compare(new Point(2,1), new Point(3,1)));
	}

}
