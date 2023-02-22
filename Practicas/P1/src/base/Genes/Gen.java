package base.Genes;

public abstract class Gen<T>{
	protected T allele;
	protected int dimGen;
	protected int min, max;
	protected Gen() {}
	
	public Gen(Gen<T> other) {
		this.allele=other.allele;
		this.dimGen=other.dimGen;
	}
	
	public T getAllele() {
		return allele;
	}
	public int length() {
		return dimGen;
	}
	
	public void setAllele(T allele) {
		this.allele= allele;
	}
	public abstract String toString();
	
	public boolean equals(Object o) {
		if(o.getClass() == this.getClass()) {
			if (this.getAllele() == ((Gen<T>)o).getAllele()) {
				return true;
			}
		}
		
		return false;
	}
}
