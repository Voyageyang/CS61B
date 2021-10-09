public class NBody {

	private static String imageToDraw = "./images/starfield.jpg";

	public static void main(String[] args) {
		double T = Double.parseDouble(args[0]);
		double dt = Double.parseDouble(args[1]);
		String filename = args[2];
		double radius = readRadius(filename);
		Planet[] planets = readPlanets(filename);
		StdDraw.setScale(-5e11, 5e11);
		StdDraw.enableDoubleBuffering();
		double time = 0;
		while(time < T) {
			double[] xForces = new double[planets.length];
			double[] yForces = new double[planets.length];
			for(int i = 0; i < planets.length; i++) {
				xForces[i] = planets[i].calcNetForceExertedByX(planets);
				yForces[i] = planets[i].calcNetForceExertedByY(planets);
			}
			for(int i = 0; i < planets.length; i++) {
				planets[i].update(dt, xForces[i], yForces[i]);
			}
			
			StdDraw.clear();
			StdDraw.picture(0, 0, imageToDraw);
			for(int i = 0; i < planets.length; i++) {
				planets[i].draw();
			}
			StdDraw.show();
			StdDraw.pause(10);
			time += dt;
		}
		StdOut.printf("%d\n", planets.length);
		StdOut.printf("%.2e\n", radius);
		for (int i = 0; i < planets.length; i++) {
    		StdOut.printf("%11.4e %11.4e %11.4e %11.4e %11.4e %12s\n",
                planets[i].xxPos, planets[i].yyPos, planets[i].xxVel,
                planets[i].yyVel, planets[i].mass, planets[i].imgFileName);   
		}
	}


	public static double readRadius(String img) {
		In in = new In(img);
		int numberOfPlanets = in.readInt();
		double radius = in.readDouble();
		return radius;
	}

	public static Planet[] readPlanets(String img) {
		In in = new In(img);
		int numberOfPlanets = in.readInt();
		double radius = in.readDouble();
		Planet[] planets = new Planet[numberOfPlanets];
		for(int i = 0; i < numberOfPlanets; i++) {
			planets[i] = new Planet(0, 0, 0, 0, 0, "");
			planets[i].xxPos = in.readDouble();
			planets[i].yyPos = in.readDouble();
			planets[i].xxVel = in.readDouble();
			planets[i].yyVel = in.readDouble();
			planets[i].mass = in.readDouble();
			planets[i].imgFileName = in.readString();
		}
		return planets;
	}
}