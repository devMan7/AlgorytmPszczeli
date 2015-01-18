package functions;

public class MichalewiczFunction2D implements Function{
	
	public double getResult(double x){
		return 	Math.sin(x) * Math.pow(Math.sin((x * x)/Math.PI), 2*5);
	}
}