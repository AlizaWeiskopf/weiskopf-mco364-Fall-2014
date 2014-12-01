package sphere;

public class Sphere {

	private double diameter, surfaceArea, volume;

	public Sphere(double d){
		diameter = d;
	}

	public double Getdiameter(){

		return diameter;

	}

	public void Setdiameter(double d){

		diameter = d;

	}

	public double Volume(double volume){

		double radius = diameter / 2;

		double radiusRaised = (double) Math.pow(radius, 3);

		volume = (3.14 * 4 / 3) * (radiusRaised);

		return volume;

	}

	public double SurfaceArea(double surfaceArea){
		
		double radius = diameter / 2;

		surfaceArea = (4 / 3 * 3.14) * (Math.pow(radius, 2));

		return surfaceArea;

	}

	public String toString(){

		String sphereInfo = "The diameter of the sphere is " + diameter + " the volume is " + volume +

		" and the surface area is " + surfaceArea;

		return sphereInfo;

	}

}
