package base.Genes;

public class BooleanGen extends Gen<Boolean> {
	
	public String toString() {
		// TODO Auto-generated method stub
		if(this.getAllele()) {
			return "1";
		}
		else {
			return "0";
		}
	}
	
}
