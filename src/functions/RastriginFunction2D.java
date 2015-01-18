package functions;

public class RastriginFunction2D implements Function {
	
	public double getResult(double x){
		return 	(Math.pow(x,2) - 10*Math.cos(2*Math.PI*x));
	}
}
