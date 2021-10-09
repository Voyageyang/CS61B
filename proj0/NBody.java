public class NBody {
	public static void main(String[] args) {

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