public class NBody {
/** Read radius file from data folder.
  * @author Yujia Zhai 
  */


	public static double readRadius(String planetsTxtPath) {
		
		if (planetsTxtPath == null) {
			System.out.println("Please supplu a file name as a command line argument.");
			System.out.println("For file names with spaces, use an underscore, e.g. plain_planet");
			/* System.exit ends the program early. */
			System.exit(0);
		}

		/* Start reading in ./data/planets.txt */
		In in = new In(planetsTxtPath);

			/* Each line has N the number of planets, then 
			 * R the radius of the universe, and 
			 * finally N rows of planets data. */

			/* Each column has the x- and y-coordinates of the initial postion,  then its
			 * x- and y-components of the initial velocity, then its mass, and
			 * finally the name of an image file used to display the planets. */

			int N = in.readInt();
            double radius = in.readDouble();
            /*
			double xxPos = in.readDouble();
			double yyPos = in.readDouble();
			double xxVel = in.readDouble();
			double yyVel = in.readDouble();
			double mass = in.readDouble();
			String imgFileName = in.readString();
			*/

			System.out.println(radius + " is the radius of the universe. ");
		    return radius;
	} 
	
} /* End of Class. */
