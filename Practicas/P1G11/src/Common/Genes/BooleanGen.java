package Common.Genes;

import java.util.Random;

/**
 * Binary gen
 * @author Amph
 *
 */
public class BooleanGen extends Gen{

	boolean[] alelles;
	public BooleanGen(double min, double max, double tolerance) {
		super(min, max, tolerance);
		// TODO Auto-generated constructor stub
		this.calculateLength();
		this.alelles= new boolean[this.length];
	}

	private void calculateLength(){
		this.length = (int) Math.ceil(Math.log(1 + (max-min)/tolerance)/Math.log(2));
	}
	@Override
	public void startGen() {
		// TODO Auto-generated method stub
		Random rnd= new Random();
		for(int i=0; i<this.length;i++) {
			this.alelles[i]= rnd.nextBoolean();
		}
	}

	@Override
	public double fenotype() {
		double fenotype = min + (max - min) * binToDec()/(Math.pow(2,this.length) - 1);
		return fenotype;
	}

	@Override
	public void copyGen(Gen gen) {
		this.length= gen.length;
		this.max=gen.max;
		this.min=gen.min;
		this.tolerance=gen.tolerance;
		
		for(int i=0;i<this.length;i++) {
			this.alelles[i]=((BooleanGen)gen).alelles[i];
		}
		
	}
	
	public boolean[] getAlelles() {
		return this.alelles;
	}
	
	public boolean getAlelle(int position) {
		return this.alelles[position];
	}


	public void setAlelles(boolean[] alelles) {
		this.alelles=alelles;
	}

	@Override
	public void insert(int i, int position) {
	
		this.alelles[position]= i==1;
	}
	
	private int binToDec(){
		int decimal = 0;
		for(int i = 0; i < this.length; i++) 
		{
			int bin=0;
			if(this.alelles[i]) {
				bin=1;
			}
			decimal += Math.pow(2,i)*bin;
		}
		return decimal;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		String msg="";
		for(int i=0;i<this.length;i++) {
			if(this.alelles[i])
				msg+="1";
			else
				msg+="0";
		}
		
		return msg;
	}


}
