public class Planet {
	public double xxPos;
	public double yyPos;
	public double xxVel;
	public double yyVel;
	public double mass;
	public String imgFileName;

	static final double g = 6.67e-11;

	public Planet(double xP, double yP, double xV, double yV, double m, String img) {
		xxPos = xP;
		yyPos = yP;
		xxVel = xV;
		yyVel = yV;
		mass = m;
		imgFileName = img;
	}

	public Planet(Planet p) {
		xxPos = p.xxPos;
		yyPos = p.yyPos;
		xxVel = p.xxVel;
		yyVel = p.yyVel;
		mass = p.mass;
		imgFileName = p.imgFileName;
	}

	public double calcDistance(Planet p) {
		double dx = this.xxPos - p.xxPos;
		double dy = this.yyPos - p.yyPos;
		return Math.sqrt(dx * dx + dy * dy);
	}

	public double calcForceExertedBy(Planet p) {
		return g * this.mass * p.mass / Math.pow(this.calcDistance(p), 2);
	}

	public double calcForceExertedByX(Planet p) {
		double cosin = (p.xxPos - this.xxPos) / this.calcDistance(p);
		return this.calcForceExertedBy(p) * cosin;
	}

	public double calcForceExertedByY(Planet p) {
		double sin = (p.yyPos - this.yyPos) / this.calcDistance(p);
		return this.calcForceExertedBy(p) * sin;
	}

	public double calcNetForceExertedByX(Planet[] p) {
		double force = 0;
		for(int i = 0; i < p.length; i++) {
			if(p[i].equals(this)) continue;
			force += this.calcForceExertedByX(p[i]);
		}
		return force;
	}

	public double calcNetForceExertedByY(Planet[] p) {
		double force = 0;
		for(int i = 0; i < p.length; i++) {
			if(p[i].equals(this)) continue;
			force += this.calcForceExertedByY(p[i]);
		}
		return force;
	}

	public void update(double dt, double fX, double fY) {
		double accelerationOfX = fX / this.mass;
		double accelerationOfY = fY / this.mass;
		this.xxVel = this.xxVel + dt * accelerationOfX;
		this.yyVel = this.yyVel + dt * accelerationOfY;
		this.xxPos = this.xxPos + dt * this.xxVel;
		this.yyPos = this.yyPos + dt * this.yyVel;
	}

	public void draw() {
		StdDraw.picture(this.xxPos, this.yyPos, "./images/" + this.imgFileName);

		/* Shows the drawing to the screen, and waits 2000 milliseconds. */
		StdDraw.show();
	}
}