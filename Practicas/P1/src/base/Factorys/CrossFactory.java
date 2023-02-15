package base.Factorys;

public final class CrossFactory {
	
	
	private static CrossFactory instance;
	public CrossFactory(){
		if(this.instance==null) {
			this.instance=this;
		}
		
	}

	
	public void MonopointCrossing() {
		
	}
	public void MultipointCrossing() {
		
	}
	public void UniformCrossing() {
		
	}
	public static CrossFactory getInstance() {
		// TODO Auto-generated method stub
		return instance;
	}
}
