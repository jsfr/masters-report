package ProGAL.dataStructures;

import ProGAL.geom2d.Point;

/**
 * The compare method indicates the relation between two points based on the 2d rotation around 
 * the 'anchor point' given to the constructor. Given the anchor, a, a point p1 is considered 
 * larger than a point p2 if the polar angle of (p1-a) is larger than that of (p2-a) (and vice 
 * versa for smaller and equal).  
 */
public class SortToolPoint2dAroundPoint implements SortTool{
	Point p;

	/**
	 * Initialize sort tool with <code>p</code> as anchor
	 */
	public SortToolPoint2dAroundPoint(Point p) {
		super();
		this.p = p;
	}

	public int compare(Object p1, Object p2) {
		if( !(p1 instanceof Point) || !(p2 instanceof Point)) 
			throw SortTool.err1;
//		double x = p.x();
//		double y = p.y();
//		double x1 = ((Point)p1).x() - x; 
//		double x2 = ((Point)p2).x() - x;
//		double y1 = ((Point)p1).y() - y;
//		double y2 = ((Point)p2).y() - y;
//		
//		if(x1==x2 && y1==y2) return COMP_EQUAL;
//		
//		if (y1 > y) {
//			if (y2 < y) return COMP_LESS; 
//			if (y2 > y) {
//				if (Point.leftTurn(p, (Point)p1, (Point)p2)) return COMP_LESS;
//				if ((Point.collinear(p, (Point)p1, (Point)p2)) &&
//						((x1-x)*(x1-x) + (y1-y)*(y1-y) < (x2-x)*(x2-x) + (y2-y)*(y2-y))) return COMP_LESS; else return COMP_GRTR;
//			}
//			if (x2 >= x) return COMP_GRTR; else return COMP_LESS;
//		}
//		if (y1 < y) {
//			if (y2 >= y) return COMP_GRTR;
//			if (Point.leftTurn(p, (Point)p1, (Point)p2)) return COMP_LESS;
//			if ((Point.collinear(p, (Point)p1, (Point)p2)) &&
//					((x1-x)*(x1-x) + (y1-y)*(y1-y) < (x2-x)*(x2-x) + (y2-y)*(y2-y))) return COMP_LESS; else return COMP_GRTR;
//		}
//		if (x1 >= x) {
//			if ((y2 == y) && ((x1 < x2) || (x2 < x))) return COMP_LESS; else return COMP_GRTR;
//		}
//		if (y2 > y) return COMP_GRTR;						
//		if (y2 < y) return COMP_LESS;
//		if (x2 > x1)  return COMP_GRTR; else return COMP_LESS;

		//TODO: This can be done more efficiently
		Point p_1 = (Point)p1;
		Point p_2 = (Point)p2;
		if(Point.collinear(p, p_1, p_2)) return -Double.compare(p.distanceSquared(p_1), p.distanceSquared(p_2));
		return Double.compare(p.vectorTo(p_1).toPoint().polarAngle(), p.vectorTo(p_2).toPoint().polarAngle());
		
	}
}
