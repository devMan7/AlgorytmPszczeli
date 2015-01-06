package functions;

public class RastriginFunction {
	private int nDimensions;
	private double[] leftBounds;
	private double[] rightBounds;


	public RastriginFunction(){
        nDimensions = 1;
        init();
}

public RastriginFunction(int nDimensions){
        this.nDimensions = nDimensions;
        init();
}

private void init() {
        leftBounds = new double[nDimensions];
        rightBounds = new double[nDimensions];
        for (int i = 0; i < nDimensions; i++) {
                leftBounds[i] = -5.12;
                rightBounds[i] = 5.12;
        }
}


public double getFitness(double[] position) {
        double sum = 0.0;
        for (int i = 0; i < nDimensions; i++) {
                double xi = position[i];
                sum += (xi * xi) - (10.0 * Math.cos(2.0 * Math.PI * xi));
        }
        return (10.0 * nDimensions) + sum;
}

}
