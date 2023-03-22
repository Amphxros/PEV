package Common.Genes;

/**
 * Basic Gen with min , max and tolerance to calculate the size of the alleles
 * @author Amph
 *
 */
public abstract class Gen{
	double min,max,tolerance;
	int length;
	
	
	public Gen(double min, double max, double tolerance) {
		this.min=min;
		this.max=max;
		this.tolerance=tolerance;
	}
	
	/**
	 * 
	 * @return the size of the gen
	 */
	public int getLength() {
		return this.length;
	}
	
	/**
	 * Fill the array / values of the gen
	 */
	public abstract void startGen();
	/**
	 * 
	 * @return the calculated fenotype based on the genotype
	 */
	public abstract double fenotype();
	/**
	 * Copys the values of the gen
	 * @param gen {@link Gen} to copy from
	 */
	public abstract void copyGen(Gen gen);
	/**
	 * inserts the value i in the position of the array
	 * @param i
	 * @param position
	 */
	public abstract void insert(int i, int position);
	
	/**
	 * 
	 */
	public abstract String toString(); 
	
	
}
