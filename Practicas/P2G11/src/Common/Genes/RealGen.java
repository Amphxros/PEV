package Common.Genes;

public class RealGen extends Gen{

	double allele;
	public RealGen(double min, double max, double tolerance) {
		super(min, max, tolerance);
		this.length=1;
		// TODO Auto-generated constructor stub
	}
	@Override
	public void startGen() {
		allele =  this.min + (this.max - this.min)* Math.random();
		
	}
	@Override
	public double fenotype() {
		// TODO Auto-generated method stub
		return allele;
	}
	@Override
	public void copyGen(Gen gen) {
		// TODO Auto-generated method stub
		this.length=gen.length;
		this.max=gen.max;
		this.min=gen.min;
		this.allele=((RealGen)gen).allele;
	}
	@Override
	public void insert(int i, int position) {
		// TODO Auto-generated method stub
		this.allele=i;
	}
	
	public void setAllele(double allele) {
		this.allele=allele;
	}
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return Double.toString(allele);
	}
	

}
