package Common.Genes;

public abstract class Gen{
	double min,max,tolerance;
	int length;
	
	public Gen(double min, double max, double tolerance) {
		this.min=min;
		this.max=max;
		this.tolerance=tolerance;
	}
	public abstract void startGen();
	public abstract double fenotype();
	public abstract void copyGen(Gen gen);
	public abstract void insert(int i, int position);
	public abstract String toString(); 
}
