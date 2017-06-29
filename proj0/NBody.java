import java.awt.Image;


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

			/* Each column has the x- and y-coordinates of the initial postion,  then
			 * its x- and y-components of the initial velocity, then its mass, and
			 * finally the name of an image file used to display the planets. */

			int N = in.readInt();
            double radius = in.readDouble();

			System.out.println(radius + " is the radius of the universe. ");
		    return radius;
	} 


	/** Given a file name, return an array of Planets corresponding to the planets in the file. */
	public static Planet[] readPlanets(String planetsTxtPath) {
		/* Start reading in ./data/planets.txt */
		In in = new In(planetsTxtPath);
		int N = in.readInt();
        double radius = in.readDouble();

        Planet[] planets = new Planet[N];

        for (int i = 0; i < N; i ++) {
			double xxPos = in.readDouble();		
			double yyPos = in.readDouble();
			double xxVel = in.readDouble();
			double yyVel = in.readDouble();
			double mass = in.readDouble();
			String imgFileName = in.readString();
			planets[i] = new Planet(xxPos, yyPos, xxVel, yyVel, mass, imgFileName); /* The first constructor in Planet.java. */

		}
		return planets;
	}


    public static void main(String[] args) {

        /* Initial Drawing Setion */
    	// Collecting all needed input.
    	double T = Double.parseDouble(args[0]);
    	double dt = Double.parseDouble(args[1]);
    	String filename = args[2];

    	Planet[] planets = readPlanets(filename);
    	double radius = readRadius(filename);

    	// Drawing the background.
        StdDraw.setScale(-radius, radius);	
        StdDraw.picture(0, 0, "./images/starfield.jpg");

        // Drawing all of the planets. */
        for(Planet p : planets) {
        	p.draw();
        } 


        /* Animation Creation */
        double time = 0;
        // Background Audio
        StdAudio.play("./audio/2001.mid");
        
        while(time != T) {

        	double[] xForces = new double[planets.length];
        	double[] yForces = new double[planets.length];

        	for(int i = 0; i < planets.length; i++) {
        		xForces[i] = planets[i].calcNetForceExertedByX(planets);
        		yForces[i] = planets[i].calcNetForceExertedByY(planets);
        	}

            for(int i = 0; i < planets.length; i++) {
            	planets[i].update(dt, xForces[i], yForces[i]);
            }
        	
        	StdDraw.picture(0, 0, "./images/starfield.jpg");

        	for(Planet p : planets) {
        	p.draw();
        	} 

        	StdDraw.show(10);

            time += dt;
        }
  
    } /** End of Main. */

} /* End of Class. */
