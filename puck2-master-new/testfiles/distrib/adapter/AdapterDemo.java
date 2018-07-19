package adapter.candidate;

//BEFORE - Because the interface between Line and
//Rectangle objects is incapatible, the user has to
//recover the type of each shape and manually supply
//the correct arguments.

class LegacyLine {
	public void draw( int x1, int y1, int x2, int y2 ) {
		System.out.println( "line from (" + x1 + ',' + y1
				+ ") to (" + x2 + ',' + y2 + ')' );
	}  
}

class LegacyRectangle {
	public void draw( int x, int y, int w, int h ) {
		System.out.println( "rectangle at (" + x + ',' + y
				+ ") with width " + w + " and height " + h );
	}  
}

public class AdapterDemo {
	
	/*
	 * original candidate
	 */
/*
	public static void main( String[] args ) {
		Object[] shapes = { new LegacyLine(),
				new LegacyRectangle() };
		// A begin and end point from a graphical editor
		int x1 = 10, y1 = 20;
		int x2 = 30, y2 = 60;
		for (int i=0; i < shapes.length; ++i)
			if (shapes[i].getClass().getName().equals("LegacyLine"))
				((LegacyLine)shapes[i]).draw( x1, y1, x2, y2 );
			else if (shapes[i].getClass().getName().equals("LegacyRectangle"))
						((LegacyRectangle)shapes[i]).draw(
						Math.min(x1,x2), Math.min(y1,y2),
						Math.abs(x2-x1), Math.abs(y2-y1) );
	}  
*/
	
	
	/*
	 * candidate with method extracted:
	 */
	
	public static void drawLine(LegacyLine line,  int x1, int y1, int x2, int y2 ){
		line.draw( x1, y1, x2, y2 );
	}
	
	public static void drawRectangle(LegacyRectangle line,  int x1, int y1, int x2, int y2 ){
		line.draw(Math.min(x1,x2), Math.min(y1,y2),
					Math.abs(x2-x1), Math.abs(y2-y1));
	}
	
	public static void main( String[] args ) {
		Object[] shapes = { new LegacyLine(),
							new LegacyRectangle() };
		// A begin and end point from a graphical editor
		int x1 = 10, y1 = 20;
		int x2 = 30, y2 = 60;
		for (int i=0; i < shapes.length; ++i)
//			if (shapes[i].getClass().getName().equals("LegacyLine"))
			if (shapes[i] instanceof LegacyLine)
				drawLine((LegacyLine)shapes[i], x1, y1, x2, y2 );
//			else if (shapes[i].getClass().getName().equals("LegacyRectangle"))
			else if (shapes[i] instanceof LegacyRectangle)
				drawRectangle((LegacyRectangle)shapes[i], x1, y1, x2, y2 );
	}  	
}
