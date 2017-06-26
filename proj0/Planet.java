public class Planet {
	double xxPos;
	double yyPos;
	double xxVel;
	double yyVel;
	double mass;
	String imgFileName;

   
   /** The First Planet Constructor. */
	public Planet (double xP, double yP, double xV,
			       double yV, double m, String img) {
		this.xxPos = xP;
		this.yyPos = yP;
		this.xxVel = xV;
		this.yyVel = yV;
		this.mass = m;
		this.imgFileName = img;
	}

    
    /** The Second Planet Constructor. */
	public Planet(Planet p) {
		this.xxPos = p.xxPos;
	    this.yyPos = p.yyPos;
	    this.xxVel = p.xxVel;
	    this.yyVel = p.yyVel;
	    this.mass = p.mass;
	    this.imgFileName = p.imgFileName;
	}

}