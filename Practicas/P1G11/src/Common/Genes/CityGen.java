package Common.Genes;

public class CityGen extends Gen{
	
	int allele; //city
	public CityGen(int city) {
		super(0,0,0);
		this.allele=city;
		this.length=1;
	}


	@Override
	public void startGen() {
		// No needed
		
	}

	@Override
	public double fenotype() {
		// TODO Auto-generated method stub
		return this.allele;
	}

	@Override
	public void copyGen(Gen gen) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void insert(int i, int position) {
		// TODO Auto-generated method stub
		this.allele=i;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
