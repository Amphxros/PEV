package Common.Genes;

public class BooleanGen extends Gen<Boolean>{

	public BooleanGen(boolean allele) {
		super(allele);
	}
	@Override
	public String toString() {
		if(this.allele) {
			return "1";
		}
		else {
			return "0";
		}
	}

}
